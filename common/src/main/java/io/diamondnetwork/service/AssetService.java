package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AccountMapper;
import io.diamondnetwork.mapper.AssetMapper;
import io.diamondnetwork.mapper.BlockMapper;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.Transfer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AssetService {
    @Autowired
    private AssetMapper assetDao;
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BlockMapper blockDao;
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

        Page<AccountAsset> list = assetDao.getAccountAssets(assetName, new RowBounds(pageNo, pageSize));
        return list;
    }




    public void addAsset(Asset asset) {
        assetDao.insert(asset);
    }

    public int countAssets(String symbol) {
        return assetDao.countAssets(symbol);
    }

    public Page<Transfer> getAssetTransfer(String assetName, Integer pageNo, Integer pageSize) {

        return assetDao.getAssetTransfer(assetName, new RowBounds(pageNo, pageSize));
    }

    public void updateAssetOwner(String symbol, String new_owner) {
        assetDao.updateAssetOwner(symbol, new_owner);
    }

    public void mintAsset(String symbol, BigInteger amount) {
        assetDao.mintAsset(symbol, amount);
    }
}
