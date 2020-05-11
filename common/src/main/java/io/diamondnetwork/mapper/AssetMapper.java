package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.Order;
import io.diamondnetwork.model.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface AssetMapper extends BaseMapper<Asset> {
    Page<Asset> getAssetList(
            RowBounds rowBounds);

    List<Asset> getAssetAccountNum(@Param("assetIdList") List<Long> accountIdList);
    List<Asset> getAssetTransferNum(@Param("assetIdList") List<Long> accountIdList);

    Asset getAsset(@Param("name") String name);

    Order getAskOrder(@Param("orderId") long orderId);
    Order getBidOrder(@Param("orderId") long orderId);

    int countAssets(@Param("symbol") String symbol);

    Page<Transfer> getAssetTransfer(@Param("assetName") String assetName, RowBounds rowBounds);

    Page<AccountAsset> getAccountAssets(@Param("assetName") String assetName, RowBounds rowBounds);
}
