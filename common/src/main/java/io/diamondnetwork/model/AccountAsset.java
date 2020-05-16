package io.diamondnetwork.model;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("Account Asset")
public class AccountAsset {
    private String address;
    private String assetName;
    private long quantity;
    private long frozenQuantity;
    private int height;
    private long totalSupply;

    public AccountAsset(String address, String assetName,Long quantity) {
        this.address = address;
        this.assetName = assetName;
        this.quantity = quantity;
    }

    public BigDecimal getShare() {
        if (totalSupply == 0) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(quantity).add(BigDecimal.valueOf(frozenQuantity))
                .divide(BigDecimal.valueOf(totalSupply), 4, RoundingMode.HALF_UP);
    }
}
