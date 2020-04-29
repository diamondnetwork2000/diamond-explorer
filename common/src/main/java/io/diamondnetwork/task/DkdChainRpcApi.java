package io.diamondnetwork.task;

import io.diamondnetwork.task.response.BankTxResponse;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.task.response.ListTokenResponse;
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
    Call<BankTxResponse> searchTxs(@Query("message.module") String module,
                                   @Query("page") int page,
                                   @Query("limit") int limit);

    @GET("asset/tokens")
    Call<ListTokenResponse> listTokens();
}
