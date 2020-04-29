package io.diamondnetwork.model;


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
@ApiModel("区块")
@TableName(value = "t_account")
public class Account {
    private long id;
    private String address;
    private int assetNum;
    private int txNum;
    private long fee;
    private Date createdAt;
    private int creationHeight;
}
