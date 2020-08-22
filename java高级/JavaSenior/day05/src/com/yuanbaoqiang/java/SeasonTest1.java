/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 *
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类继承于enum
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-17 07:49
 **/

package com.yuanbaoqiang.java;

import java.util.Arrays;

public class SeasonTest1 {
    public static void main(String[] args){
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.toString());

        System.out.println(Season1.class.getSuperclass());

        // values():
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));

        Thread.State[] values1 = Thread.State.values();
        System.out.println(Arrays.toString(values1));

        //valueOf(String objName)：返回枚举类中对象名是objName的对象
        // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        // Season1 winter = Season1.valueOf("WINTER1");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

        winter.show();
    }
}


interface info1{
    void show();
}


// 自定义枚举类
enum Season1 implements info1{
    // 1. 提供当前枚举类的对象，多个对象之间用"，"隔开，末尾用"；"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋风飒爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };


    // 2. 声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;


    // 3. 私有化类的构造器
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其他诉求 1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 4. 其他诉求 2：提供toString()
/*    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/

/*
    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
*/

}
