package com.gpdata.toosimple.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 	按照给定的格式化字符串格式化日期
	 */
	public static String formatDate(Date date, String pattern) {
		String result = StringUtils.EMPTY;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			result = sdf.format(date);
		} catch (Exception e) {
			logger.error("Exception: {}", e.getMessage());
		}
		return result;
	}

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @return dataTime timestamp
     */
    public static Timestamp parseToTimestamp(String date, String pattern) {
        Timestamp dateTime = null;
        java.text.DateFormat df2 = new SimpleDateFormat(pattern);
        try {
            Date date2 = df2.parse(date);
            dateTime = new Timestamp(date2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /***
     * 将timeType转换后的浮点型的值
     */
    public static long parseToLong(String date, String pattern) {
        long time = 0L;
	    try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            ParsePosition pos = new ParsePosition(0);
            time = formatter.parse(date, pos).getTime();
        } catch (Exception e) {
            logger.error("Exception: {}", e.getMessage());
        }
        return time;
    }

	//按照给定的格式化字符串解析日期
	public static Date parseToDate(String dateStr, String pattern) {
		Date date = new Date(0L);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			logger.error("Exception:{}", e);
		}
		return date;
	}


    public static Long getStartMonth() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.MONTH, 0);
        todayStart.set(Calendar.DAY_OF_MONTH, 1);// 当月第一天
        todayStart.set(Calendar.HOUR_OF_DAY, 0); // HOUR是 整点时间 HOUR_OF_DAY是当天0点
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    public static Long getStartWeek() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.DAY_OF_WEEK, 2);// 当月第一天
        todayStart.set(Calendar.HOUR_OF_DAY, 0); // HOUR是 整点时间 HOUR_OF_DAY是当天0点
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    public static Long getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0); // HOUR是 整点时间 HOUR_OF_DAY是当天0点
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    public static Long getStartHourTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0); // HOUR是 整点时间 HOUR_OF_DAY是当天0点
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }

    /**
     * 获取当年的第一天
     *
     * @return
     */
    public static long getFirstDayOnYear() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear).getTime();
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
	    return calendar.getTime();
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);

	    return calendar.getTime();
    }

	/**
	 * 获取年份
	 *
	 * @param date
	 *
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取月份
	 *
	 * @param date
	 *
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取星期
	 *
	 * @param date
	 *
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek - 1;
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		return dayOfWeek;
	}

	/**
	 * 获取日期(多少号)
	 *
	 * @param date
	 *
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

    public static Long getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime().getTime();
    }

    public static Long getNowTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.get(Calendar.HOUR_OF_DAY); // HOUR是 整点时间 HOUR_OF_DAY是当天0点
        todayStart.get(Calendar.MINUTE);
        todayStart.get(Calendar.SECOND);
        todayStart.get(Calendar.MILLISECOND);
        return todayStart.getTime().getTime();
    }

    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    public static List<String> countDay(long fTime, long lTime) {
        // fTime = 1438498591;
        // lTime = 1442419199;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = format.parse(format.format(fTime * 1000));
            Date dEnd = format.parse(format.format(lTime * 1000));
            List<Date> listDate = getDatesBetweenTwoDate(dBegin, dEnd);

            List<String> listdate = new ArrayList<String>();
            for (Date aListDate : listDate) {

                listdate.add(format.format(aListDate).replaceAll("-", ""));
            }
            return listdate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    public static List<String> countWeek(long fTime, long lTime) {
        // fTime = 1438498591;
        // lTime = 1442419199;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = format.parse(format.format(fTime * 1000));
            Date dEnd = format.parse(format.format(lTime * 1000));
            List<Date> listDate = getDatesBetweenTwoDate(dBegin, dEnd);

            Set<String> listdate = new TreeSet<>();
            listDate.forEach(dt -> {
                MyDate myDate = getWeek(formatDate(dt, "yyyyMMdd"), "yyyyMMdd");
                listdate.add(myDate.getYear()
                        + "" + (myDate.getMonth() > 9 ? myDate.getMonth() : "0" + myDate.getMonth())
                        + "" + (myDate.getWeekInMonth() > 9 ? myDate.getWeekInMonth() : "0" + myDate.getWeekInMonth()));
            });
            return new ArrayList<>(listdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    /**
     * 根据日期字符串判断当月第几周
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static MyDate getWeek(String str, String format) {
        try {
            MyDate MyDate = new MyDate();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = sdf.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            //第几周
            MyDate.setDayInWeek(calendar.get(Calendar.DAY_OF_WEEK));
            MyDate.setDayInWeekInMonth(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
            MyDate.setDayInMonth(calendar.get(Calendar.DAY_OF_MONTH));
            MyDate.setDayInYear(calendar.get(Calendar.DAY_OF_YEAR));
            MyDate.setWeekInMonth(calendar.get(Calendar.WEEK_OF_MONTH));
            MyDate.setWeekInYear(calendar.get(Calendar.WEEK_OF_YEAR));
            MyDate.setYear(calendar.get(Calendar.YEAR));
            MyDate.setMonth(calendar.get(Calendar.MONTH) + 1);
            return MyDate;
        } catch (Exception e) {
            logger.error("Exception:{}", e);
        }
        return null;
    }

	/**
	 * 在当前时间的基础上，加上或减去指定的天数
	 * @param day
	 * @return
	 */
	public static Date getSomeDay(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

    public static void main(String[] args) {
        long firstDayOnYear = getFirstDayOnYear();
	    Date date = new Date(firstDayOnYear);
	    System.out.println(date);
    }


	public static class MyDate {

	    private Integer dayInWeek;
	    private Integer dayInWeekInMonth;
	    private Integer dayInMonth;
	    private Integer dayInYear;
	    private Integer weekInMonth;
	    private Integer weekInYear;
	    private Integer year;
	    private Integer month;

	    public Integer getDayInWeek() {
	        return dayInWeek;
	    }

	    public void setDayInWeek(Integer dayInWeek) {
	        this.dayInWeek = dayInWeek;
	    }

	    public Integer getDayInMonth() {
	        return dayInMonth;
	    }

	    public void setDayInMonth(Integer dayInMonth) {
	        this.dayInMonth = dayInMonth;
	    }

	    public Integer getDayInYear() {
	        return dayInYear;
	    }

	    public void setDayInYear(Integer dayInYear) {
	        this.dayInYear = dayInYear;
	    }

	    public Integer getWeekInMonth() {
	        return weekInMonth;
	    }

	    public void setWeekInMonth(Integer weekInMonth) {
	        this.weekInMonth = weekInMonth;
	    }

	    public Integer getWeekInYear() {
	        return weekInYear;
	    }

	    public void setWeekInYear(Integer weekInYear) {
	        this.weekInYear = weekInYear;
	    }

	    public Integer getYear() {
	        return year;
	    }

	    public void setYear(Integer year) {
	        this.year = year;
	    }

	    public Integer getMonth() {
	        return month;
	    }

	    public void setMonth(Integer month) {
	        this.month = month;
	    }

	    public Integer getDayInWeekInMonth() {
	        return dayInWeekInMonth;
	    }

	    public void setDayInWeekInMonth(Integer dayInWeekInMonth) {
	        this.dayInWeekInMonth = dayInWeekInMonth;
	    }
	}
}
