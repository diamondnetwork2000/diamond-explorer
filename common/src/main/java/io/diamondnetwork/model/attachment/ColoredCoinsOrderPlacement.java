package io.diamondnetwork.model.attachment;

import io.diamondnetwork.model.Attachment;
import lombok.Data;

import java.nio.ByteBuffer;
@Data
public class ColoredCoinsOrderPlacement extends Attachment {
    private final long assetId;
    private String assetName;
    private String quoteAssetName;
    private long quoteAssetId = 0; //用来计算价格的资产id, 0说明用BURST计价
    private final long quantityQNT;
    private final long priceNQT;
    private int timestamp;

    public ColoredCoinsOrderPlacement(ByteBuffer buffer, byte transactionVersion) {
        super(buffer, transactionVersion);
        this.assetId = buffer.getLong();
        this.quantityQNT = buffer.getLong();
        this.priceNQT = buffer.getLong();
        this.quoteAssetId = buffer.getLong();
        if (buffer.limit() > 33) {
            //timestamp这个字段是后面增加的，以前保存的交易中没有这个字段
            this.timestamp = buffer.getInt();
        }

    }
}
