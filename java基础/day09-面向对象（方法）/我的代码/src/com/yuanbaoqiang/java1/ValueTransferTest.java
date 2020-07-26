/**
 * <h3>我的代码</h3>
 * <p>传参</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 12:45
 **/

package com.yuanbaoqiang.java1;
/*
* 关于变量的赋值
*
* 如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
* 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。
*
* */
public class ValueTransferTest {
    public static void main(String[] args){
        System.out.println("******************基本数据类型******************");
        int m = 10;
        int n = 20;

        System.out.println("m = " + m + ", n = " + n);

        n = 20;
        System.out.println("m = " + m + ", n = " + n);
        System.out.println("******************引用数据类型******************");

        Order o1 = new Order();
        o1.orderID = 1001;

        Order o2 = o1; // 赋值以后o1 和 o2的地址值相同，都指向了堆空间中同一个对象实体。
        System.out.println("o1.orderID = " + o1.orderID + " ,o2.orderID = " + o2.orderID);

        o2.orderID = 1002;
        System.out.println("o1.orderID = " + o1.orderID + " ,o2.orderID = " + o2.orderID);

    }
}


class Order{
    int orderID;
}