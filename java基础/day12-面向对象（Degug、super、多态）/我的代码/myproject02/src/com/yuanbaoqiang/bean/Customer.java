/**
 * <h3>我的代码</h3>
 * <p>Customer为实体对象，用来封装客户信息 </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 08:23
 **/

package com.yuanbaoqiang.bean;

public class Customer {
    private String name; // 客户姓名
    private char gender; // 性别
    private int age; // 年龄
    private String phone; // 电话号码
    private String email; // 电子邮箱

    /**********************构造器************************/
    public Customer(){

    }

    public Customer(String name, char gender, int age, String phone, String email){

    }

    /**********************Set And Get************************/
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
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

}
