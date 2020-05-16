package io.diamondnetwork.explorer.controller;

import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.Transaction;
import io.diamondnetwork.model.Transfer;
import io.diamondnetwork.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = "transaction")
@RequestMapping("/tx")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "transaction in block")
    @GetMapping("")
    public CommonListResponse<Transaction> getBlockList(@ApiParam(value = "block height") @RequestParam( required = true) int height,
                                                        @ApiParam(value = "") @RequestParam Integer pageNo,
                                                        @ApiParam(value = "") @RequestParam Integer pageSize) {
        Page<Transaction> voList = transactionService.getTxList(height, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }


    @ApiOperation(value = "detail of transaction")
    @GetMapping("detail")
    public CommonResponse<Transaction> getTx(@ApiParam(value = "block height") @RequestParam( required = true) String txHash) throws IOException {
        Transaction vo = transactionService.getTx(txHash);
        return new CommonResponse(vo);
    }


    @ApiOperation(value = "latest block")
    @GetMapping("latest")
    public CommonListResponse<Transaction> getLatestTxList(
                                                        @ApiParam(value = "") @RequestParam Integer pageNo,
                                                        @ApiParam(value = "") @RequestParam Integer pageSize) {
        Page<Transaction> voList = transactionService.getTxList(null, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "transaction related to an account")
    @GetMapping("account")
    public CommonListResponse<Transfer> getBlockListByAccount(@ApiParam(value = "address of account") @RequestParam( required = true) String address,
                                                              @ApiParam(value = "") @RequestParam Integer pageNo,
                                                              @ApiParam(value = "") @RequestParam Integer pageSize) {

        Page<Transfer> voList = transactionService.getTxListByAccount(address, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

}
