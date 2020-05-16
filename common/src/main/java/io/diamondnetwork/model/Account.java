package io.diamondnetwork.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.diamondnetwork.util.Convert;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bitcoinj.core.Bech32;
import org.bouncycastle.util.encoders.Hex;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("account")
@TableName(value = "t_account")
public class Account {
    private long id;
    private String address;
    private int assetNum;
    private int txNum;
    private long fee;
    private Date createdAt;
    private int creationHeight;
    @TableField(exist = false)
    private long balance;

    @TableField(exist = false)
    private byte[] publicKey;


    /**
     * @return
     * @throws Exception
     */
    public String toEd25519HexAddress() throws Exception {
        byte[] sha256 = Convert.SHA256(publicKey);
        //https://github.com/tendermint/spec/blob/master/spec/blockchain/encoding.md
        //the address of ed25519 is the first 20 byte of hash value
        return Hex.toHexString(sha256, 0, 20).toUpperCase();
    }

    public static Account fromBech32PublicKey(String publicKey){
        Account a = new Account();
        Bech32.Bech32Data decode = Bech32.decode(publicKey);

        byte[] conbered = Convert.convert(decode.data, 5, 8, false);
        byte[] c = new byte[32];
        //refer to https://github.com/tendermint/spec/blob/master/spec/blockchain/encoding.md
        //the first 5 bytes is prefix of amino encoder, not part of public key
        System.arraycopy(conbered, 5, c, 0, 32);

        a.publicKey = c;
        return a;
    }
}
