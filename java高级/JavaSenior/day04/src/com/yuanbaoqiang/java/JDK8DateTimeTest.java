/**
 * <h3>JavaSenior</h3>
 * <p>JDK 8中日期时间API的测试</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-16 13:08
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class JDK8DateTimeTest {

    @Test
    public void testDate(){

        // 偏移量
        Date date1 = new Date(2020 - 1990,9 -1,8);
        System.out.println(date1); // Fri Oct 08 00:00:00 CST 3920 --> Mon Sep 08 00:00:00 CST 1930
    }

    /*
    * LocalDate、LocalTime、LocalDateTime的使用
    *
    * 说明：
    *   1. LocalDateTime相较于LocalDate、LocalTime，使用频率更高
    *
    *
    *
    * */

    @Test
    public void test1(){
        // now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of()：设置指定的年、月、日、分、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1); // 2020-10-06T13:23:43

        // getXxxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        // 体现不可变性
        // withXxx()：设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        // 不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }


    /*
    * Instant的使用
    * 类似于java.util.Date类
    *
    * */
    @Test
    public void test2(){
        // now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-08-16T06:09:55.247569900Z

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-08-16T14:11:47.292504400+08:00

        // toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // ofEpochMilli()：通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1597558517145l);
        System.out.println(instant1);
    }

    /*
    * DateTimeFormatter：格式化时间或解析日期、时间
    * 类似于SimpleDateFormat
    *
    *
    * */

    @Test
    public void test3(){
        // 方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化：日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        // 接卸：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2020-08-16T14:38:51.8790069");
        System.out.println(parse);

        // 方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        // DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        //格式化
        String str2 = formatter1.format(localDateTime);
        String str3 = formatter2.format(localDateTime);
        // String str4 = formatter3.format(localDateTime);
        System.out.println(str2); // 2020/8/16 下午2:52
        System.out.println(str3); // 2020年8月16日 下午2:52:39
        // System.out.println(str4);

        // 本地化相关的格式。如：ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str4 = formatter4.format(LocalDate.now());
        System.out.println(str4); // 2020年8月16日星期日

        // 重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String str5 = formatter3.format(LocalDateTime.now());
        System.out.println(str5); // 2020-08-16 03:01:33

        // 解析
        TemporalAccessor accessor = formatter3.parse("2020-08-16 03:01:33");
        System.out.println(accessor);
    }

}
