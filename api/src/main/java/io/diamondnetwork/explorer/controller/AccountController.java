package io.diamondnetwork.explorer.controller;

import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.Account;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = "区块")
@RequestMapping("/accounts")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "账号列表")
    @GetMapping("")
    public CommonListResponse<Account> getBlockList(
                                                  @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "页码") @RequestParam Integer pageSize) {
        //TODO: generator需要计算
        Page<Account> voList = accountService.getBlockList(pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "账号详情")
    @GetMapping("detail")
    public CommonResponse<Account> getBlockList(@RequestParam String address
                                       ) throws IOException {


        Account voList = accountService.getAccount(address);
        return new CommonResponse(voList);
    }


    @ApiOperation(value = "账号持有的资产")
    @GetMapping("assets")
    public CommonListResponse<Account> getBlockList3(
           @RequestParam String address,
           @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize) {

        Page<AccountAsset> voList = accountService.getAccountAssets(address,pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }
}
