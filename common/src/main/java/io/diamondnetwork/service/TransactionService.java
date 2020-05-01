package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AssetMapper;
import io.diamondnetwork.mapper.BlockMapper;
import io.diamondnetwork.mapper.TransactionMapper;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.Order;
import io.diamondnetwork.model.Transaction;
import io.diamondnetwork.model.attachment.ColoredCoinsAssetTransfer;
import io.diamondnetwork.model.attachment.ColoredCoinsOrderCancellation;
import io.diamondnetwork.model.attachment.ColoredCoinsOrderPlacement;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.codec.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    private TransactionMapper transactionDao;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private AssetMapper assetMapper;

    public Page<Transaction> getTxList(Integer height, Integer pageNo, Integer pageSize) {
        return transactionDao.getTxList(height, new RowBounds(pageNo, pageSize));

    }

    public Page<Transaction> getTxListByAccount(long accountId, Integer pageNo, Integer pageSize) {
        Page<Transaction> list = transactionDao.getTxListByAccount(accountId, new RowBounds(pageNo, pageSize));
        for (Transaction t : list) {
            //批量转账，只显示和当前用户相关的转账数量
            //TODO
           /* if (t.getType() == 0 && t.getSubType() == 1) {
                PaymentMultiOutCreation multiout = (PaymentMultiOutCreation)t.getAttachment();
                for (PaymentMultiOutCreation.Multiout o : multiout.getRecipients()) {
                    if (o.getRecipientId() == accountId) {
                        t.setQuantity(o.getAmountNQT());
                    }
                }
            }*/
        }
        return list;
    }

    public Transaction getTx(String txHash) {
        byte[] hashBytes = Hex.decode(txHash);
        Transaction tx = transactionDao.getTx(hashBytes);
        tx.setBlock(blockMapper.getBlock(tx.getHeight()));

       /* if (tx.getAttachment() != null) {
            logger.info("tx: {} with attachment: {}", txHash, tx.getAttachment().getClass());
            if (tx.getAttachment() instanceof ColoredCoinsOrderPlacement) {
                ColoredCoinsOrderPlacement order = (ColoredCoinsOrderPlacement) tx.getAttachment();

                Asset asset = assetMapper.getAsset(order.getAssetId());
                order.setAssetName(asset.getName());
                if (order.getQuoteAssetId() != 0) {
                    Asset quoteAsset = assetMapper.getAsset(order.getQuoteAssetId());
                    order.setQuoteAssetName(quoteAsset.getName());
                } else {
                    order.setQuoteAssetName("SSCC");
                }

                tx.setAttachment(order);
            } else if (tx.getAttachment() instanceof ColoredCoinsAssetTransfer) {
                ColoredCoinsAssetTransfer order = (ColoredCoinsAssetTransfer) tx.getAttachment();
                Asset asset = assetMapper.getAsset(order.getAssetId());
                order.setAssetName(asset.getName());

                tx.setAttachment(order);
            } else if (tx.getAttachment() instanceof ColoredCoinsOrderCancellation) {
                ColoredCoinsOrderCancellation order = (ColoredCoinsOrderCancellation) tx.getAttachment();

                *//*if (tx.getSubType() == TransactionType.SUBTYPE_COLORED_COINS_ASK_ORDER_CANCELLATION) {
                    Order askOrder = assetMapper.getAskOrder(order.getOrderId());

                    Asset asset = assetMapper.getAsset(askOrder.getAssetId());
                    askOrder.setAssetName(asset.getName());
                    if (askOrder.getQuoteAssetId() != 0) {
                        Asset quoteAsset = assetMapper.getAsset(askOrder.getQuoteAssetId());
                        askOrder.setQuoteAssetName(quoteAsset.getName());
                    } else {
                        askOrder.setQuoteAssetName("SSCC");
                    }

                    order.setOrder(askOrder);
                } else *//*{
                    Order bidOrder = assetMapper.getBidOrder(order.getOrderId());

                    Asset asset = assetMapper.getAsset(bidOrder.getAssetId());
                    bidOrder.setAssetName(asset.getName());
                    if (bidOrder.getQuoteAssetId() != 0) {
                        Asset quoteAsset = assetMapper.getAsset(bidOrder.getQuoteAssetId());
                        bidOrder.setQuoteAssetName(quoteAsset.getName());
                    } else {
                        bidOrder.setQuoteAssetName("SSCC");
                    }
                    order.setOrder(bidOrder);
                }
                tx.setAttachment(order);
            }
        }*/

        return tx;
    }


    public void addTx(Transaction block) {
        transactionDao.insert(block);
    }
}
