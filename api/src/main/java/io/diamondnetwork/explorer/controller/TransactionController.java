package io.diamondnetwork.explorer.controller;

import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.Transaction;
import io.diamondnetwork.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "区块")
@RequestMapping("/tx")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "某个区块的交易列表")
    @GetMapping("")
    public CommonListResponse<Transaction> getBlockList(@ApiParam(value = "开始高度") @RequestParam( required = true) int height,
                                                        @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                        @ApiParam(value = "页码") @RequestParam Integer pageSize) {
        //TODO: generator需要计算,
        Page<Transaction> voList = transactionService.getTxList(height, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }


    @ApiOperation(value = "交易详情")
    @GetMapping("detail")
    public CommonResponse<Transaction> getTx(@ApiParam(value = "开始高度") @RequestParam( required = true) String txHash) {
        //TODO: generator需要计算,
        Transaction vo = transactionService.getTx(txHash);
        return new CommonResponse(vo);
    }


    @ApiOperation(value = "最新交易列表")
    @GetMapping("latest")
    public CommonListResponse<Transaction> getLatestTxList(
                                                        @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                        @ApiParam(value = "页码") @RequestParam Integer pageSize) {
        //TODO: generator需要计算,
        Page<Transaction> voList = transactionService.getTxList(null, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "某个账号的交易列表")
    @GetMapping("account")
    public CommonListResponse<Transaction> getBlockListByAccount(@ApiParam(value = "开始高度") @RequestParam( required = true) String accountId,
                                                  @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "页码") @RequestParam Integer pageSize) {

        Page<Transaction> voList = transactionService.getTxListByAccount(0L, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

}
