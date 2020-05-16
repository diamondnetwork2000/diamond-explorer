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
@ApiModel("ed25519")
@TableName(value = "t_validator")
public class Validator {
    private long id;
    //the prefix is “account prefix” + “valoper” + 1 + address
    private String operatorAddress;
    /**
     *  the prefix is “account prefix”  + 1 + address
     *
     */
    private String address;
    /**
     *
     * for example. dkdvalconspub1zcjduepqp25nn4nzz2fqksc2f20r5wc846lvjgcy9hctc8c9c2yeez5fr6gs78c3aj
     */
    private String consensusPubkey;
    /**
     *
     * the ed25519 address of consensusPubkey
     */

    private String proposerAddress;
    /**
     * node name
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
