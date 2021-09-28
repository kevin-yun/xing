package com.kevin.xing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String TIME_FORMAT = "HH:mm:ss";

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化日期
     *
     * @return yyyy-MM-dd
     */
    public static String getFormatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 格式化日期
     *
     * @return yyyy-MM-dd
     */
    public static String getFormatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(date);
    }

    /**
     * 格式化时间
     *
     * @return HH:mm:ss
     */
    public static String getFormatTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
        return format.format(date);
    }

    /**
     * 格式化日期及时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getFormatDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        return format.format(date);
    }

    /**
     * 日期时间字符串转LocalDateTime
     */
    public static LocalDateTime dateStrToLocalDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER);
    }

    /**
     * 日期字符串转LocalDate
     */
    public static LocalDate dateStrToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /**
     * 日期字符串 转 Date
     */
    public static Date dateStrToDate(String dateStr) {
        return Date.from(LocalDate.parse(dateStr, DATE_FORMATTER).atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    /**
     * 日期时间字符串 转 Date
     */
    public static Date dateTimeStrToDate(String dateStr) {
        return Date.from(LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER).atZone(ZoneId.systemDefault()).toInstant());

    }

    /**
     * LocalDate 转 Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime 转 Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date 转 LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date 转 LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 计算两个日期时间差
     *
     * @param start yyyy-MM-dd HH:mm:ss
     * @param end yyyy-MM-dd HH:mm:ss
     */
    public static long dateDifference(String start, String end) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            Date startTime = format.parse(start);
            Date endTime = format.parse(end);
            return endTime.getTime() - startTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param start 2018-03-01 12:00:00
     * @param end   2018-03-12 12:00:00
     */
    public static int calculationDays(String start, String end) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date fromDate = simpleFormat.parse(start);
            Date toDate = simpleFormat.parse(end);
            long from = fromDate.getTime();
            long to = toDate.getTime();
            return (int) ((to - from) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 计算小时差
     */
    public static int calculationHours(String start, String end) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date fromDate = simpleFormat.parse(start);
            Date toDate = simpleFormat.parse(end);
            long from = fromDate.getTime();
            long to = toDate.getTime();
            return (int) ((to - from) / (1000 * 60 * 60));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 计算分钟差
     */
    public static int calculationMinutes(String start, String end) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date fromDate = simpleFormat.parse(start);
            Date toDate = simpleFormat.parse(end);
            long from = fromDate.getTime();
            long to = toDate.getTime();
            return (int) ((to - from) / (1000 * 60));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 计算两个日期之间的秒数差
     */
    public static int calculationSecond(String start, String end) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date fromDate = simpleFormat.parse(start);
            Date toDate = simpleFormat.parse(end);
            long from = fromDate.getTime();
            long to = toDate.getTime();
            return (int) ((to - from) / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param field  单位(年月日时分秒)
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS)
            return period.getYears();
        if (field == ChronoUnit.MONTHS)
            return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }


    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * 例子: LocalDate today = LocalDate.now();
     *      LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }


    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }


    /**
     * 根据field不同加减不同值
     * @param field  Calendar.YEAR
     * @param number 1000/-1000
     */
    public static Date calculationDate(Date date, int field, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, number);
        return calendar.getTime();
    }

    /**
     * 比较两个日期先后
     */
    public static boolean compareDate(Date firstDate, Date secondDate) {
        return firstDate.getTime() < secondDate.getTime();
    }


    /**
     * 比较第一个日期是否大于第二个日期
     * @param firstDate 第一个日期
     * @param secondDate 第二个日期
     * @return true-大于;false-不大于
     */
    public boolean localDateIsBefore(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate);
    }
}
