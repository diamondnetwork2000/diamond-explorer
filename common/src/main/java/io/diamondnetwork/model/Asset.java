package io.diamondnetwork.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel("asset")
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

    @TableField(exist = false)
    private int transferNum;
    @TableField(exist = false)
    private int holderNum;
}
