package com.chinauicom.research.commons.utils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;



public class DateUtil
{
	public static final String DATEFORMAT = "yyyy-MM-dd";// 系统统一日期格式

	public static final String DATEFORMAT2 = "yyyyMMdd";// 系统统一日期格式2

	public static final String DATEFORMAT3 = "yyyy-MM-dd HH:mm";// 系统统一日期格式3

	public static final String DATEFORMAT4 = "yyyyMMddHHmmss";// 系统统一日期格式3

	public static final String DATEFORMAT5 = "yyyy-MM-dd HH:mm:ss";// 系统统一日期格式3
	
	public static final String DATEFORMAT6 = "HH:mm";//系统系统一日期格式6;

	public static final String YEARFORMAT = "yyyy";// 系统统一年份格式

	public static final String MONTHFORMAT = "MM";// 系统统一月份格式

	public static final String DAYFORMAT = "dd";// 系统统一天数格式

	public static final String YYYYMM="yyyyMM";

	public static String GbkToIso(String str)
	{
		if (str == null)
			return str;
		try
		{
			return new String(str.getBytes("GBK"), "8859_1");
		} catch (UnsupportedEncodingException e)
		{
			return str;
		}
	}

	public static String IsoToGbk(String str)
	{
		if (str == null)
			return str;
		try
		{
			return new String(str.getBytes("ISO8859_1"), "GBK");
		} catch (UnsupportedEncodingException e)
		{
			return str;
		}
	}

	/*
	 * 将日期转换成系统设定的日期格式模式的字符串
	 */
	public static String DateToString(Date date)
	{
		return DateToString(date, DATEFORMAT);
	}

	public static String DateToString3(Date date)
	{
		return DateToString(date, DATEFORMAT3);
	}

	public static String DateToString4(Date date)
	{
		return DateToString(date, DATEFORMAT4);
	}

	public static String DateToString5(Date date)
	{
		return DateToString(date, DATEFORMAT5);
	}
	
	public static Date StringTODate5(String date)
	{
		return StringTODate(date, DATEFORMAT5);
	}

	/*
	 * 将日期转换成指定日期格式模式的字符串
	 */
	public static String DateToString(Date date, String format)
	{
		String str = "";
		if (date != null)
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			str = simpleDateFormat.format(date);
		}
		return str;
	}

	/*
	 * 将日期转换成系统设定的日期格式模式的字符串
	 */
	public static String DateToString2(Date date)
	{
		return DateToString(date, DATEFORMAT2);
	}

	/*
	 * 取的日期的年份
	 */
	public static String DateToYear(Date date)
	{
		String str = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEARFORMAT);
		str = simpleDateFormat.format(date);
		return str;
	}

	/*
	 * 取的日期的月份
	 */
	public static String DateToMonth(Date date)
	{
		String str = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MONTHFORMAT);
		str = simpleDateFormat.format(date);
		return str;
	}

	/*
	 * 取的日期的天数
	 */
	public static String DateToDay(Date date)
	{
		String str = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAYFORMAT);
		str = simpleDateFormat.format(date);
		return str;
	}

	/*
	 * 
	 * 字符串转换成日期，前提是字符串符合统一日期格式
	 */
	public static Date StringTODate(String str)
	{
		Date date = null;
		if(StringUtils.isNotBlank(str)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
			try
			{
				date = simpleDateFormat.parse(str);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		return date;
	}

	/*
	 * 
	 * 指定格式的字符串转换成日期
	 */
	public static Date StringTODate(String str, String format)
	{
		Date date = null;
		if(StringUtils.isNotBlank(str)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			try
			{
				date = simpleDateFormat.parse(str);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		return date;
	}

	/*
	 * 
	 * 将数据库得日期格式转换成系统显示得日期字符串
	 */
	public static String SqlDateTOString(java.sql.Date sqlDate)
	{
		if (sqlDate == null)
			return null;

		String str = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
		java.util.Date javaDate = null;
		try
		{
			javaDate = simpleDateFormat.parse(sqlDate.toString());
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		str = simpleDateFormat.format(javaDate);
		return str;
	}

	/*
	 * 
	 * 把系统日期格式的字符串转换成数据库格式的java.sql.Date,如果字符串为空则返回NULL函数的局限在于只能转yyyy-mm-dd类型的
	 */
	public static java.sql.Date StringTOSqlDate(String str)
	{
		java.sql.Date sqlDate = null;
		if (!("").equals(str) & null != str)
		{
			sqlDate = java.sql.Date.valueOf(str);
		}
		return sqlDate;
	}

	/*
	 * 直接转换java.util.Date到java.sql.Date
	 * 
	 * 转换会截掉小时,分,秒信息
	 */
	public static java.sql.Date Date2SqlDate(java.util.Date date)
	{
		return new java.sql.Date(date.getTime());
	}

	/*
	 * 直接转换java.util.Date到java.sql.Timestamp
	 */
	public static java.sql.Timestamp Date2Timestamp(java.util.Date date)
	{
		return new java.sql.Timestamp(date.getTime());
	}
	

	/*
	 * yyyy-MM-dd hh:mm:ss.ffffff格式的字符串转换成Timestamp
	 */
	public static java.sql.Timestamp String2Timestamp(String str)
	{
		java.sql.Timestamp timeStamp = java.sql.Timestamp.valueOf(str);
		return timeStamp;
	}

	/*
	 * 将指定格式的字符串转换成Timestamp
	 */
	public static java.sql.Timestamp String2Timestamp(String str, String format)
	{
		java.util.Date date = StringTODate(str, format);
		java.sql.Timestamp timeStamp = Date2Timestamp(date);
		return timeStamp;
	}

	/*
	 * 获得当前日期上一天
	 */
	public static Date getYesterday(Date date1)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date1);
		cal.add(Calendar.DATE, -1);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1)
			month = "0" + month;
		String day = String.valueOf(cal.get(Calendar.DATE));
		if (day.length() == 1)
			day = "0" + day;
		return StringTODate(year + "-" + month + "-" + day);
	}

	/*
	 * 在URL后面加一个参数
	 */
	public static String combineUel(String url, String paramName,
			String paramValue)
	{
		if (url != null && !url.equals(""))
		{
			StringBuffer sb = new StringBuffer(url);
			if (url.indexOf("?") > 0)
				sb.append("&");
			else
				sb.append("?");

			sb.append(paramName);
			sb.append("=");
			sb.append(paramValue);

			return sb.toString();
		}

		return "#";
	}


	/*
	 * 判断两个值是否相同
	 */
	public static boolean myEquals(String s1, String s2)
	{
		if (s1 == null)
		{
			if (s2 == null || s2.equals(""))
				return true;
		} else if (s2 == null)
		{
			if (s1.equals(""))
				return true;
		} else if (s1 != null && s2 != null)
		{
			return (s1.trim()).equals((s2.trim()));
		}
		return false;
	}

	/*
	 * 获得当前的日期
	 */
	public static String getNowDay()
	{
		return DateToString(new Date());
	}

	/*
	 * 取得指定月份的最后一天
	 */
	public static String getEndMonthDay(Date date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dateFormat.format(cal.getTime());
	}

	/*
	 * 取得指定年份的最后一天
	 */
	public static String getEndYearDay(Date date)
	{
		return DateToString(date, "yyyy-") + "12-31";
	}

	/*
	 * 取得指定月份的第一天
	 */
	public static String getBeginMonthDay(Date date)
	{
		return DateToString(date, "yyyy-MM") + "-01";
	}

	/*
	 * 取得指定年份的第一天
	 */
	public static String getBeginYearDay(Date date)
	{
		return DateToString(date, "yyyy-") + "01-01";
	}

	/*
	 * 获得周一的日期
	 */
	public static String getMonday(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	// 获得周五的日期
	public static String getFriday(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/*
	 * 获得周日日期
	 */
	public static String getSunday(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/*
	 * 获得季度末日期
	 */
	public static String getEndQuarterDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		if (month >= 1 && month <= 3)
		{
			return year + "-" + "03" + "-" + "31";
		}
		if (month >= 4 && month <= 6)
		{
			return year + "-" + "06" + "-" + "30";
		}
		if (month >= 7 && month <= 9)
		{
			return year + "-" + "09" + "-" + "30";
		}
		if (month >= 10 && month <= 12)
		{
			return year + "-" + "12" + "-" + "31";
		}
		return "";
	}

	/*
	 * 获得季度初日期
	 */
	public static String getBeginQuarterDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		if (month >= 1 && month <= 3)
		{
			return year + "-" + "01" + "-" + "01";
		}
		if (month >= 4 && month <= 6)
		{
			return year + "-" + "04" + "-" + "01";
		}
		if (month >= 7 && month <= 9)
		{
			return year + "-" + "07" + "-" + "01";
		}
		if (month >= 10 && month <= 12)
		{
			return year + "-" + "10" + "-" + "01";
		}
		return "";

	}
	
	 /**
	  * 计算两个日期之间相差的天数
	  * @param nowDate 较小日期
	  * @param expDate 较大日期
	  * @return
	  * @throws Exception
	  */
	 public static int daysBetween(Date nowDate,Date expDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		nowDate = sdf.parse(sdf.format(nowDate));
		expDate = sdf.parse(sdf.format(expDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		long time1 = calendar.getTimeInMillis();
		calendar.setTime(expDate);
		long time2 = calendar.getTimeInMillis();
		long days = (time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(days));
	 }

	/**
	 * 计算两个日期之间相差的月数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonths(Date date1, Date date2)
	{
		int iMonth = 0;
		int flag = 0;
		try
		{
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2))
			{
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return iMonth;
	}

	// 比较两个日期，第一个大于第二个返回TRUE
	public static boolean equalsDate(Date date1, Date date2)
	{
		if (date1.getTime() > date2.getTime())
			return true;
		return false;
	}
	
	//比较两个日期，第一个大于等第二个返回TRUE
	public static boolean equalsAndDate(Date date1,Date date2)
	{
		if(date1.getTime()>=date2.getTime())
			return true;
		return false;
	}

	/**
	 * 计算两个日期相差多少分钟
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMinutes(Date date1, Date date2)
	{		

		long millis = date1.getTime()-date2.getTime();
		return millis / (60 * 1000);
	}
	
	//判断两个日期大小
	public static boolean compareDate(Date date1,Date date2)
	{
		if(date1.getTime()>=date2.getTime())
		{
			return true;
		}
		return false;
	}
	
	//取得多少天之前的日期
	public static Date beforeDay(Date date,int amount)
	{
		amount=-amount;
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.DATE, amount);   
		return cal.getTime();  
	}
	
	//取得多少天之后的日期
	public static Date afterDay(Date date,int amount)
	{
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.DATE, amount);   
		return cal.getTime();  
	}
	
	//取得多少分钟后的时间
	public static Date afterSecond(Date date,int second){
		Calendar cal=new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.SECOND, second);
		return cal.getTime();
	}
	
	//取得多少月之前的日期
	public static Date beforeMonth(Date date,int amount)
	{
		amount=-amount;
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.MONTH, amount);   
		return cal.getTime();  
	}
	//取得多少月之后的日期
	public static Date afterMonth(Date date,int amount)
	{
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.MONTH, amount);   
		return cal.getTime();  
	}
	
	//取得多少年之前的日期
	public static Date beforeYear(Date date,int amount)
	{
		amount=-amount;
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.YEAR, amount);   
		return cal.getTime();  
	}
	//取得多少年之后的日期
	public static Date afterYear(Date date,int amount)
	{
		Calendar cal = new GregorianCalendar();   
		cal.setTime(date);   
		cal.add(GregorianCalendar.YEAR, amount);   
		return cal.getTime();  
	}
	/**获取当前时间前/后 N个月日期**/
	public static List<String> getBeforeLocalDate(int n,String dateStyle){
		SimpleDateFormat sdf = new SimpleDateFormat(dateStyle);
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < n; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH,-i);
			String dtStr = new String(sdf.format(calendar.getTime()));
			list.add(dtStr);
		}
		return list;
	}
	/**获取当前时间前/后 N个月日期(包含本月)**/
	public static List<String> getLocalDate(int n,String dateStyle){
		SimpleDateFormat sdf = new SimpleDateFormat(dateStyle);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH,-i);
			String dtStr = new String(sdf.format(calendar.getTime()));
			list.add(dtStr);
		}
		return list;
	}

	private static Date getLastDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 获取指定格式上个月
	 * @param format
	 * @return
	 */
	public static String getDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getLastDate(date));
	}


}