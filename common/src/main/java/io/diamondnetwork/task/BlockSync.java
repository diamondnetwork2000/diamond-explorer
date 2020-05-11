package io.diamondnetwork.task;

import io.diamondnetwork.mapper.ConfigMapper;
import io.diamondnetwork.service.BlockchainService;
import io.diamondnetwork.task.response.BlockDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * 从区块链api同步区块和交易信息到本地数据库
 */
@Component
@Slf4j
public class BlockSync {
    @Autowired
    private BlockchainSyncService syncService;
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private BlockchainService blockchainService;

    @Value(value = "${diamond.node.sync}")
    private boolean sync;

    @PostConstruct
    public void init() {
        if (sync) {
            Thread blockSyncThread = new Thread() {

                @Override
                public void run() {
                    this.setName("blockSyncThread");
                    syncBlock();
                }
            };
            blockSyncThread.start();



            Thread latestBlockSyncThread = new Thread() {

                @Override
                public void run() {
                    this.setName("latestBlockSyncThread");
                    syncLatestBlock();
                }
            };
            latestBlockSyncThread.start();

            Thread txSyncThread = new Thread() {

                @Override
                public void run() {
                    this.setName("txSyncThread");
                    syncTransfer();
                }
            };
            txSyncThread.start();


            Thread tokenSyncThread = new Thread() {

                @Override
                public void run() {
                    this.setName("tokenSyncThread");
                    syncToken();
                }
            };
            tokenSyncThread.start();
        }


    }

    private void syncBlock() {
        while (true) {
            try {
                int lastHeight = Integer.valueOf(configMapper.getConfigByName("last_block_height").getConfValue());
                int result = syncService.syncBlock(lastHeight);
                if (result > 0) {
                    configMapper.updateConfigValue("last_block_height", String.valueOf(++lastHeight));
                    //Thread.sleep(500L);
                } else {
                    Thread.sleep(2000L);
                }
            } catch (Throwable e) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    //同步最后一部分区块
    private void syncLatestBlock() {
        BlockDetail b = null;
        try {
            b = blockchainService.latestBlock();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int startHeight = b.getBlock_meta().getHeader().getHeight() - 1000;

        while (true) {
            try {

                int height = syncService.syncBlock(startHeight);
                if (height > 0) {
                    ++startHeight;
                } else {
                    //已经没有区块可以同步，休眠
                    Thread.sleep(1000L);
                }

            } catch (Throwable e) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    private void syncTransfer() {
        while (true) {
            try {
                int lastPage = Integer.valueOf(configMapper.getConfigByName("last_tx_page").getConfValue());
                int result = syncService.syncTransfer(lastPage, 20);
                if (result > 0) {
                    configMapper.updateConfigValue("last_tx_page", String.valueOf(++lastPage));
                    Thread.sleep(500L);
                } else {
                    Thread.sleep(2000L);
                }
            } catch (Throwable e) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }


    private void syncToken() {
        while (true) {
            try {
                int lastPage = Integer.valueOf(configMapper.getConfigByName("last_token_page").getConfValue());
                int result = syncService.syncToken(lastPage, 20);
                if (result > 0) {
                    //只有处理处理后才能更新
                    configMapper.updateConfigValue("last_token_page", String.valueOf(++lastPage));
                    Thread.sleep(500L);
                } else {
                    Thread.sleep(2000L);
                }
            } catch (Throwable e) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }
}
