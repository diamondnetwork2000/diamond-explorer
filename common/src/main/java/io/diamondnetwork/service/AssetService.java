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
        if (list.isEmpty()) {
            return list;
        }

        List<Long> assetIdList = list.stream().map(a -> a.getId() ).collect(Collectors.toList());

        List<Asset> accountAsset = assetDao.getAssetAccountNum(assetIdList);
        List<Asset> assetTransfer = assetDao.getAssetTransferNum(assetIdList);

        Map<Long, Integer> id2AssetNumMap = accountAsset.stream().collect(Collectors.toMap(Asset::getId,
                Asset::getHolderNum));

        Map<Long, Integer> id2TransferNumMap = assetTransfer.stream().collect(Collectors.toMap(Asset::getId,
                Asset::getTransferNum));


        for (Asset a :list) {
            Integer assetNum = id2AssetNumMap.get(a.getId());
            Integer transferNum = id2TransferNumMap.get(a.getId());
            a.setHolderNum(assetNum == null ? 0 :assetNum);
            a.setTransferNum(transferNum == null ? 0 :transferNum);
        }
        return list;
    }

    public Asset getAsset(long assetId) {
        Asset asset = assetDao.getAsset(assetId);

        List<Asset> accountAsset = assetDao.getAssetAccountNum(Arrays.asList(assetId));
        List<Asset> assetTransfer = assetDao.getAssetTransferNum(Arrays.asList(assetId));

        Map<Long, Integer> id2AssetNumMap = accountAsset.stream().collect(Collectors.toMap(Asset::getId,
                Asset::getHolderNum));

        Map<Long, Integer> id2TransferNumMap = assetTransfer.stream().collect(Collectors.toMap(Asset::getId,
                Asset::getTransferNum));

        Integer assetNum = id2AssetNumMap.get(assetId);
        Integer transferNum = id2TransferNumMap.get(assetId);
        asset.setHolderNum(assetNum == null ? 0 :assetNum);
        asset.setTransferNum(transferNum == null ? 0 :transferNum);

        return asset;
    }



    public Page<AccountAsset>  getAccountAssets(long assetId,
                                                Integer pageNo, Integer pageSize) {
        Page<AccountAsset> list = accountMapper.getAccountAssetsByAsset(assetId, new RowBounds(pageNo, pageSize));

        return list;
    }

    public Page<AssetTransfer>  getAssetTransfer(long assetId,
                                                 Integer pageNo, Integer pageSize) {
        Page<AssetTransfer> list = assetDao.getAssetTransfer(assetId, new RowBounds(pageNo, pageSize));

        return list;
    }


}
