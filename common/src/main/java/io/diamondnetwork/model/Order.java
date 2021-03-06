package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "t_order")
public class Order {
    private long id;
    private TransactionType type;
    private String sender;
    private String txHash;
    private String tradingPair;
    private int pricePrecision;
    private BigInteger price;
    private BigInteger quantity;
    //1: buy 2: sell
    private int side;
    private Date createdAt;
    private int height;
}
