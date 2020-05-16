package io.diamondnetwork.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
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
        timestamp = timestamp.substring(0, timestamp.lastIndexOf(".")) ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return sdf.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date getTxTime(String timestamp) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return sdf.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
