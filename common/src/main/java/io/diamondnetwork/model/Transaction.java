package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
@TableName(value = "t_transaction")
public class Transaction {
    private long id;
    @ApiModelProperty("0:普通支付， 2：发行资产 资产转账 下单 撤单 成交")
    private String type;
    private String hash;
    private String sender;
    private String recipient;
    private String memo;
    private long fee;
    //不是普通支付的交易会带有额外信息
    @ApiModelProperty("0:普通支付， 2：发行资产")
    private Attachment attachment;
    private Date createdAt;
    private int height;
    private int msgNum;
    //查询详情时会返回区块的信息
    private Block block;

}
