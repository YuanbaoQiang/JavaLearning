/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 08:45
 **/

package com.yuanbaoqiang.java;

/*
* 抽象类的匿名子类
*
*
*
* */


import javax.swing.*;

public class PersonTest {

    public static void main(String[] args) {
        method(new Student());

        Student s = new Student();
        method1(s); // 非匿名的类 非匿名的对象

        method1(new Student()); // 非匿名的类 匿名的对象

        // 创建了一个匿名子类的对象：p
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("吃东西");
            }
        };

        method1(p);
        System.out.println("********************************");
        // 创建匿名子类的匿名对象
        method1(new Person() {
            @Override
            public void eat() {
                System.out.println("走路");
            }
        });


    }


    public static  void method1(Person p){
        p.eat();
        p.breath();
    }

    public static void method(Student s){

    }

}
