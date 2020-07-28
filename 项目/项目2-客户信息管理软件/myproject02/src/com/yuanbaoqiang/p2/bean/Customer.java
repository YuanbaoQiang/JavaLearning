/**
 * <h3>项目2-客户信息管理软件</h3>
 * <p>Customer为实体对象，用来封装客户信息</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-28 11:43
 **/

package com.yuanbaoqiang.p2.bean;

public class Customer {
    private String name; // 客户姓名
    private char gender; // 性别
    private int age; // 性别
    private String phone; // 电话号码
    private String email; // 电子邮箱



/****************************构造器********************************/
    public Customer(){

    }

    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }



/************************Set And Get******************************/
    // name
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    // gender
    public void setGender(char gender){
        this.gender = gender;
    }

    public char getGender(){
        return gender;
    }

    // age
    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    // phone
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    // email
    public void setEmail(String email){

    }

    public String getEmail(){
        return email;
    }

}
