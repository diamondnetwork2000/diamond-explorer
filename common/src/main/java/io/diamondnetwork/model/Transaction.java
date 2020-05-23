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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
@TableName(value = "t_transaction")
public class Transaction {
    private long id;
    @ApiModelProperty("1 转账（包括内置货币和代币的转账） 2: 创建订单 3： 取消订单 4 发行代币 5 创建交易市场")
    private TransactionType type;
    private Boolean success;
    private String hash;
    private String sender;
    private String recipient;
    private String memo;
    private long fee;

    private Date createdAt;
    private int height;
    private int msgNum;
    @TableField(exist = false)
    private Block block;

    @TableField(exist = false)
    private List<Transfer> transfers;
}
