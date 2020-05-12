package com.cmd.exchange.common;

import io.diamondnetwork.util.DateUtil;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {

    @Test
    public void testBlockTime() {
        String blockTime = "2020-05-12T01:57:03.649461808Z";
        Date blockDateTime = DateUtil.getBlockTime(blockTime);

        System.out.println(blockDateTime);
    }
}
