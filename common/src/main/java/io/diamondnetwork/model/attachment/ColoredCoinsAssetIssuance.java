package io.diamondnetwork.model.attachment;

import io.diamondnetwork.model.Attachment;
import io.diamondnetwork.util.Constants;
import io.diamondnetwork.util.Convert;
import lombok.Data;

import java.nio.ByteBuffer;
@Data
public class ColoredCoinsAssetIssuance extends Attachment {
    private final String name;
    private final String description;
    private final long quantityQNT;
    private final byte decimals;

    public ColoredCoinsAssetIssuance(ByteBuffer buffer, byte transactionVersion)  {
        super(buffer, transactionVersion);
        this.name = Convert.readString(buffer, buffer.get(), Constants.MAX_ASSET_NAME_LENGTH);
        this.description = Convert.readString(buffer, buffer.getShort(), Constants.MAX_ASSET_DESCRIPTION_LENGTH);
        this.quantityQNT = buffer.getLong();
        this.decimals = buffer.get();
    }
}
