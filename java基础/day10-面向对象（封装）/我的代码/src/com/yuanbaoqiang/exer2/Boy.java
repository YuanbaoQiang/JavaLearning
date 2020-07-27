/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 19:15
 **/

package com.yuanbaoqiang.exer2;

import java.sql.SQLSyntaxErrorException;

public class Boy {
    private String name;
    private int age;

    public Boy(){

    }

    public Boy(String name) {
        this.name = name;
    }

    public Boy(int age) {
        this.age = age;
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void marry(Girl girl){
        System.out.println("我也想取" + girl.getName());
    }

    public void shout(){
        if(age >= 22){
            System.out.println("你可以合法登记结婚了！");
        }else{
            System.out.println("先多谈谈恋爱~~");
        }
    }

}
