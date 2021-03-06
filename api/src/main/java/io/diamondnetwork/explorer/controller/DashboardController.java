package io.diamondnetwork.explorer.controller;

import io.diamondnetwork.CommonResponse;
import io.diamondnetwork.model.dashboard.BlockStats;
import io.diamondnetwork.model.dashboard.BlockStatus;
import io.diamondnetwork.service.DashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = "dashboard")
@RequestMapping("/dashboard")
@RestController
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @ApiOperation(value = "home page")
    @GetMapping("stats")
    public CommonResponse<BlockStats> getBlockStats() throws IOException {
        return new CommonResponse<>(dashboardService.getBlockStats());
    }

    @ApiOperation(value = "block status")
    @GetMapping("status")
    public CommonResponse<BlockStatus> getBlockStatus() {
        return new CommonResponse(dashboardService.getBlockStatus());
    }

}
