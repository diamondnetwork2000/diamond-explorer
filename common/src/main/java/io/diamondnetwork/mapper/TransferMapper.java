package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TransferMapper extends BaseMapper<Transfer> {
    Page<Transfer> getTxList(@Param("height") Integer height, RowBounds pageRowBounds);
    Page<Transfer> getTxListByAccount(@Param("accountId") String address, RowBounds pageRowBounds);

    /**
     *
     * @param txHash 交易hash
     */
    List<Transfer> getTx(@Param("txHash") String txHash);

    int getTxCountByAccount(@Param("accountId") long accountId);
}
