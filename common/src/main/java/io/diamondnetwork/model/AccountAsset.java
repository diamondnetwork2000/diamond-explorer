package io.diamondnetwork.model;


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
@ApiModel("Account Asset")
public class AccountAsset {
    private String address;
    private String assetName;
    private BigInteger quantity;
    private BigInteger frozenQuantity = BigInteger.ZERO;
    private int height;
    private BigInteger totalSupply;

    public AccountAsset(String address, String assetName,BigInteger quantity) {
        this.address = address;
        this.assetName = assetName;
        this.quantity = quantity;


    }


    public BigDecimal getShare() {
        if (totalSupply.compareTo(BigInteger.ZERO) == 0) {
            return BigDecimal.ZERO;
        }



        return new BigDecimal(quantity).add(new BigDecimal(frozenQuantity))
                .divide(new BigDecimal(totalSupply), 4, RoundingMode.HALF_UP);
    }
}
