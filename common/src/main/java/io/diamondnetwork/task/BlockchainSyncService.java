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
     * 同步转账交易，转账交易包含了内置货币和代币的直接转账
     * 1. 记录交易记录
     * 2. 记录转账记录 （币种，金额，发送者，接收者，手续费）-- 一条交易可以对应多条转账（transfer）记录
     * 3. 如果发送者或者接收者在数据库不存在，则添加
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
                //理论上可能有多个手续费，只处理
                tx.setFee(Long.valueOf(t.getTx().getValue().getFee().getAmount().get(0).getAmount()));


                //如果交易所属的区块还没有， 则先同步区块
                if (blockService.getBlock(tx.getHeight()) == null) {
                    syncBlock(tx.getHeight());
                } else {
                    //增加所属区块的手续费
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

                //检查目标地址，如果这个地址不存在account中，则新建一个账号
                for (BankTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean msgBean : t.getTx().getValue().getMsg()) {
                    if (msgBean.getType().equals("bankx/MsgSend")) {
                        if (accountService.countAccounts(msgBean.getValue().getTo_address()) == 0) {
                            accountService.addAccount(fromTx(t.getTimestamp(), t.getHeight(),msgBean.getValue().getTo_address()));
                        }
                        if (accountService.countAccounts(msgBean.getValue().getFrom_address()) == 0) {
                            accountService.addAccount(fromTx(t.getTimestamp(), t.getHeight(),msgBean.getValue().getFrom_address()));
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
     * 同步代币的发行记录，保存到资产表
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

                //检查目标地址，如果这个地址不存在account中，则新建一个账号
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


                    }
                }

            }

            return response.getTxs().size();
        }

        return 0;
    }

    /**
     * 同步交易所交易，包括创建市场，订单
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int syncMarketOrder(int page, int limit) throws IOException {
        return -1;
    }

}
