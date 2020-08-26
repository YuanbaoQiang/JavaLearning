/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * Person需要满足以下的要求，方可序列化
 * 1. 需要实现接口：Serializable
 * 2. 需要当前类提供一个全局常量：serialVersionUID
 * 3. 除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *    也必须是序列化的。（默认情况下，基本数据类型也是可序列化的）
 *
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 07:44
 **/

package com.yuanbaoqiang.java;

import java.io.Serializable;

public class Person implements Serializable {

    public static final long serialVersionUID = 42754678642L;

    private String name;
    private int age;
    private Account acct; // Account类必须实现Serializable接口

    public Person() {
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAcct() {
        return acct;
    }

    public void setAcct(Account acct) {
        this.acct = acct;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}


class Account implements Serializable{
    public static final long serialVersionUID = 427546742L;

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
