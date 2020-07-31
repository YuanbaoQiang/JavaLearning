package com.yuanbaoqiang.java;

import java.util.Objects;

/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 15:10
 **/

public class Man extends Person {
    boolean isSmoking;
    int id = 1002;

    public boolean isSmoking() {
        return isSmoking;
    }

    public void earnMoney(){
        System.out.println("男人负责挣钱养家");
    }

    public void eat(){
        System.out.println("男人多吃肉，长肌肉");
    }

    public void walk(){
        System.out.println("男人霸气的走路");
    }


}
