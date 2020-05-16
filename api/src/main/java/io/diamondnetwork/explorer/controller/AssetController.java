package io.diamondnetwork.explorer.controller;


import com.github.pagehelper.Page;
import io.diamondnetwork.CommonListResponse;
import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.AccountAsset;
import io.diamondnetwork.model.Asset;
import io.diamondnetwork.model.Transfer;
import io.diamondnetwork.service.AssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "assets")
@RequestMapping("/assets")
@RestController
public class AssetController {
    @Autowired
    private AssetService assetService;

    @ApiOperation(value = "list of assets")
    @GetMapping("")
    public CommonListResponse<Asset> getBlockList(
                                                  @ApiParam(value = "") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "") @RequestParam Integer pageSize) {

        Page<Asset> voList = assetService.getBlockList(pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

    @ApiOperation(value = "detail of asset")
    @GetMapping("detail")
    public CommonResponse<Asset> getBlockList(
            @ApiParam(value = "asset name，ex. dkd") @RequestParam String name) {

        Asset asset  = assetService.getAsset(name);
        return new CommonResponse(asset);
    }


    @ApiOperation(value = "accounts who hold the asset")
    @GetMapping("accounts")
    public CommonListResponse<AccountAsset> getBlockList(  @ApiParam(value = "asset name，such as dkd") @RequestParam String assetName,
                                                  @ApiParam(value = "") @RequestParam Integer pageNo,
                                                  @ApiParam(value = "") @RequestParam Integer pageSize) {

        Page<AccountAsset> voList = assetService.getAccountAssets(assetName, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }


    @ApiOperation(value = "transfer related to the asset")
    @GetMapping("transfers")
    public CommonListResponse<Transfer> getAssetTransfer(@ApiParam(value = "asset name， such as dkd") @RequestParam String assetName,
                                                         @ApiParam(value = "") @RequestParam Integer pageNo,
                                                         @ApiParam(value = "") @RequestParam Integer pageSize) {

        Page<Transfer> voList = assetService.getAssetTransfer(assetName, pageNo, pageSize);
        return CommonListResponse.fromPage(voList);
    }

}
