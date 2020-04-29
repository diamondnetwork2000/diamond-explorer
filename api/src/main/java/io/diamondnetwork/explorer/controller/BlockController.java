package io.diamondnetwork.explorer.controller;


import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.Block;
import io.diamondnetwork.service.BlockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "区块")
@RequestMapping("/blocks")
@RestController
public class BlockController {
    @Autowired
    private BlockService blockService;

    @ApiOperation(value = "区块列表")
    @GetMapping("")
    public CommonListResponse<Block> getBlockList(@ApiParam(value = "开始高度") @RequestParam( required = true) int startHeight,
                                                  @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "页码") @RequestParam Integer pageSize) {

        Page<Block> voList = blockService.getBlockList(startHeight, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "区块详情")
    @GetMapping("height")
    public CommonResponse<Block> getBlock(@ApiParam(value = "开始高度") @RequestParam( required = true) int height) {
        //TODO:签名值需要换算
        Block voList = blockService.getBlock(height);
        return new CommonResponse(voList);
    }
}
