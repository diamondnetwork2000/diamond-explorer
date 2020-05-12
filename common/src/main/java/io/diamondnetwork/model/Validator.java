package io.diamondnetwork.model;



import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bitcoinj.core.Bech32;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("区块")
@TableName(value = "t_validator")
public class Validator {
    private long id;
    //运营商地址， 前缀是 “账户地址前缀” + “valoper” + 1 + 地址
    private String operatorAddress;
    /**
     *  验证人地址， 前缀是 “账户地址前缀”  + 1 + 地址
     *
     */
    private String address;
    /**
     * 验证节点的公钥
     * dkdvalconspub1zcjduepqp25nn4nzz2fqksc2f20r5wc846lvjgcy9hctc8c9c2yeez5fr6gs78c3aj
     */
    private String consensusPubkey;
    /**
     * 验证节点的地址
     * consensusPubkey对应的25519地址
     */

    private String proposerAddress;
    /**
     * 验证人节点的名称
     */

    private String moniker;
    private int status;

    private Date createdAt;

    public Validator(String moniker, String consensusPubkey, String operatorAddress) {
        this.moniker = moniker;
        this.consensusPubkey = consensusPubkey;
        this.operatorAddress = operatorAddress;

        Bech32.Bech32Data dataWithPrefix1 = Bech32.decode(operatorAddress);
        this.address = Bech32.encode("dkd", dataWithPrefix1.data);
        Account a = Account.fromBech32PublicKey(consensusPubkey);
        try {
            this.proposerAddress = a.toEd25519HexAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
