package io.diamondnetwork.service;

import io.diamondnetwork.task.DkdChainRpcApi;
import io.diamondnetwork.task.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@Slf4j
public class BlockchainService {
    private DkdChainRpcApi api;

    @Value(value = "${diamond.node.url}")
    private String nodeUrl;

    @PostConstruct
    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(nodeUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(DkdChainRpcApi.class);
    }


    public BlockDetail getBlock(int height) throws IOException {
        Call<BlockDetail> call = api.getBlock(height);
        Response<BlockDetail> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to get block at height: {},, response: {}", height, response.toString());
            return null;
        }

        return response.body();
    }

    public BlockDetail latestBlock() throws IOException {
        Call<BlockDetail> call = api.latestBlock();
        Response<BlockDetail> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to get latest, response: {}", response.toString());
            throw new RuntimeException();
        }

        return response.body();
    }


    public BankTxResponse searchBankTxs(String module, int page, int limit) throws IOException {
        Call<BankTxResponse> call = api.searchBankTxs(module, page, limit);
        Response<BankTxResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to search tx for module: {}, page: {}, response: {}", module, page, response.toString());
            return null;
        }

        BankTxResponse body = response.body();
        return body;
    }

    public AssetTxResponse searchAssetTxs(String module, int page, int limit) throws IOException {
        Call<AssetTxResponse> call = api.searchAssetTxs(module, page, limit);
        Response<AssetTxResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to search tx for module: {}, page: {}, response: {}", module, page, response.toString());
            return null;
        }

        AssetTxResponse body = response.body();
        return body;
    }

    public TxsResponse searchMarketTxs(String module, int page, int limit) throws IOException {
        Call<TxsResponse> call = api.searchMarketTxs(module, page, limit);
        Response<TxsResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to search tx for module: {}, page: {}, response: {}", module, page, response.toString());
            return null;
        }

        TxsResponse body = response.body();
        return body;
    }

    public ListTokenResponse listTokens() throws IOException {
        Call<ListTokenResponse> call = api.listTokens();
        Response<ListTokenResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to list tokens, response: {}", response.toString());
            throw new RuntimeException();
        }
        return response.body();
    }

    public AccountBalancesResponse accountBalances(String address) throws IOException {
        Call<AccountBalancesResponse> call = api.accountBalances(address);
        Response<AccountBalancesResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to get account balances, account: {} response: {}", address, response.toString());
            throw new RuntimeException();
        }
        return response.body();
    }

    public ValidatorsResponse validators() throws IOException {
        Call<ValidatorsResponse> call = api.validators();
        Response<ValidatorsResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to get validators ,response: {}", response.toString());
            throw new RuntimeException();
        }
        return response.body();
    }

    public TokenDetailResponse tokenDetail(String token) throws IOException {
        Call<TokenDetailResponse> call = api.tokenDetail(token);
        Response<TokenDetailResponse> response = call.execute();
        if (response.code() != 200) {
            log.error("failed to get validators ,response: {}", response.toString());
            throw new RuntimeException();
        }
        return response.body();
    }
}
