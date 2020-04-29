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
public class Asset {
    private long id;
    private String name;
    private String description;
    private long height;
    private int createdAt;
    private long quantity;
    private long issuerId;
    private byte decimals;
    //和该资产相关的转账数量
    private int transferNum;
    //持有该资产的用户数量
    private int holderNum;

    public String getIssuer() {
        String rs = BurstCrypto.getInstance().rsEncode(BurstID.fromLong(issuerId));
        return "1x" + rs.replaceAll("-","");
    }

    ////浏览器对长度太大的数字会丢失精度，所以浏览器用这个字段
    public String getStrId() {
        return String.valueOf(id);
    }

    public int getCreatedAt() {
        return this.createdAt + Constants.GENESIS_TIME_STAMP;
    }
}
