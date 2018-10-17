package com.jis.platform.fmj.sfexpress;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 当前时间是否在开始时间和结束时间之间
     * @param start
     * @param end
     * @return
     */
    public static boolean diffNow(Date start, Date end){
        return start.getTime()  <  System.currentTimeMillis() &&
                System.currentTimeMillis() < end.getTime();
    }

    public static Date str2Date(String date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
