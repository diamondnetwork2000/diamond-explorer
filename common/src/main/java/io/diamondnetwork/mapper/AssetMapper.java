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

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface AssetMapper extends BaseMapper<Asset> {
    Page<Asset> getAssetList(
            RowBounds rowBounds);


    Asset getAsset(@Param("name") String name);


    int countAssets(@Param("symbol") String symbol);

    Page<Transfer> getAssetTransfer(@Param("assetName") String assetName, RowBounds rowBounds);

    Page<AccountAsset> getAccountAssets(@Param("assetName") String assetName, RowBounds rowBounds);

    void updateAssetOwner(@Param("assetName") String assetName,@Param("newOwner")  String newOwner);

    void mintAsset(@Param("assetName") String assetName, @Param("amount") BigInteger amount);
}
