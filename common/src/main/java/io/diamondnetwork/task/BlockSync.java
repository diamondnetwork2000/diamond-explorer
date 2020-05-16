package io.diamondnetwork.task;

import io.diamondnetwork.mapper.ConfigMapper;
import io.diamondnetwork.model.Validator;
import io.diamondnetwork.service.AccountService;
import io.diamondnetwork.service.BlockchainService;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.task.response.ValidatorsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

/**
 */
@Component
@Slf4j
public class BlockSync {
    @Autowired
    private BlockchainSyncService syncService;
    @Autowired
    private AccountService accountService;
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

    private void syncLatestBlock() {
        BlockDetail b = null;
        try {
            b = blockchainService.latestBlock();
            ValidatorsResponse validators = blockchainService.validators();
            for (ValidatorsResponse.ResultBean resultBean : validators.getResult()) {
                Validator validatorByProposerAddress = accountService.getValidatorByConsensusPubkey(resultBean.getConsensus_pubkey());
                if (validatorByProposerAddress == null) {
                    Validator v = new Validator(resultBean.getDescription().getMoniker(),
                            resultBean.getConsensus_pubkey(),
                            resultBean.getOperator_address());
                    v.setStatus(resultBean.getStatus());
                    v.setCreatedAt(new Date());
                    accountService.addValidator(v);
                }
            }

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
