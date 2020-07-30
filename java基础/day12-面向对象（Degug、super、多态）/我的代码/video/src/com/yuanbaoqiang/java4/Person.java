/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 09:27
 **/

package com.yuanbaoqiang.java4;

public class Person {

    String name;
    int age;
    int id = 320481; // 身份证号

    public Person(){
        System.out.println("我无处不在");

    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name,int age){

    }

    public void eat(){
        System.out.println("人：吃饭");
    }

    public void walk(){
        System.out.println("人：走路");
    }
}
