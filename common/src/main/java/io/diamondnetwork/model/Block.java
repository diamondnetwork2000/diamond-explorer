package io.diamondnetwork.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.task.response.BlockDetail;
import io.diamondnetwork.util.DateUtil;
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
@ApiModel("block")
@TableName(value = "t_block")
public class Block {
    @TableId
    private int id;
    @ApiModelProperty("height")
    private int height;
    private Date createdAt;
    private long reward;
    private long sent;
    private int txNum;
    private String proposerAddress;
    private long fee;
    private int version;
    private int size;
    @TableField(value = "hash")
    private String signature;
    @TableField(exist = false)
    private String generator;
    @TableField(exist = false)
    private String operatorAddress;

    public static Block from(BlockDetail body) {
        Block block = new Block();
        block.setHeight(body.getBlock_meta().getHeader().getHeight());
        block.setSignature(body.getBlock_meta().getBlock_id().getHash());
        block.setCreatedAt(DateUtil.getBlockTime(body.getBlock_meta().getHeader().getTime()));
        block.setFee(0);
        block.setSent(0L).setReward(0L);
        block.setProposerAddress(body.getBlock_meta().getHeader().getProposer_address());
        block.setVersion(Integer.valueOf(body.getBlock_meta().getHeader().getVersion().getApp()));
        block.setSize(Integer.valueOf(body.getBlock_meta().getBlockSize()));
        block.setTxNum(Integer.valueOf(body.getBlock().getHeader().getNum_txs()));

        return block;
    }
}
