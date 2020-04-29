package io.diamondnetwork.task;

import io.diamondnetwork.mapper.ConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void init() {

        Thread blockSyncThread = new Thread() {

            @Override
            public void run() {
                syncBlock();
            }
        };
             blockSyncThread.start();

        Thread txSyncThread = new Thread() {

            @Override
            public void run() {
                syncTxs();
            }
        };
     //   txSyncThread.start();
    }

    private void syncBlock() {
        while (true) {
            try {
                int lastHeight = Integer.valueOf(configMapper.getConfigByName("last_block_height").getConfValue());
                int result = syncService.syncBlock(lastHeight);
                if (result > 0) {
                    configMapper.updateConfigValue("last_block_height", String.valueOf(++lastHeight));
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

    private void syncTxs() {
        while (true) {
            try {
                int lastPage = Integer.valueOf(configMapper.getConfigByName("last_tx_page").getConfValue());
                int result = syncService.syncTx("bankx",lastPage, 20);
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
}
