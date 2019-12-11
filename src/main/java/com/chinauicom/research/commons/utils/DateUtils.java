/**
 * com.tydic.commons.utils.DateUtils.java
 */
package com.chinauicom.research.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;


 /**
 * @file  DateUtils.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 日期处理类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class DateUtils {
	private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	private static SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static SimpleDateFormat sdf4=new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat sdf5=new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdf6=new SimpleDateFormat("yyyyMMddHH");
	private static SimpleDateFormat sdf7=new SimpleDateFormat("yyMMdd");
	private static SimpleDateFormat sdf8=new SimpleDateFormat("yyyyMM");
	private static SimpleDateFormat sdf9=new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf10=new SimpleDateFormat("yyyy-MM");
	
	public static void main(String args[]){
//		System.out.println("--->"+sdf1.format(new Date()));
//		System.out.println("--->"+sdf2.format(new Date()));
//		System.out.println("--->"+sdf3.format(new Date()));
//		System.out.println("--->"+sdf4.format(new Date()));
//		System.out.println("--->"+sdf5.format(new Date()));
//		System.out.println("--->"+sdf6.format(new Date()));
//		System.out.println("--->"+sdf7.format(new Date()));
//		System.out.println("--->"+sdf8.format(new Date()));
//		System.out.println("--->"+sdf9.format(new Date()));
//		System.out.println(DateUtils.getPreMonthDay("20130321"));
		System.out.println(DateUtils.fastSelectFireMonth("2013-04"));
	}
	
	
	
	/**
	 * 取上月同一天，如果是2月的不一样，则取2月最后一天
	 * @param date
	 * @return
	 */
	public static String getPreMonthDay(String date){
		if(date==null)return null;
		if(date.length()<8)return null;
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf5.parse(date));
		} catch (ParseException e) {
			System.out.println("数据日期转换错误!");
		}
		calendar.add(Calendar.MONTH, -1);
		return DateFormatUtils.format(calendar.getTime(), "yyyyMMdd");
	}
	
	/**
	 * 取得近三个月的月份信息
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static List<String> getThreeMonths(String date) throws ParseException{
		List<String> ret=new ArrayList<String>();
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(sdf5.parse(date)); 
		Calendar a = Calendar.getInstance();
		a.set(Calendar.MONTH, -1);
		return ret;
	}

	/**
	 * 取得指定日期月的天数
	 * @param date
	 * @return
	 */
	public static int getMonthDays(String date){
		if(date==null)return 0;
		if(date.length()<6)return 0;
		return DateUtils.getMonthLastDay(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6)));
	}

	/**
	 * 取得当月天数
	 * */
	public static int getCurrentMonthLastDay(){
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的天数
	 * */
	public static int getMonthLastDay(int year, int month){
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	
	/**
	 * add by yang
	 * 取得年月日天时分秒 
	 * @return 返回yyyy-MM-dd hh:mm:ss格式的字符串
	 */
	public static String getDateString(Date date){
		return sdf1.format(date);
	}
	/**
	 * 取得年月日天时分秒
	 * @return
	 */
	public static String getYmdhms(){
		return sdf4.format(new Date());
	}
	
	public static String getYmdhmsByDate(Date date){
		return sdf4.format(date);
	}
	
	public static String getYmdByDate(Date date){
		return sdf5.format(date);
	}
	
	public static String getYmdByDate2(Date date){
		return sdf9.format(date);
	}
	
	/**
	 * 
	 * @Title: getYmdByString 
	 * @Description: TODO(日期string转换成Date) 
	 * @param @param date
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getYmdByString(String date) throws ParseException{
		return sdf9.parse(date);
	}
	
	/**
	 * 
	 * @Title: getYmdByStr 
	 * @Description: TODO(日期string转换成Date) 
	 * @param @param date
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getYmdByStr(String date) throws ParseException{
		return sdf5.parse(date);
	}
	
	/**
	 * 取得昨天的年的两位与月与日
	 * @return
	 */
	public static String getYesterdayCf(){
		Calendar cal = Calendar.getInstance();  //使用默认时区和语言环境获得一个日历
		cal.add(Calendar.DAY_OF_MONTH, -1);     //取当前日期的前一天.
		return sdf7.format(cal.getTime());		
	}
	
	/**
	 * 取计算时间
	 * @param day
	 * @return
	 */
	public static String calcDate(String date,int day){
		Calendar cal = Calendar.getInstance();  //使用默认时区和语言环境获得一个日历
		try {
			cal.setTime(sdf5.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, day);     //取当前日期的前一天.
		return sdf5.format(cal.getTime());	
	}
	
	/**
	 * 取计算时间
	 * @param day
	 * @return
	 */
	public static String calcDateMonth(String date,int m){
		Calendar cal = Calendar.getInstance();  //使用默认时区和语言环境获得一个日历
		try {
			cal.setTime(sdf8.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.MONTH, m);     //取当前月的前一月.
		return sdf8.format(cal.getTime());	
	}
	
	/**
	 * 取计算时间
	 * @param day
	 * @return
	 */
	public static String calcDateMonth2(String date,int m){
		Calendar cal = Calendar.getInstance();  //使用默认时区和语言环境获得一个日历
		try {
			cal.setTime(sdf8.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.MONTH, m);     //取当前月的前一月.
		return sdf10.format(cal.getTime());	
	}
	
	/**
	 * My97快速五个月
	 * @param date
	 * @return
	 */
	public static String fastSelectFireMonth(String date){
		//'2013-04','2013-05','2013-06','2013-07','2013-08'
		String s="";
		for(int i=0;i<5;i++){
			s+="'"+DateUtils.calcDateMonth2(date.replace("-",""), -(4-i))+"',";
		}
		if(s.length()>0){
			s=s.substring(0,s.length()-1);
		}
		return s;
	}
	
	/**
	 * 取得天:eg 111212
	 * @return
	 */
	public static String getDayCf(){
		Date t=new Date();
		return sdf7.format(t);		
	}
	
	/**
	 * 取得天:eg 20111212
	 * @return
	 */
	public static String getDay(){
		Date t=new Date();
		return sdf5.format(t);		
	}
	
	/**
	 * 取得天:eg 201112
	 * @return
	 */
	public static String getMonth(){
		Date t=new Date();
		return sdf8.format(t);		
	}
	
	/**
	 * 取得天:eg 201112
	 * @return
	 */
	public static String getLastMonth(Date date,int m){
		Calendar cal = Calendar.getInstance();  //使用默认时区和语言环境获得一个日历
		cal.setTime(date);
		cal.add(Calendar.MONTH, m);     //取当前月的前一月.
		return sdf8.format(cal.getTime());		
	}
	
	/**
	 * 取得天时:eg 2011121201
	 * @return
	 */
	public static String getDayHour(){
		Date t=new Date();
		return sdf6.format(t);		
	}
	
	
	public static String getSystemDate(){
		Date t=new Date();
		return sdf3.format(t);
	}
	
	/**
	 * 取得指定:yyyy-MM-dd hh:mm:ss格式的日期
	 * @return
	 */
	public static String NowDateTime(){
		Date t=new Date();
		return sdf1.format(t);
	}
	
	/**
	 * 取得当前年份
	 * @return
	 */
	public static String GetYear(){
		String dateStr=sdf2.format(new Date());
		return dateStr.substring(0,4);
	}
	
	/**
	 * 取得前三年和后五年的年列表
	 * @param year
	 * @return
	 */
	public static String[] getNearbyYear(String year){
		if(year==null){
			return null;
		}
		String[] list=new String[9];
		int intYear=Integer.parseInt(year);
		for(int i=0;i<list.length;i++){
			list[i]=String.valueOf(intYear-3+i);
		}
		return list;
	}
	
	/**
	 * 取前当前年到后三年和前五年的年列表
	 * @return
	 */
	public static String[] getNowNearYear(){
		String dateStr=sdf2.format(new Date());
		return DateUtils.getNearbyYear(dateStr.substring(0,4));
	}
	
	public static String toLocalTime(String utc) {
		return utc.length()>0?sdf4.format(getDate4UTC(Long.parseLong(utc) * 1000)):"";
	}
	
    public static Date getDate4UTC(Long utcTime){
        if(utcTime == null)
            return null;
        else
            return new Date(utcTime.longValue() - (utcTime.longValue() <= 2208988800000L ? 2209017600000L : 2208988800000L));
    }
    
    /**
     * 
     * @param type
     * @param num
     * @param pattern
     * @return
     */
    public static String getDateInfo(String type,int num,String pattern){
    	Calendar calendar = Calendar.getInstance();
    	if("1".equals(type)){
    		calendar.add(Calendar.DATE, num);
    	}
    	else if("2".equals(type)){
    		calendar.add(Calendar.MONTH, num);
    	}
    	else if("3".equals(type)){
    		calendar.add(Calendar.YEAR, num);
    	}
    	Date dt=calendar.getTime();
    	String str =DateFormatUtils.format(dt, pattern);
    	
    	return str;
    }
    
    //按照日构造
    public  final static String  TYPE_DAY="1";
    //按照月构造
    public  final static String  TYPE_MONTH="2";
    //按照年构造
    public  final static String  TYPE_YEAR="3";
    
    //根据指定日期进行相对计算
    public static String getDateInfo(String dateStr, String dateStrFormat, String type,int num,String pattern) throws ParseException{
    	
    	SimpleDateFormat sdf= new SimpleDateFormat(dateStrFormat); 
    	String[] formats=new String[]{dateStrFormat,"yyyy-MM-dd","yyyyMMdd","yyyy-MM","yyyyMM"};
    	Date date =org.apache.commons.lang.time.DateUtils.parseDate(dateStr, formats); //sdf.parse(dateStr); 
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date); 
    	
    	if(TYPE_DAY.equals(type)){
    		calendar.add(Calendar.DATE, num);
    	}
    	else if(TYPE_MONTH.equals(type)){
    		calendar.add(Calendar.MONTH, num);
    	}
    	else if(TYPE_YEAR.equals(type)){
    		calendar.add(Calendar.YEAR, num);
    	}
    	Date dt=calendar.getTime();
    	String str =DateFormatUtils.format(dt, pattern);
    	
    	return str;
    }
    /**将日期字符串按格式输入，按格式返回**/
    public static String convertDateFormat(String dateStr, String inputFormat, String outputFormat) throws ParseException{
    	SimpleDateFormat sdf= new SimpleDateFormat(inputFormat);
    	Date date = sdf.parse(dateStr);
    	String outputDate = new SimpleDateFormat(outputFormat).format(date);
    	return outputDate;
    }
    
    /**
     * 计算时间周期-日报
     * @param code
     * @return
     */
    public static String getDateDay(String date,String code){
    	String ret="";
    	if(code==null)return ret;
		if(code.length()==8){
			return code;
		}
    	int day=0;
    	try{
    		day=Integer.parseInt(code);
    		ret=DateUtils.calcDate(date,day);
    	}catch(Exception e){
    		ret=code;
    	}
    	return ret;
    }
    
    /**
     * 计算时间周期-月报
     * @param code
     * @return
     */
    public static String getDateMonth(String date,String code){
    	String ret="";
    	if(code==null)return ret;
		if(code.length()==6){
			return code;
		}
    	int day=0;
    	try{
    		day=Integer.parseInt(code);
    		ret=DateUtils.calcDateMonth(date,day);
    	}catch(Exception e){
    		ret=code;
    	}
    	return ret;
    }
    /**
     * add by yang
     * 计算两个时间差
     * @param date1
     * @param date2
     * @return 分钟
     * @throws Exception
     */
	public static double getDateSubtract(String date1, String date2) throws Exception {
		double result=-1;
		if(!"".equals(date1)&&null!=date1&&!"".equals(date2)&&null!=date2) {
			java.util.Date start = sdf1.parse(date1);
			java.util.Date end = sdf1.parse(date2);
			long cha = end.getTime() - start.getTime();
			result = cha * 1.0 / (1000 * 60 );
		}
		return result;
	}
	
	/** 
	 * add by yang
     * 增加日期中某类型的某数值。如增加分钟 
     * @param date 日期字符串 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期字符串 
	 * @throws ParseException 
     */  
    public static String addInteger(String date,int amount) throws ParseException { 
    	String dateStr =  "";
    	if(!"".equals(date)&& null!= date) {
			java.util.Date myDate = sdf1.parse(date);
			myDate = addInteger(myDate, Calendar.MINUTE, amount);
			dateStr = sdf1.format(myDate);
    	}

        return dateStr;  
    } 
	
	/** 
	 * add by yang
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期字符串 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期字符串 
	 * @throws ParseException 
     */  
    public static String addInteger(String date, int dateType, int amount) throws ParseException { 
    	String dateStr =  "";
    	if(!"".equals(date)&& null!=date) {;
			java.util.Date myDate = sdf1.parse(date);
			myDate = addInteger(myDate, dateType, amount);
			dateStr = sdf1.format(myDate);
    	}

        return dateStr;  
    } 
    
    /**
     * add by yang 
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    public static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  

    /**
     * 
     * @param startDate
     * @param endDate
     * @param type
     * @param num
     * @param inPattern
     * @param outPattern
     * @return 
     * @throws ParseException
     */
    public static ArrayList<String> getDataBetween(String startDate , String endDate , String type , int num , String inPattern ,String outPattern) throws ParseException{
    	SimpleDateFormat formatIn = new SimpleDateFormat(inPattern);
    	SimpleDateFormat formatOut = new SimpleDateFormat(outPattern);
    	ArrayList<String> dateList = new ArrayList<String>();
    	Date date1 = null;
    	Date date2 = null;
    	if(StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)){//两个都为null
    		System.out.println("两个日期都为null");
    	}else if(StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)){//其中一个为null
    		String dateString = !StringUtils.isEmpty(startDate) ?  startDate : endDate;
    		dateString = getDateInfo(dateString, inPattern, type, num, outPattern);
    		dateList.add(dateString);
    	}else if(startDate.equals(endDate)){//两个都不为null，且相等
        	String sameDate = formatOut.format(formatIn.parse(startDate));
        	sameDate = getDateInfo(sameDate, inPattern, type, num, outPattern);
        	dateList.add(sameDate);
		}else{//两个都不为null，都不相等
			if(startDate.compareTo(endDate) > 0){//将日期较大的放后面
				String tmp = endDate;
				endDate = startDate;
				startDate = tmp;
			}
			
//			date1 = formatIn.parse(startDate);
			startDate = getDateInfo(startDate, inPattern, type, num, inPattern);
			date1 = formatIn.parse(startDate);
			date2 = formatIn.parse(endDate);
			
			String calcDate = startDate;
			String outDate = "";
			outDate = formatOut.format(date1);
			dateList.add(outDate);
			
	        while(calcDate.compareTo(endDate) < 0){
	        	calcDate = getDateInfo(calcDate, inPattern, type, 1, inPattern);
	        	outDate = formatOut.format(formatIn.parse(calcDate));
	        	dateList.add(outDate);
	        }
		}
//    	for (int i = 0; i < dateList.size(); i++) {
//			System.out.println("!!!!!!!!!!!!!!"+dateList.get(i));
//		}
    	return dateList;
    }
    /**根据日期类型判断是否**/
    public static String getStatusByDateType(String dateStr , String format){
    	if(dateStr == null){
    		dateStr = "";
    	}
    	dateStr = dateStr.trim();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			if(format.length() == dateStr.length()){
				date = sdf.parse(dateStr);
			}else{
				return "0";
			}
			
//			System.out.println("Date = " + date);
			return "1";
		} catch (ParseException ex) {
			ex.printStackTrace();
			return "0";
		}
	}
    
    /**
     * 判断时间上午下午
     * 0 上午 1 下午
     * @param date 当前时间上下午判断
     */
    public static int datePM_AM(Date date){
    	
    	if(date.getHours()>14){
    		return 1;
    	}
    	else{
    		return 0;
    	}
    }
    
    /**
     * 区分两个日期之间指定字段的差值
     * 
     * @param time1
     *            开始时间
     * @param time2
     *            结束时间
     * @param field
     *            要比较的字段(年，月，日,...)
     * @return 如果time1>time2就反回一个正的差值,如果time1<time2则返回一个负的差值,如果相等，返回0
     */
    public static int getFieldDifference(long time1, long time2, int field) {
        if (time1 == time2) {
            return 0;
        } else if (time1 > time2) {
            return -getFieldDifference(time2, time1, field);
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setLenient(false);
        cal1.setTimeInMillis(time1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setLenient(false);
        cal2.setTimeInMillis(time2);
        for (int x = 0; x < Calendar.FIELD_COUNT; x++) {
            if (x > field) {
                cal1.clear(x);
                cal2.clear(x);
            }
        }
        time1 = cal1.getTimeInMillis();
        time2 = cal2.getTimeInMillis();
 
        long ms = 0;
        int min = 0, max = 1;
 
        while (true) {
            cal1.setTimeInMillis(time1);
            cal1.add(field, max);
            ms = cal1.getTimeInMillis();
            if (ms == time2) {
                min = max;
                break;
            } else if (ms > time2) {
                break;
            } else {
                max <<= 1;
            }
        }
 
        while (max > min) {
            cal1.setTimeInMillis(time1);
            int t = (min + max) >>> 1;
            cal1.add(field, t);
            ms = cal1.getTimeInMillis();
            if (ms == time2) {
                min = t;
                break;
            } else if (ms > time2) {
                max = t;
            } else {
                min = t;
            }
        }
        return -min;
    }   
    
    /**
     * 比较身份证中的时间是否满18周岁
     * @param postId  18位身份证号码
     * @return ture满18周岁 false 没有满18周岁
     * @throws Exception 
     */
    public static boolean checkAge(String postId) throws Exception{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String postSub=null;
		Date date=new Date();
		Date date2=null;
    	
    	postSub=postId.substring(6, 14);//截取身份证的时间
		System.out.println("截取身份证的时间"+postSub);
		Integer year=Integer.parseInt(postSub.substring(0,4))+18;
		String sub=year.toString()+"-"+postSub.substring(4, 6)+"-"+postSub.substring(6, 8);
		System.out.println("截取身份证的时间"+sub);
		Date dateSub=sdf.parse(sub);
		System.out.println("----"+dateSub);
		
		String sdff=sdf.format(date);
		date2=sdf.parse(sdff);
		
		Long startTime=dateSub.getTime();
		Long endTime=date2.getTime();
		System.out.println("----"+startTime+"----"+endTime);
		Long is=endTime-startTime;
		if(is>0){
			return true;
		}
		return false;
	}
    
//    public static void main(String[] args) throws ParseException {
    	
//    	List rtn =getDataBetween("2013-12-02", "2013-12-18", "1", 0, "yyyy-MM-dd", "yyyyMMdd");
    	
//    	System.out.println(rtn);

//    	String s=DateUtils.calcDateMonth("201301", -1);
    	// String getDateInfo(String dateStr, String dateStrFormat, String type,int num,String pattern)
//    	try {
//			System.out.println(getDateInfo("2013-07-22 17:20:01","yyyy-MM-dd hh:mm:ss","2",2,"yyyy-MM-dd hh:mm:ss"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	String date1 = "2012-3-12 10:43:32";
//    	String date2 = "2012-3-12 11:00:00";
//    	try {
//			System.out.println("相差" +(int) getDateSubtract(date1, date2)/2 + "分钟");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String s=DateUtils.calcDateMonth("201301", -1);
//    	String str1 = "2013-08";
//    	String str2 = "2013-09";
//    	String inPattern = "yyyy-MM";
//    	String outPattern = "yyyyMM";
//    	String type = "2";//类型
//    	String aaa =(String)null;
//    	System.out.println(aaa);

    	
    	//String aa = null;
    	//System.out.println(StringUtils.isEmpty(aa));
    	
//	}
    /**
     * 设置日期的时间为最后一秒
     * * @param 日期参数
     * @return 时间为23：59：59的日期
     * @throws Exception 
     */
    public static Date getDateLastTime(Date expDate) throws Exception{
    	String expDateToSTring = sdf1.format(expDate);
    	expDateToSTring = expDateToSTring.replace("00:00:00", "23:59:59");
    	
		return sdf1.parse(expDateToSTring);
	}
    
    /**
	 * 
	 * @Title: getYmdByString 
	 * @Description: TODO(日期string转换成Date) 
	 * @param @param date
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getHymdsByString(String date) throws ParseException{
		return sdf1.parse(date);
	}
}
