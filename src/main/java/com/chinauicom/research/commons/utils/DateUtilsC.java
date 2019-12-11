package com.chinauicom.research.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
 

public class DateUtilsC {
	private static final Logger log = Logger.getLogger(DateUtils.class);
	
    /**
     * 获取某年某月某日后的一个时刻
     *
     * @param unit 时间单位
     * @param time 延后时间
     * @return
     */
    public static String addTime(int unit, int time) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cl = Calendar.getInstance();
        cl.add(unit, time);
        dt = cl.getTime();
        return sdf.format(dt);
    }

    public static String getTime() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dt);
    }

    public static String getTimeYMD() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dt);
    }

    public static String getTimeYMD(Date date) {
        if(date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getTimeYMDHMS(Date date) {
        if(date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getTimeYM(Date date) {
        if(date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }

    public static String getCurrentTimeStamp() {
        return System.currentTimeMillis() + "";
    }

    public static Date getDateYMDHMS(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
        	log.info("异常:" , e);
            return null;
        }
    }

    public static Date getDateYMD(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
        	log.info("异常:" , e);
            return null;
        }
    }
}