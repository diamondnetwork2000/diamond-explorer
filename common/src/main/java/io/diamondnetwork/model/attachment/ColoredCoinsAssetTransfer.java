package io.diamondnetwork.model.attachment;

import io.diamondnetwork.model.Attachment;
import io.diamondnetwork.util.Constants;
import io.diamondnetwork.util.Convert;
import lombok.Data;

import java.nio.ByteBuffer;


@Data
public class ColoredCoinsAssetTransfer extends Attachment {
    private final long assetId;
    private final long quantityQNT;
    private final String comment;
    private String assetName;

    public ColoredCoinsAssetTransfer(ByteBuffer buffer, byte transactionVersion)  {
        super(buffer, transactionVersion);
        this.assetId = buffer.getLong();
        this.quantityQNT = buffer.getLong();
        this.comment = getVersion() == 0 ? Convert.readString(buffer, buffer.getShort(), Constants.MAX_ASSET_TRANSFER_COMMENT_LENGTH) : null;
    }
}
