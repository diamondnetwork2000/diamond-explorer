package io.diamondnetwork.task;

import io.diamondnetwork.model.*;
import io.diamondnetwork.model.enums.TransactionType;
import io.diamondnetwork.service.*;
import io.diamondnetwork.task.response.*;
import io.diamondnetwork.task.response.message.CreateOrderMessage;
import io.diamondnetwork.task.response.message.TxMessage;
import io.diamondnetwork.util.Constants;
import io.diamondnetwork.util.DateUtil;
import io.diamondnetwork.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigInteger;

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

    @Transactional(rollbackFor = RuntimeException.class)
    public int addNativeCoin() throws IOException {
        if (assetService.getAsset(Constants.nativeCoinName) != null) {
            return 0;
        }

        Block block = blockService.getBlock(1);

        if (block == null) {
            return 0;
        }

        TokenDetailResponse body = blockchainService.tokenDetail(Constants.nativeCoinName);
        if (body == null) {
            return 0;
        }


        Asset asset = new Asset();
        TokenDetailResponse.ResultBean.ValueBean coin = body.getResult().getValue();
        asset.setOwner(coin.getOwner())
                .setIssuer(coin.getOwner())
                .setCreationHeight(1)
                .setName(Constants.nativeCoinName)
                .setDecimals(8)
                .setTotalSupply(new BigInteger(coin.getTotal_supply()))
                .setDescription("Diamond DEX native coin")
                .setCreatedAt(block.getCreatedAt());

        assetService.addAsset(asset);

        return 1;
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
                            transfer.setToken(amountBeanX.getDenom()).setAmount(new BigInteger(amountBeanX.getAmount()));
                            transactionService.addTransfer(transfer);
                        }

                        //adding bill record for sender and recipient
                        for (BankTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean.ValueBean.AmountBeanX amountBeanX : msgBean.getValue().getAmount()) {
                            Bill b = new Bill();
                            b.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            b.setSender(msgBean.getValue().getFrom_address());
                            b.setRecipient(msgBean.getValue().getTo_address());
                            b.setToken(amountBeanX.getDenom())
                                    .setChangeAmount(new BigInteger(amountBeanX.getAmount()).negate())
                                    .setAccount(msgBean.getValue().getFrom_address());

                            transactionService.addBill(b);

                            b = new Bill();
                            b.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            b.setSender(msgBean.getValue().getFrom_address());
                            b.setRecipient(msgBean.getValue().getTo_address());
                            b.setToken(amountBeanX.getDenom())
                                    .setChangeAmount(new BigInteger(amountBeanX.getAmount()))
                                    .setAccount(msgBean.getValue().getTo_address());

                            transactionService.addBill(b);
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


                    for (AssetTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean msgBean : t.getTx().getValue().getMsg()) {
                        if (msgBean.getType().equals("asset/MsgIssueToken")) {
                            msgBean.getValue().getDescription();

                            Asset asset = new Asset();
                            asset.setCreatedAt(tx.getCreatedAt());
                            asset.setDecimals(8);
                            asset.setDescription(msgBean.getValue().getDescription());
                            asset.setName(msgBean.getValue().getSymbol());
                            asset.setCreationHeight(tx.getHeight());
                            asset.setTotalSupply(new BigInteger(msgBean.getValue().getTotal_supply()));
                            asset.setIssuer(msgBean.getValue().getOwner());
                            asset.setOwner(msgBean.getValue().getOwner());

                            if (assetService.countAssets(msgBean.getValue().getSymbol()) < 1) {
                                assetService.addAsset(asset);
                            }

                            tx.setType(TransactionType.ISSUE_TOKEN);
                        } else if (msgBean.getType().equals("asset/MsgTransferOwnership")) {
                            //values contains 3 fields, symbol, original_owner, new_owner
                            assetService.updateAssetOwner(msgBean.getValue().getSymbol(), msgBean.getValue().getNew_owner());
                            tx.setType(TransactionType.TRANSFER_OWNERSHIP);
                        } else if (msgBean.getType().equals("asset/MsgMintToken")) {
                            //values contains 3 fields, symbol, amount, owner_address
                            assetService.mintAsset(msgBean.getValue().getSymbol(), new BigInteger(msgBean.getValue().getAmount()));
                            tx.setType(TransactionType.MINT_TOKEN);
                        }

                        //add transfer and billing records
                        if (msgBean.getType().equals("asset/MsgIssueToken")) {
                            Transfer transfer = new Transfer();
                            transfer.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            transfer.setSender(msgBean.getValue().getOwner());
                            transfer.setRecipient(msgBean.getValue().getOwner());
                            transfer.setToken(msgBean.getValue().getSymbol())
                                    .setAmount(new BigInteger(msgBean.getValue().getTotal_supply()));
                            transactionService.addTransfer(transfer);

                            //adding bill record for the token creator
                            Bill b = new Bill();
                            b.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            b.setSender(msgBean.getValue().getOwner());
                            b.setRecipient(msgBean.getValue().getOwner());
                            b.setToken(msgBean.getValue().getSymbol())
                                    .setChangeAmount(new BigInteger(msgBean.getValue().getTotal_supply()))
                                    .setAccount(msgBean.getValue().getOwner());

                            transactionService.addBill(b);
                        }

                        if (msgBean.getType().equals("asset/MsgTransferOwnership")) {
                            Transfer transfer = new Transfer();
                            transfer.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            transfer.setSender(msgBean.getValue().getOriginal_owner());
                            transfer.setRecipient(msgBean.getValue().getNew_owner());
                            transfer.setToken(msgBean.getValue().getSymbol())
                                    .setAmount(new BigInteger("0"));
                            transactionService.addTransfer(transfer);
                        }

                        if (msgBean.getType().equals("asset/MsgMintToken")) {
                            Transfer transfer = new Transfer();
                            transfer.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            transfer.setSender(msgBean.getValue().getOwner_address());
                            transfer.setRecipient(msgBean.getValue().getOwner_address());
                            transfer.setToken(msgBean.getValue().getSymbol())
                                    .setAmount(new BigInteger(msgBean.getValue().getAmount()));
                            transactionService.addTransfer(transfer);

                            Bill b = new Bill();
                            b.setCreatedAt(tx.getCreatedAt()).setHeight(tx.getHeight()).setTxHash(tx.getHash()).setType(tx.getType());
                            b.setSender(msgBean.getValue().getOwner_address());
                            b.setRecipient(msgBean.getValue().getOwner_address());
                            b.setToken(msgBean.getValue().getSymbol())
                                    .setChangeAmount(new BigInteger(msgBean.getValue().getAmount()))
                                    .setAccount(msgBean.getValue().getOwner_address());

                            transactionService.addBill(b);
                        }

                    }

                    transactionService.addTx(tx);
                }
            }

            return response.getTxs().size();
        }
        return 0;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    public int syncMarketTx(int page, int limit) throws IOException {
        TxsResponse response = blockchainService.searchMarketTxs("market", page,limit);
        if (response != null && response.getTxs() != null && response.getTxs().size() > 0) {
            for (TxsResponse.TxsBean t : response.getTxs()) {
                Transaction tx = new Transaction();
                tx.setHash(t.getTxhash());
                tx.setHeight(Integer.valueOf(t.getHeight()));
                tx.setCreatedAt(DateUtil.getTxTime(t.getTimestamp()));
                tx.setSuccess(t.getLogs().get(0).isSuccess());
                tx.setMsgNum(t.getTx().getValue().getMsg().size());
                tx.setMemo(t.getTx().getValue().getMemo());

                for (TxsResponse.TxsBean.EventsBeanX event : t.getEvents()) {
                    if (event.getType().equals("message")) {
                        for (TxsResponse.TxsBean.EventsBeanX.AttributesBeanX attribute : event.getAttributes()) {
                            if (attribute.getKey().equals("sender")) {
                                tx.setSender(attribute.getValue());
                            }
                        }
                    }
                }

                if (transactionService.countTxByHash(tx.getHash()) == 0) {
                    for (TxMessage msgBean : t.getTx().getValue().getMsg()) {
                        if (msgBean.getType().equals("market/MsgCreateTradingPair")) {
                            tx.setType(TransactionType.CREATE_MARKET);
                        } else if (msgBean.getType().equals("market/MsgModifyPricePrecision")) {
                            tx.setType(TransactionType.MODIFY_MARKET_PRICE);
                        } else if (msgBean.getType().equals("market/MsgCreateOrder")) {
                            tx.setType(TransactionType.CREATE_ORDER);
                        } else if (msgBean.getType().equals("market/MsgCancelOrder")) {
                            tx.setType(TransactionType.CANCEL_ORDER);
                        }


                        if (msgBean.getType().equals("market/MsgCreateOrder")) {
                            CreateOrderMessage m = (CreateOrderMessage)msgBean.toValue();
                            Order o = new Order();

                            o.setPrice(new BigInteger(m.getPrice())).setQuantity(new BigInteger(m.getQuantity()))
                                    .setSender(tx.getSender()).setTxHash(tx.getHash())
                                    .setType(tx.getType()).setPricePrecision(m.getPrice_precision())
                                    .setSide(m.getSide()).setTradingPair(m.getTrading_pair());

                            o.setHeight(tx.getHeight()).setCreatedAt(tx.getCreatedAt());

                            transactionService.addOrder(o);
                        } else {
                            Message m = new Message();
                            m.setType(tx.getType()).setSender(tx.getSender())
                                    .setTxHash(tx.getHash()).setJsonContent(JSONUtil.toJSONString(msgBean.toValue()));

                            m.setHeight(tx.getHeight()).setCreatedAt(tx.getCreatedAt());
                            transactionService.addMessage(m);
                        }

                    }

                    transactionService.addTx(tx);
                }
            }

            return response.getTxs().size();
        }
        return 0;
    }


}
