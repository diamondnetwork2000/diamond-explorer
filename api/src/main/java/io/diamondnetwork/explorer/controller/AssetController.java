package io.diamondnetwork.explorer.controller;


import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.AssetTransfer;
import io.diamondnetwork.service.AssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "区块")
@RequestMapping("/assets")
@RestController
public class AssetController {
    @Autowired
    private AssetService assetService;

    @ApiOperation(value = "区块列表")
    @GetMapping("")
    public CommonListResponse<Asset> getBlockList(
                                                  @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "页码") @RequestParam Integer pageSize) {

        Page<Asset> voList = assetService.getBlockList(pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "区块列表")
    @GetMapping("detail")
    public CommonResponse<Asset> getBlockList(
            @ApiParam(value = "页数") @RequestParam Long assetId) {

        Asset asset  = assetService.getAsset(assetId);
        return new CommonResponse(asset);
    }


    @ApiOperation(value = "区块列表")
    @GetMapping("accounts")
    public CommonListResponse<AccountAsset> getBlockList(  @ApiParam(value = "页数") @RequestParam Long assetId,
                                                  @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "页码") @RequestParam Integer pageSize) {

        Page<AccountAsset> voList = assetService.getAccountAssets(assetId, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }


@ApiOperation(value = "区块列表")
    @GetMapping("transfers")
    public CommonListResponse<AssetTransfer> getAssetTransfer(@ApiParam(value = "页数") @RequestParam Long assetId,
                                                              @ApiParam(value = "页数") @RequestParam Integer pageNo,
                                                              @ApiParam(value = "页码") @RequestParam Integer pageSize) {

        Page<AssetTransfer> voList = assetService.getAssetTransfer(assetId, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

}
