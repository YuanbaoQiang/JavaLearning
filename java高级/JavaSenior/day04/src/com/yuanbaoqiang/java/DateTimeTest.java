/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * jdk 8之前日期时间的API测试
 * 1. System类中currentTimeMillis()；
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-16 09:34
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTimeTest {

    /*
    * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    *
    * 1. 两个操作：
    * 1.1 格式化：日期 --> 字符串
    * 1.2 解析：格式化的逆过程，字符串 --> 日期
    *
    * 2. SimpleDateFormat的实例化
    *
    * */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化：日期 --> 字符串
        Date date = new Date();
        System.out.println(date);


        String format = sdf.format(date);
        System.out.println(format);

        // 解析：格式化的逆过程，字符串 --> 日期
        String str = "2020/12/16 上午10:02";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //**************按照指定的方式格式化******************
        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        // 解析: 要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)
        // 否则抛异常
        Date date2 = sdf1.parse("2020-08-16 10:11:27");
        System.out.println(date2);
    }

    /*
    * 练习一：字符串"2020-09-08"转换城java.sql.Date
    * */

    @Test
    public void TestExer() throws ParseException {
        String birth = "2020-08-29";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        // System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    /*
    * Calendar日历类的使用
    *
    * */

    @Test
    public void Calendar(){
        // 1. 实例化
        // 方式一：创建其子类的对象（GregorizanCalendar）的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        // 2. 常用方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // getTime() : 日历类 --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime(): Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }



}
