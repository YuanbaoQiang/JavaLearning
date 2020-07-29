/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 14:59
 **/

package com.yuanbaoqiang.java1;

public class Student extends Person{

    String major;

    public Student(){
    }

    public Student(String major){
        this.major = major;
    }

    public void study(){
        System.out.println("学习，专业是：" + major);
    }

    // 对父类中的eat()重写
    public void eat(){
        System.out.println("学生多吃有营养的食物");
    }


    public void show(){
        System.out.println("这是public的子类方法");
    }

}
