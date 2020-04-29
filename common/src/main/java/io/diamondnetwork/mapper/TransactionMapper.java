package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TransactionMapper extends BaseMapper<Transaction> {
    Page<Transaction> getTxList(@Param("height") Integer height, RowBounds pageRowBounds);
    Page<Transaction> getTxListByAccount(@Param("accountId") long accountId, RowBounds pageRowBounds);

    Transaction getTx(@Param("txHash") byte[] txHash);

    int getTxCountByAccount(@Param("accountId") long accountId);
}
