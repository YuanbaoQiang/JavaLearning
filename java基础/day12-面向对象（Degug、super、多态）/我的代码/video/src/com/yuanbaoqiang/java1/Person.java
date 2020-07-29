/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 14:58
 **/

package com.yuanbaoqiang.java1;

public class Person {
    String name;
    int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void walk(int distance){
        System.out.println("走路，走的距离是：" + distance + "公里");
    }

    private void show(){
        System.out.println("这是private的父类方法");
    }


}
