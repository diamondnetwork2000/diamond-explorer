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

@Api(tags = "accounts")
@RequestMapping("/accounts")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "list of account")
    @GetMapping("")
    public CommonListResponse<Account> getBlockList(
                                                  @ApiParam(value = "page number") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "record number of each page") @RequestParam Integer pageSize) {
        Page<Account> voList = accountService.getBlockList(pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "detail of account")
    @GetMapping("detail")
    public CommonResponse<Account> getBlockList(@RequestParam String address
                                       ) throws IOException {


        Account voList = accountService.getAccount(address);
        return new CommonResponse(voList);
    }


    @ApiOperation(value = "assets of account")
    @GetMapping("assets")
    public CommonListResponse<AccountAsset> accountAssets(
           @RequestParam String address,
           @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize) throws IOException {

        Page<AccountAsset> voList = accountService.getAccountAssets(address,pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }
}
