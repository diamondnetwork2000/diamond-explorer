package io.diamondnetwork.model;

import burst.kit.crypto.BurstCrypto;
import burst.kit.entity.BurstID;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.util.Constants;
import io.swagger.annotations.ApiModel;
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
@TableName(value = "t_asset")
public class Asset {
    @TableId
    private long id;
    private String name;
    private String description;
    private long creationHeight;
    private Date createdAt;
    private long totalSupply;
    private String issuer;
    private int decimals;

    //和该资产相关的转账数量
    @TableField(exist = false)
    private int transferNum;
    //持有该资产的用户数量
    @TableField(exist = false)
    private int holderNum;
}
