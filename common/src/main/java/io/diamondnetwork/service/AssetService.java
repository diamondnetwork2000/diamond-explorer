package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AccountMapper;
import io.diamondnetwork.mapper.AssetMapper;
import io.diamondnetwork.mapper.BlockMapper;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.AssetTransfer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AssetService {
    @Autowired
    private AssetMapper assetDao;
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BlockMapper blockDao;
    //查询区块高度小于或等于startHeight的区块列表
    public Page<Asset> getBlockList(Integer pageNo, Integer pageSize) {
        Page<Asset> list = assetDao.getAssetList(new RowBounds(pageNo, pageSize));

        return list;
    }

    public Asset getAsset(String name) {
        Asset asset = assetDao.getAsset(name);

        return asset;
    }



    public Page<AccountAsset>  getAccountAssets(String assetName,
                                                Integer pageNo, Integer pageSize) {


        return null;
    }

    public Page<AssetTransfer>  getAssetTransfer(String assetName,
                                                 Integer pageNo, Integer pageSize) {


        return null;
    }


    public void addAsset(Asset asset) {
        assetDao.insert(asset);
    }

    public int countAssets(String symbol) {
        return assetDao.countAssets(symbol);
    }
}
