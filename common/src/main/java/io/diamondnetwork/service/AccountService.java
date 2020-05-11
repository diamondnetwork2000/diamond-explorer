package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.AccountMapper;
import io.diamondnetwork.mapper.TransactionMapper;
import io.diamondnetwork.model.Account;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.task.response.AccountBalancesResponse;
import io.diamondnetwork.task.response.ListTokenResponse;
import io.diamondnetwork.util.Constants;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    @Autowired
    private BlockchainService blockchainService;

    public Page<Account> getBlockList(Integer pageNo, Integer pageSize) {
        Page<Account> list = accountMapper.getAccountList(new RowBounds(pageNo, pageSize));
        List<Long> accountIdList = list.stream().map(a -> a.getId() ).collect(Collectors.toList());



        return list;
    }

    public Page<AccountAsset>  getAccountAssets(String address,
                                         Integer pageNo, Integer pageSize) throws IOException {

        AccountBalancesResponse accountBalancesResponse = blockchainService.accountBalances(address);

        Page<AccountAsset> assets = new Page<>();
        if (accountBalancesResponse.getResult().getCoins() != null) {
            accountBalancesResponse.getResult().getCoins().forEach( m ->
                            assets.add(new AccountAsset(address, m.getDenom(), Long.valueOf(m.getAmount())))
                    );
        }

        Map<String, AccountAsset> assetName2AssetMap = assets.stream().collect(Collectors.toMap(m->m.getAssetName(), m->m));

        if (accountBalancesResponse.getResult().getFrozen_coins() != null) {
            accountBalancesResponse.getResult().getFrozen_coins().forEach( m ->
                    assetName2AssetMap.get(m.getDenom()).setFrozenQuantity(Long.valueOf(m.getAmount()))
            );
        }

        ListTokenResponse listTokenResponse = blockchainService.listTokens();
        if (listTokenResponse.getResult() != null) {
            listTokenResponse.getResult().forEach(m -> {
                        AccountAsset a = assetName2AssetMap.get(m.getValue().getSymbol());
                        if (a != null) {
                            a.setTotalSupply(Long.valueOf(m.getValue().getTotal_supply()));
                        }


                    }
                   );
        }

        return assets;
    }

    public Account getAccount(String address) throws IOException {
        Account account = accountMapper.getAccount(address);
        if (account != null && account.getId() == 0) {
            //底下 join 查询语句里用了count，所以当account不存在时会返回一行空的内容
            return null;
        }

        AccountBalancesResponse accountBalancesResponse = blockchainService.accountBalances(address);

        if (account != null && accountBalancesResponse.getResult().getCoins() != null) {
            account.setAssetNum(accountBalancesResponse.getResult().getCoins().size());

            for (AccountBalancesResponse.ResultBean.CoinsBean coin : accountBalancesResponse.getResult().getCoins()) {
                if (coin.getDenom().equals(Constants.nativeCoinName)) {
                    account.setBalance(Long.valueOf(coin.getAmount()));
                }
            }
        }

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
