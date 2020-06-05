package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.model.enums.TransactionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("transaction")
@TableName(value = "t_transaction")
public class Transaction {
    private long id;
    private TransactionType type;
    private Boolean success;
    private String hash;
    private String sender;
    private String recipient;
    private String memo;
    //fee is fixed
    private long fee = 100000L;

    private Date createdAt;
    private int height;
    private int msgNum;
    @TableField(exist = false)
    private Block block;

    @TableField(exist = false)
    private List<Transfer> transfers;
    @TableField(exist = false)
    private List<Order> orders;
    @TableField(exist = false)
    private List<Message> messages;
}
