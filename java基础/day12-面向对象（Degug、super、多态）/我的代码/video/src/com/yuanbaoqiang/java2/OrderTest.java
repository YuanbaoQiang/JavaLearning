/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 16:40
 **/

package com.yuanbaoqiang.java2;

public class OrderTest {
    public static void main(String[] args){
        Order order = new Order();

        order.orderPublic = 1;
        order.orderProtected = 1;
        order.orderDefault = 1;

        order.methodDefault();
        order.methodProtected();
        order.methodPublic();

    }
}
