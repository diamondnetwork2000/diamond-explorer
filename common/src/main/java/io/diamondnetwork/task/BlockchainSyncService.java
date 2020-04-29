package io.diamondnetwork.task;

import io.diamondnetwork.service.BlockchainService;
import io.diamondnetwork.task.response.BankTxResponse;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.model.Account;
import io.diamondnetwork.model.Block;
import io.diamondnetwork.model.Transaction;
import io.diamondnetwork.service.AccountService;
import io.diamondnetwork.service.BlockService;
import io.diamondnetwork.service.TransactionService;
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
    BlockchainService blockchainService;

    @Transactional
    public int syncBlock(int height) throws IOException {
        BlockDetail body = blockchainService.getBlock(height);

        Block block = new Block();
        block.setHeight(body.getBlock_meta().getHeader().getHeight());
        block.setSignature(body.getBlock_meta().getBlock_id().getHash());
        block.setCreatedAt(DateUtil.getBlockTime(body.getBlock_meta().getHeader().getTime()));
        block.setFee(0).setSent(0L).setReward(0L);
        block.setGenerator(body.getBlock_meta().getHeader().getProposer_address());
        block.setVersion(Integer.valueOf(body.getBlock_meta().getHeader().getVersion().getApp()));
        block.setSize(Integer.valueOf(body.getBlock_meta().getBlockSize()));
        block.setGenerator(body.getBlock().getHeader().getProposer_address());

        Block existed = blockService.getBlock(height);
        if (existed == null) {
            blockService.addBlock(block);
        }



        return height;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int syncTx(String module, int page, int limit) throws IOException {
        BankTxResponse response = blockchainService.searchTxs(module, page,limit);

        if (response.getTxs() != null && response.getTxs().size() > 0) {
            for (BankTxResponse.TxsBean t : response.getTxs()) {
                Transaction tx = new Transaction();
                tx.setHash(t.getTxhash());
                tx.setHeight(Integer.valueOf(t.getHeight()));
                tx.setCreatedAt(DateUtil.getTxTime(t.getTimestamp()));

                tx.setMsgNum(t.getTx().getValue().getMsg().size());
                tx.setType("transfer");
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
                transactionService.addTx(tx);
                
                //检查目标地址，如果这个地址不存在account中，则新建一个账号
                for (BankTxResponse.TxsBean.TxBean.ValueBeanX.MsgBean msgBean : t.getTx().getValue().getMsg()) {
                    if (msgBean.getType().equals("bankx/MsgSend")) {
                         if (accountService.countAccounts(msgBean.getValue().getTo_address()) == 0) {
                             Account a = new Account();
                             a.setAssetNum(0);
                             a.setTxNum(0);
                             a.setCreatedAt(DateUtil.getTxTime(t.getTimestamp()));
                             a.setCreationHeight(Integer.valueOf(t.getHeight()));
                             a.setAddress(msgBean.getValue().getTo_address());
                             accountService.addAccount(a);
                         }
                    }
                }

            }
        }

        return page;
    }
}
