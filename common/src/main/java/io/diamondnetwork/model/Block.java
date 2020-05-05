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
@ApiModel("区块")
@TableName(value = "t_block")
public class Block {
    @TableId
    private int id;
    @ApiModelProperty("高度")
    private int height;
    @ApiModelProperty("创建时间戳，该区块相对创世区块过去了多少秒")
    private Date createdAt;
    @ApiModelProperty("挖矿奖励")
    private long reward;
    @ApiModelProperty("发送数量")
    private long sent;
    @ApiModelProperty("交易数量（次数）")
    private int txNum;
    @ApiModelProperty("挖矿账号")
    @TableField(value = "created_by")
    private String generator;
    @ApiModelProperty("挖矿账号")
    private long fee;
    @ApiModelProperty("版本号")
    private int version;
    @ApiModelProperty("区块大小")
    private int size;
    @TableField(value = "hash")
    @ApiModelProperty("签名值")
    private String signature;

    public static Block from(BlockDetail body) {
        Block block = new Block();
        block.setHeight(body.getBlock_meta().getHeader().getHeight());
        block.setSignature(body.getBlock_meta().getBlock_id().getHash());
        block.setCreatedAt(DateUtil.getBlockTime(body.getBlock_meta().getHeader().getTime()));
        block.setFee(0);
        block.setSent(0L).setReward(0L);
        block.setGenerator(body.getBlock_meta().getHeader().getProposer_address());
        block.setVersion(Integer.valueOf(body.getBlock_meta().getHeader().getVersion().getApp()));
        block.setSize(Integer.valueOf(body.getBlock_meta().getBlockSize()));
        block.setGenerator(body.getBlock().getHeader().getProposer_address());
        block.setTxNum(Integer.valueOf(body.getBlock().getHeader().getNum_txs()));

        return block;
    }
}
