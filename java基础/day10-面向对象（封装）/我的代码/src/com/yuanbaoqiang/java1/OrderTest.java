/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 13:47
 **/

package com.yuanbaoqiang.java1;

import com.yuanbaoqiang.java.Order;

public class OrderTest {
    public static void main(String[] args) {
        com.yuanbaoqiang.java.Order order = new Order();

        order.orderPublic = 2;

        // 出了Order类所属的包之后，私有的结构、缺省声明的结构就不可以调用了
        //order.orderDefault = 1;

        // 出了Order类之后，私有的结构就不可以调用了
        // order.orderPrivate = 3;

        order.methodPublic();

        // 出了Order类所属的包之后，私有的结构、缺省声明的结构就不可以调用了
        // order.methodDefault();

        // 出了Order类之后，私有的结构就不可以调用了
        // order.methodPrivate();
    }
}
