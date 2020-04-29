package io.diamondnetwork.model;

import burst.kit.crypto.BurstCrypto;
import burst.kit.entity.BurstID;
import io.diamondnetwork.util.Constants;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
public class AssetTransfer {
    private long id;
    private long assetId;
    private long senderId;
    private long recipientId;
    private long quantity;
    private int createdAt;
    private int height;

    public String getSender() {
        String rs = BurstCrypto.getInstance().rsEncode(BurstID.fromLong(senderId));
        return "1x" + rs.replaceAll("-","");
    }

    public String getRecipient() {
        String rs = BurstCrypto.getInstance().rsEncode(BurstID.fromLong(recipientId));
        return "1x" + rs.replaceAll("-","");
    }

    public int getCreatedAt() {
        return this.createdAt + Constants.GENESIS_TIME_STAMP;
    }

}
