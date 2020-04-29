package io.diamondnetwork.mapper;

import com.github.pagehelper.Page;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.AssetTransfer;
import io.diamondnetwork.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface AssetMapper {
    Page<Asset> getAssetList(
            RowBounds rowBounds);

    List<Asset> getAssetAccountNum(@Param("assetIdList") List<Long> accountIdList);
    List<Asset> getAssetTransferNum(@Param("assetIdList") List<Long> accountIdList);
    Page<AssetTransfer> getAssetTransfer(@Param("assetId") Long assetId,RowBounds rowBounds);

    Asset getAsset(@Param("assetId") Long assetId);

    Order getAskOrder(@Param("orderId") long orderId);
    Order getBidOrder(@Param("orderId") long orderId);
}
