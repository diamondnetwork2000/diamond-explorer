package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AccountMapper;
import io.diamondnetwork.mapper.TransactionMapper;
import io.diamondnetwork.model.Account;
import io.diamondnetwork.model.AccountAsset;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    TransactionMapper transactionMapper;

    public Page<Account> getBlockList(Integer pageNo, Integer pageSize) {
        Page<Account> list = accountMapper.getAccountList(new RowBounds(pageNo, pageSize));
        List<Long> accountIdList = list.stream().map(a -> a.getId() ).collect(Collectors.toList());

        List<Account> accountAsset = accountMapper.getAccountAssetNum(accountIdList);

        Map<Long, Integer> id2AssetNumMap = accountAsset.stream().collect(Collectors.toMap(Account::getId,
                Account::getAssetNum));
        for (Account a :list) {
            Integer assetNum = id2AssetNumMap.get(a.getId());
            a.setAssetNum(assetNum == null ? 0 :assetNum);
        }

        return list;
    }

    public Page<AccountAsset>  getAccountAssets(long accountId,
                                         Integer pageNo, Integer pageSize) {
        Page<AccountAsset> list = accountMapper.getAccountAssets(accountId, new RowBounds(pageNo, pageSize));

        return list;
    }

    public Account getAccount(Long accountId) {
        Account account = accountMapper.getAccount(accountId);
        if (account != null && account.getId() == 0) {
            //底下 join 查询语句里用了count，所以当account不存在时会返回一行空的内容
            return null;
        }
        List<Account> accountAsset = accountMapper.getAccountAssetNum(Arrays.asList(accountId));

        Map<Long, Integer> id2AssetNumMap = accountAsset.stream().collect(Collectors.toMap(Account::getId,
                Account::getAssetNum));

        Integer assetNum = id2AssetNumMap.get(accountId);
        account.setAssetNum(assetNum == null ? 0 :assetNum);

        account.setTxNum(transactionMapper.getTxCountByAccount(accountId));

        return account;
    }

    public int countAccounts(String address){
        return accountMapper.countAccounts(address);
    }

    public int countAccounts(){
        return accountMapper.countAccounts(null);
    }

    public void addAccount(Account tx) {
        accountMapper.insert(tx);
    }
}
