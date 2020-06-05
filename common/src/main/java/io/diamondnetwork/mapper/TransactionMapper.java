package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import io.diamondnetwork.model.Message;
import io.diamondnetwork.model.Order;
import io.diamondnetwork.model.Transaction;
import io.diamondnetwork.model.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TransactionMapper extends BaseMapper<Transaction> {
    Page<Transaction> getTxList(@Param("height") Integer height, RowBounds pageRowBounds);
    Page<Transfer> getTxListByAccount(@Param("address") String address, RowBounds pageRowBounds);

    Transaction getTx(@Param("txHash") String txHash);


    int countTxByHash(@Param("hash") String hash);

    List<Order> getOrdersByTxHash(@Param("txHash")  String hash);
    List<Message> getMessagesByTxHash(@Param("txHash")  String hash);
}
