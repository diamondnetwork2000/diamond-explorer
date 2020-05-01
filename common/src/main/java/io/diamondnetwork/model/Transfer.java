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
@ApiModel("转账记录")
@TableName(value = "t_transfer")
public class Transfer {
    private long id;
    private String txHash;
    private String sender;
    private String recipient;
    private String token;
    private long amount;
    private Date createdAt;
    private int height;
}
