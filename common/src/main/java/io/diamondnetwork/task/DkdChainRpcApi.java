package io.diamondnetwork.task;

import io.diamondnetwork.task.response.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DkdChainRpcApi {
    @GET("blocks/{height}")
    Call<BlockDetail> getBlock(@Path("height") int height);

    @GET("blocks/latest")
    Call<BlockDetail> latestBlock();

    @GET("txs")
    Call<BankTxResponse> searchBankTxs(@Query("message.module") String module,
                                   @Query("page") int page,
                                   @Query("limit") int limit);
    @GET("txs")
    Call<AssetTxResponse> searchAssetTxs(@Query("message.module") String module,
                                         @Query("page") int page,
                                         @Query("limit") int limit);


    @GET("txs")
    Call<TxsResponse> searchMarketTxs(@Query("message.module") String module,
                                         @Query("page") int page,
                                         @Query("limit") int limit);

    @GET("asset/tokens")
    Call<ListTokenResponse> listTokens();

    @GET("bank/balances/{address}")
    Call<AccountBalancesResponse> accountBalances(@Path("address") String address);

    @GET("staking/validators")
    Call<ValidatorsResponse> validators();

    @GET("asset/tokens/{token}")
    Call<TokenDetailResponse> tokenDetail(@Path("token") String token);
}
