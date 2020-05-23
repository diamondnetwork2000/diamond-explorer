package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import io.diamondnetwork.model.enums.TransactionType;
import io.swagger.annotations.ApiModel;
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
@ApiModel("bill record for account")
@TableName(value = "t_bill")
public class Bill {
    @TableId
    private long id;
    private String token;
    /**
     * if changeAmount < 0 then sender is the account
     */
    private String sender;
    private TransactionType type;
    private String recipient;
    /**
     * if changeAmount > 0 then recipient is the account
     */
    private BigInteger changeAmount;
    private String account;
    private String txHash;
    private Date createdAt;
    private int height;
}
