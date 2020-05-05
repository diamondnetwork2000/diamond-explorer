package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.Block;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface BlockMapper extends BaseMapper<Block> {

    Page<Block>  getBlockList(@Param("startHeight") int startHeight,
                              @Param("endHeight") int endHeight,
                              RowBounds rowBounds);

    Block getBlock(@Param("height") int height);

    int countBlocks();

    void addFeeToHeight(@Param("height") int height, @Param("fee") long fee);
}
