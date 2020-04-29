package io.diamondnetwork.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 获取日期字符串
     *
     * @param time
     *            Date
     * @return yyyy-MM-dd
     */
    public static String getDateTimeString(Date time) {
        return sdf.format(time);
    }

    public static Date getDate(String date) {
        if (date == null || (date.length() != 10 && date.length() != 19)) {
            return null;
        }
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static int getDayBeginTimestamp(long timeMillis) {
        // 计算当天0点的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date todayBegin = calendar.getTime();
        int todayBeginTimestamp = (int)(todayBegin.getTime()/1000);
        return todayBeginTimestamp;
    }

    public static Date getBlockTime(String timestamp) {
        return cn.hutool.core.date.DateUtil.parse(timestamp, "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'");
    }

    public static Date getTxTime(String timestamp) {
        return cn.hutool.core.date.DateUtil.parse(timestamp, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }
}
