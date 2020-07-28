/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-28 21:08
 **/

package com.yuanbaoqiang.java;

public class Student extends Person{
/*    String name;
    int age;*/
    String major;

    public Student(){

    }

    public Student(String name, int age, String major){
        this.name = name;
        this.age = age;
        this.major = major;
    }

/*    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }*/

    public void study(){
        System.out.println("学习");
    }


    public void show(){
        System.out.println();
    }

}
