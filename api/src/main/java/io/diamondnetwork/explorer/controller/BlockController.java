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

@Api(tags = "blocks")
@RequestMapping("/blocks")
@RestController
public class BlockController {
    @Autowired
    private BlockService blockService;

    @ApiOperation(value = "list of blocks")
    @GetMapping("")
    public CommonListResponse<Block> getBlockList(@ApiParam(value = "start height") @RequestParam( required = true) int startHeight,
                                                  @ApiParam(value = "") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "") @RequestParam Integer pageSize) {

        Page<Block> voList = blockService.getBlockList(startHeight, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "detail of block")
    @GetMapping("height")
    public CommonResponse<Block> getBlock(@ApiParam(value = "height of block") @RequestParam( required = true) int height) {
        Block voList = blockService.getBlock(height);
        return new CommonResponse(voList);
    }
}
