package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.Account;
import io.diamondnetwork.model.AccountAsset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    Page<Account>  getAccountList(
                              RowBounds rowBounds);


    Page<AccountAsset>  getAccountAssets(@Param("accountId") long accountId,
                                         RowBounds rowBounds);

    Page<AccountAsset>  getAccountAssetsByAsset(@Param("assetId") long assetId,
                                         RowBounds rowBounds);

    List<Account>  getAccountAssetNum(@Param("accountIdList") List<Long> accountIdList);

    Account getAccount(@Param("accountId") Long accountId);
    int countAccounts(@Param("address") String address);
}
