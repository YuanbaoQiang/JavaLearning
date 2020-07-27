/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 13:38
 **/

package com.yuanbaoqiang.java;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderPublic = 2;
        // 出了Order类之后，私有的结构就不可以调用了
        // order.orderPrivate = 3;


        order.methodDefault();
        order.methodPublic();
        // 出了Order类之后，私有的结构就不可以调用了
        // order.methodPrivate();

    }
}

