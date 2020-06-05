package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "t_message")
public class Message {
    private long id;
    private TransactionType type;
    private String sender;
    private String txHash;
    private String jsonContent;
    private Date createdAt;
    private int height;
}
