package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.model.enums.TransactionType;
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
@ApiModel("transfer record")
@TableName(value = "t_transfer")
public class Transfer {
    @TableId
    private long id;
    private String token;
    private String sender;
    private TransactionType type;
    private String recipient;
    private long amount;
    private String txHash;
    private Date createdAt;
    private int height;
}
