package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AssetMapper;
import io.diamondnetwork.mapper.BlockMapper;
import io.diamondnetwork.mapper.TransactionMapper;
import io.diamondnetwork.mapper.TransferMapper;
import io.diamondnetwork.model.*;
import io.diamondnetwork.task.response.BlockDetail;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TransactionService {

    private final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    private TransactionMapper transactionDao;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private TransferMapper transferMapper;
    @Autowired
    private BlockchainService blockchainService;

    public Page<Transaction> getTxList(Integer height, Integer pageNo, Integer pageSize) {
        return transactionDao.getTxList(height, new RowBounds(pageNo, pageSize));

    }

    public Page<Transfer> getTxListByAccount(String address, Integer pageNo, Integer pageSize) {
        Page<Transfer> list = transactionDao.getTxListByAccount(address, new RowBounds(pageNo, pageSize));

        return list;
    }

    public Transaction getTx(String txHash) throws IOException {

        Transaction tx = transactionDao.getTx(txHash);
        Block b = blockMapper.getBlock(tx.getHeight());
        if (b == null) {
            BlockDetail body = blockchainService.getBlock(tx.getHeight());
            if (body != null) {
                Block block = Block.from(body);
                Block existed = blockMapper.getBlock(tx.getHeight());
                if (existed == null) {
                    blockMapper.insert(block);
                }

                tx.setBlock(block);
            }
        } else {
            tx.setBlock(b);
        }



        return tx;
    }


    public void addTx(Transaction block) {
        transactionDao.insert(block);
    }

    public int countTxByHash(String hash) {
        return transactionDao.countTxByHash(hash);
    }

    public void addTransfer(Transfer t) {
        transferMapper.insert(t);
    }
}
