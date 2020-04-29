package io.diamondnetwork.mapper;

import io.diamondnetwork.model.dashboard.BlockStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {

    BlockStatus getBlockStatus();
}
