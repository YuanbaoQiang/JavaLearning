/**
 * <h3>JavaSenior</h3>
 * <p>JDK 8之前日期和时间的API测试</p>
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-15 17:56
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.util.Date;

public class DateTimeTest {

    /*
    * java.util.Date类
    *       |---java.sql.Date类
    *
    * 1. 两个构造器的使用
    *       >构造器一：Date()：创建一个对应当前时间的Date对象
    *       >构造器二:创建指定毫秒数的Date对象
    *
    * 2. 两个方法的使用
    *       >toString():显示当前的 年、月、日、分、秒
    *       >getTime(): 获取当前Date对应的时间戳
    *
    * 3. java.sql.Date对应着数据库中的日期类型数据变量
    *       >如何实例化
    *       >如何将java.util.Date 对象转成java.sql.Date对象
    *
    * */
    @Test
    public void test2(){
        // 构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1); // Sat Aug 15 18:06:12 CST 2020
        System.out.println(date1.getTime()); // 1597486074545

        // 构造器二:创建指定毫秒数的Date对象
        Date date2 = new Date(1597486074545L);
        System.out.println(date2);

        // 创建java.sql.Date对象
        java.sql.Date date3= new java.sql.Date(1597486074545L);
        System.out.println(date3); // 2020-08-15

        java.sql.Date date4= new java.sql.Date(new Date().getTime());
        System.out.println(date4);


    }


    // 1. System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        // 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        // 时间戳
        System.out.println(time);
    }

}
