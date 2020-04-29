package io.diamondnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order {
    private long id;
    private long accountId;
    private long assetId;
    private String assetName;
    private long quoteAssetId;
    private String quoteAssetName;
    private long price;
    private long quantity;
    private int timestamp;
    private int creationHeight;
    private byte latest;
}
