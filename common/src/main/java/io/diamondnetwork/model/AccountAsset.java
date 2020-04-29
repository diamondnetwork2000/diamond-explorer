package io.diamondnetwork.model;

import burst.kit.crypto.BurstCrypto;
import burst.kit.entity.BurstID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
public class AccountAsset {
    private long accountId;
    private long assetId;
    private String assetName;
    @JsonIgnore
    private long assetTotalQuantity;
    private long quantity;
    @JsonIgnore
    private long unconfirmedQuantity;
    private int height;


    //含有份额， .1代表10%
    public BigDecimal getShare() {
        BigDecimal share = new BigDecimal(quantity).divide(new BigDecimal(assetTotalQuantity), 4, RoundingMode.HALF_UP);
        return share;
    }

    public long getFrozenQuantity() {
        return quantity - unconfirmedQuantity;
    }

    public String getAccountRs() {
        String rs = BurstCrypto.getInstance().rsEncode(BurstID.fromLong(accountId));
        return "1x" + rs.replaceAll("-","");
    }

    public String getAssetStrId() {
        return String.valueOf(assetId);
    }
}
