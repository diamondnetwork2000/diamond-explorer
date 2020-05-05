package io.diamondnetwork.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

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
    //内置货币的余额
    @TableField(exist = false)
    private long balance;
}
