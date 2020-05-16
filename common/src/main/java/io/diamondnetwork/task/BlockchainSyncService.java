package io.diamondnetwork.task;

import io.diamondnetwork.model.*;
import io.diamondnetwork.model.enums.TransactionType;
import io.diamondnetwork.service.*;
import io.diamondnetwork.task.response.AssetTxResponse;
import io.diamondnetwork.task.response.BankTxResponse;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Slf4j
public class BlockchainSyncService {
    @Autowired
    private BlockService blockService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private AssetService assetService;

    @Autowired
    BlockchainService blockchainService;

    @Transactional(rollbackFor = RuntimeException.class)
    public int syncBlock(int height) throws IOException {
        Block b = blockService.getBlock(height);
        if (b != null) {
            return height;
        }
        BlockDetail body = blockchainService.getBlock(height);
        if (body == null) {
            return 0;
        }

        Block block = Block.from(body);
        Block existed = blockService.getBlock(height);
        if (existed == null) {
            blockService.addBlock(block);
        }

        return height;
    }

    /**
     * @param page
     * @param limit
     * @return
     * @throws IOException
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int syncTransfer(int page, int limit) throws IOException {
        BankTxResponse response = blockchainService.searchBankTxs("bankx", page,limit);
        if (response != null && response.getTxs() != null && response.getTxs().size() > 0) {
            for (BankTxResponse.TxsBean t : response.getTxs()) {
                Transaction tx = new Transaction();
                tx.setHash(t.getTxhash());
                tx.setHeight(Integer.valueOf(t.getHeight()));
                tx.setFee(Long.valueOf(t.getTx().getValue().getFee().getAmount().get(0).getAmount()));


                if (blockService.getBlock(tx.getHeight()) == null) {
                    syncBlock(tx.getHeight());
                } else {
                    blockService.addFeeToHeight(tx.getHeight(), tx.getFee());
                }

                tx.setCreatedAt(DateUtil.getTxTime(t.getTimestamp()));

                tx.setSuccess(t.getLogs().get(0).isSuccess());

                tx.setMsgNum(t.getTx().getValue().getMsg().size());
                tx.setType(TransactionType.TRANSFER);
                for (BankTxResponse.TxsBean.EventsBeanX event : t.getEvents()) {
                    if (event.getType().equals("message")) {
                        for (BankTxResponse.TxsBean.EventsBeanX.AttributesBeanX attribute : event.getAttributes()) {
                            if (attribute.getKey().equals("sender")) {
                                tx.setSender(attribute.getValue());
                            }
                        }

                    }
                }
                tx.setMemo(t.getTx().getValue().getMemo());

                if (transactionService.countTxByHash(tx.getHash()) == 0) {
                    transactionService.addTx(tx);
                }

                for (BankTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean msgBean : t.getTx().getValue().getMsg()) {
                    if (msgBean.getType().equals("bankx/MsgSend")) {
                        if (accountService.countAccounts(msgBean.getValue().getTo_address()) == 0) {
                            accountService.addAccount(fromTx(t.getTimestamp(), t.getHeight(),msgBean.getValue().getTo_address()));
                        }
                        if (accountService.countAccounts(msgBean.getValue().getFrom_address()) == 0) {
                            accountService.addAccount(fromTx(t.getTimestamp(), t.getHeight(),msgBean.getValue().getFrom_address()));
                        }

                        for (BankTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean.ValueBean.AmountBeanX amountBeanX : msgBean.getValue().getAmount()) {
                            Transfer transfer = new Transfer();
                            transfer.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            transfer.setSender(msgBean.getValue().getFrom_address());
                            transfer.setRecipient(msgBean.getValue().getTo_address());
                            transfer.setToken(amountBeanX.getDenom()).setAmount(Long.valueOf(amountBeanX.getAmount()));
                            transactionService.addTransfer(transfer);
                        }
                    }
                }



            }

            return response.getTxs().size();
        }

        return 0;
    }

    private Account fromTx(String timestamp, String height, String address) {
        Account a = new Account();
        a.setAssetNum(0);
        a.setTxNum(0);
        a.setCreatedAt(DateUtil.getTxTime(timestamp));
        a.setCreationHeight(Integer.valueOf(height));
        a.setAddress(address);
        return a;
    }

    /**
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int syncToken(int page, int limit) throws IOException {
        AssetTxResponse response = blockchainService.searchAssetTxs("asset", page,limit);
        if (response != null && response.getTxs() != null && response.getTxs().size() > 0) {
            for (AssetTxResponse.TxsBean t : response.getTxs()) {
                Transaction tx = new Transaction();
                tx.setHash(t.getTxhash());
                tx.setHeight(Integer.valueOf(t.getHeight()));
                tx.setCreatedAt(DateUtil.getTxTime(t.getTimestamp()));
                tx.setSuccess(t.getLogs().get(0).isSuccess());
                tx.setMsgNum(t.getTx().getValue().getMsg().size());
                tx.setType(TransactionType.ISSUE_TOKEN);
                for (AssetTxResponse.TxsBean.EventsBeanX event : t.getEvents()) {
                    if (event.getType().equals("message")) {
                        for (AssetTxResponse.TxsBean.EventsBeanX.AttributesBeanX attribute : event.getAttributes()) {
                            if (attribute.getKey().equals("sender")) {
                                tx.setSender(attribute.getValue());
                            }
                        }

                    }
                }
                tx.setMemo(t.getTx().getValue().getMemo());
                if (transactionService.countTxByHash(tx.getHash()) == 0) {
                    transactionService.addTx(tx);
                }

                for (AssetTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean msgBean : t.getTx().getValue().getMsg()) {
                    if (msgBean.getType().equals("asset/MsgIssueToken")) {
                        msgBean.getValue().getDescription();

                        Asset asset = new Asset();
                        asset.setCreatedAt(tx.getCreatedAt());
                        asset.setDecimals(0);
                        asset.setDescription(msgBean.getValue().getDescription());
                        asset.setName(msgBean.getValue().getSymbol());
                        asset.setCreationHeight(tx.getHeight());
                        asset.setTotalSupply(Long.valueOf(msgBean.getValue().getTotal_supply()));
                        asset.setIssuer(msgBean.getValue().getOwner());

                        if (assetService.countAssets(msgBean.getValue().getSymbol()) < 1) {
                            assetService.addAsset(asset);
                        }


                        Transfer transfer = new Transfer();
                        transfer.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                        transfer.setSender(msgBean.getValue().getOwner());
                        transfer.setRecipient(msgBean.getValue().getOwner());
                        transfer.setToken(msgBean.getValue().getSymbol())
                                .setAmount(Long.valueOf(msgBean.getValue().getTotal_supply()));
                        transactionService.addTransfer(transfer);

                    }
                }

            }

            return response.getTxs().size();
        }

        return 0;
    }

    /**
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int syncMarketOrder(int page, int limit) throws IOException {
        return -1;
    }

}
