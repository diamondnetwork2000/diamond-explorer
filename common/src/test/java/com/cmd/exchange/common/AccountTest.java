package com.cmd.exchange.common;

import cn.hutool.core.codec.Base64;
import io.diamondnetwork.model.Account;
import org.bitcoinj.core.Bech32;
import org.junit.Test;

import java.util.Arrays;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testHex() throws Exception {
        Account a = Account.fromBech32PublicKey("dkdvalconspub1zcjduepqp25nn4nzz2fqksc2f20r5wc846lvjgcy9hctc8c9c2yeez5fr6gs78c3aj");

        byte[] publicKeyFromBase64 = Base64.decode("Cqk51mISkgtDCkqeOjsHrr7JIwQt8LwfBcKJnIqJHpE=");
        assertTrue(Arrays.equals(publicKeyFromBase64, a.getPublicKey()), "从Base64解码的公钥和从Bech32里解码的公钥应该一致");
        assertEquals("从公钥生成的ed25519地址","78A37531AB9E5706DBD90C6AE237E9CC8751EC91",a.toEd25519HexAddress());
    }


    @Test
    public void testBech() {
        Bech32.Bech32Data dataWithPrefix1 = Bech32.decode("dkdvaloper1009xrk0arzqtd0g9pmn2gw6nd2k5zhkvytyn4j");
        Bech32.Bech32Data dataWithPrefix2 = Bech32.decode("dkd1009xrk0arzqtd0g9pmn2gw6nd2k5zhkvthtwte");

        assertTrue(Arrays.equals(dataWithPrefix1.data, dataWithPrefix2.data), "不同前缀对应的数据应该一致");
    }
}
