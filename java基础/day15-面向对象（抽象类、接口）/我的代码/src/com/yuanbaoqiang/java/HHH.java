/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-03 08:33
 **/

package com.yuanbaoqiang.java;

public class HHH {
    public static void main(String[] args) {
        School.method();
    }

}


abstract class School{
    public static void method(){

    }

    // 静态方法不含方法体
    // 正确的写法
    public abstract void show();

    // 错误的写法
/*    public abstract void display(){
        // 方法体
    }*/

}
