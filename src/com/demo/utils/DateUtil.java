package com.demo.utils;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 严顺宽
 */
@SuppressLint("SimpleDateFormat")
public class DateUtil {

	public static void main(String[] args) {
		System.out.println(getFrontBackStrDate("2016-03-30", -1));

		// 定义输出日期格式
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//
		// Date currentDate = new Date();
		//
		// List<Date> list = getNextWeek(currentDate);
		// for (Date date : list) {
		// System.out.println(sdf.format(date));
		// }

		// Map<String, Week> result = new LinkedHashMap<String, Week>();
		// result = getNextSevenDay();
		// for (String s : result.keySet()) {
		// System.out.println(s + ":" + result.get(s));
		// }

		// System.out.println(getDateAfter(new Date(), 365));

	}

	/**
	 * 
	 * 方法描述：取得当前日期的上月或下月日期 ,amount=-1为上月日期，amount=1为下月日期；创建人：jya
	 * 
	 * @param s_DateStr
	 * @return
	 * @throws Exception
	 */
	public static String getFrontBackStrDate(String strDate, int amount) {
		if (null == strDate) {
			return null;
		}
		try {

			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(fmt.parse(strDate));
			c.add(Calendar.MONTH, amount);
			return fmt.format(c.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 得到包括今天在内的后7天的日期及星期
	 * 
	 * @return <日期xxxx-xx-xx，星期几>
	 */
	public static Map<String, Week> getNextSevenDay() {
		Map<String, Week> result = new LinkedHashMap<String, Week>();
		Date today = new Date();
		for (int i = 0; i < 7; i++) {
			String date = getDateAfter(today, i);
			Week week = getWeekByDate(date);
			result.put(date, week);
		}
		return result;
	}

	/**
	 * 得到输入日期的下一周时间，从周日到周六
	 * 
	 * @param mdate
	 * @return
	 */

	public static List<Date> getNextWeek(Date mdate) {
		@SuppressWarnings("deprecation")
		int b = mdate.getDay();
		Date fdate;
		List<Date> list = new ArrayList<Date>();
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 7; a < 14; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a - 7, fdate);
		}
		return list;
	}

	public static String getToday() {
		return getFormattedDate(new Date());
	}

	public static String getToday(String form) {
		return getFormattedDate(new Date(), form);
	}

	/**
	 * 根据日期得到是周几
	 * 
	 * @param date
	 *            日期 ，格式形如xxxx-xx-xx
	 * @return
	 */
	public static Week getWeekByDate(String date) {
		Calendar calendar = Calendar.getInstance();// 获得一个日历
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
		calendar.set(year, month - 1, day);// 设置当前时间,月份是从0月开始计算
		int number = calendar.get(Calendar.DAY_OF_WEEK);// 星期表示1-7，是从星期日开始，
		return Week.getWeek(number - 1);
	}

	/**
	 * 得到某天后几天的日期
	 * 
	 * @param date
	 *            日期
	 * @param gap
	 *            日期差
	 * @return 日期 ，格式形如xxxx-xx-xx
	 */
	public static String getDateAfter(Date date, int gap) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + gap);
		return getFormattedDate(now.getTime());
	}

	/**
	 * 根据当前选中的星期几，返回日期
	 * 
	 * @param day
	 *            星期的英文
	 * @return 日期 ，格式形如xxxx-xx-xx
	 */
	public static String getDateByWeekDay(String day) {
		Date date = new Date();
		String today = getFormattedDate(date);
		Week todayWeek = getWeekByDate(today);
		int todayNum = Week.getNum(todayWeek);
		int chosenNum = getNumByDayEn(day);
		int gap = (6 - todayNum) + (chosenNum - 0) + 1;

		return getDateAfter(date, gap);
	}

	/**
	 * 根据英文得到周几对应的数字
	 * 
	 * @param day
	 *            星期的英文
	 * @return 0-6，周日为0
	 */
	public static int getNumByDayEn(String day) {
		switch (day) {
		case "Sunday":
			return 0;
		case "Monday":
			return 1;
		case "Tuesday":
			return 2;
		case "Wednesday":
			return 3;
		case "Thursday":
			return 4;
		case "Friday":
			return 5;
		case "Saturday":
			return 6;
		default:
			System.err.println("日期转换错误");
			return -1;
		}
	}

	/**
	 * 根据日期获得所在周的日期 ，以周日为一周的第一天
	 * 
	 * @param mdate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<Date> getCurrentWeek(Date mdate) {
		int b = mdate.getDay();
		Date fdate;
		List<Date> list = new ArrayList<Date>();
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 0; a < 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a, fdate);
		}
		return list;
	}

	/**
	 * 判断两个日期是否在同一周，以周日为一周的开始
	 * 
	 * @param date1
	 *            xxxx-xx-xx
	 * @param date2
	 *            xxxx-xx-xx
	 * @return
	 */
	public static boolean isInSameWeek(String date1, String date2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(d1);
		cal2.setTime(d2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		// subYear==0,说明是同一年
		if (subYear == 0) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		// 例子:cal1是"2005-1-1"，cal2是"2004-12-25"
		// java对"2004-12-25"处理成第52周
		// "2004-12-26"它处理成了第1周，和"2005-1-1"相同了
		// 大家可以查一下自己的日历
		// 处理的比较好
		// 说明:java的一月用"0"标识，那么12月用"11"
		else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		// 例子:cal1是"2004-12-31"，cal2是"2005-1-1"
		else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;

		}
		return false;
	}

	/**
	 * 规范日期格式
	 * 
	 * @param date
	 *            日期
	 * @return 返回XXXX-XX-XX的形式
	 */
	public static String getFormattedDate(Date date) {
		return getFormattedDate(date, "yyyy-MM-dd");
	}

	/**
	 * 规范日期格式
	 * 
	 * @param date
	 *            日期
	 * @param form
	 *            格式
	 * @return
	 */
	public static String getFormattedDate(Date date, String form) {
		SimpleDateFormat sdf = new SimpleDateFormat(form);
		return sdf.format(date);
	}

	/**
	 * 将字符串日期转为Date类型
	 * 
	 * @param date
	 *            xxxx-xx-xx格式的日期
	 * @return
	 */
	public static Date getDate(String date) {
		return getDate(date, "yyyy-MM-dd");
	}

	/**
	 * 将字符串日期转为Date类型
	 * 
	 * @param date
	 *            给定参数格式的日期
	 * @param form
	 *            日期格式
	 * @return
	 */
	public static Date getDate(String date, String form) {
		SimpleDateFormat sdf = new SimpleDateFormat(form);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
