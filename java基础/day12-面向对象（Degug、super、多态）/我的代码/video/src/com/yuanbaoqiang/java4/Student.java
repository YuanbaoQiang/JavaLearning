/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 09:27
 **/

package com.yuanbaoqiang.java4;

public class Student extends Person{
    String major;
    int id = 1510310118; // 学号

    public Student(){

    }

    public Student(String major){
        this.major = major;
    }

    public Student(String name, int age, String major){
        super(name,age);
        this.major = major;
    }



    @Override
    public void eat() {
        System.out.println("学生：多吃有营养的事物");

    }

    public void study(){
        System.out.println("学生：学习知识");
        eat();
        super.eat();
    }

    public void show(){
        System.out.println("name = " + this.name + ", age = " + super.age);
        System.out.println("id = " + id);
        System.out.println("id = " + super.id);
    }



}
