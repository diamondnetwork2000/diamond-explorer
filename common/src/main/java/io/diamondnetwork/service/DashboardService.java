package io.diamondnetwork.service;

import io.diamondnetwork.mapper.DashboardMapper;
import io.diamondnetwork.model.dashboard.BlockStats;
import io.diamondnetwork.model.dashboard.BlockStatus;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.task.response.ListTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DashboardService {
    @Autowired
    private DashboardMapper dashboardMapper;
    @Autowired
    private BlockchainService blockchainService;
    @Autowired
    private AccountService accountService;

    public BlockStats getBlockStats() throws IOException {

        BlockDetail blockDetail = blockchainService.latestBlock();
        ListTokenResponse listTokenResponse = blockchainService.listTokens();
        int accountNumber = accountService.countAccounts();


        BlockStats s = new BlockStats();
        s.setBlockNumber(blockDetail.getBlock_meta().getHeader().getHeight());
        s.setTxNumber(Integer.valueOf(blockDetail.getBlock().getHeader().getTotal_txs()));
        s.setAssetNumber(listTokenResponse.getResult().size());
        s.setAccountNumber(accountNumber);
        return s;
    }

    public BlockStatus getBlockStatus() {
        return dashboardMapper.getBlockStatus();
    }
}
