/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 15:50
 **/

package com.yuanbaoqiang.java1;

/*
Object类中toString()的使用

1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
2. Object类中toString()的定义：

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
3. 像String、Date、File、包装类等都重写了Object类中toString()方法
    使得在调用对象的toString()时，返回"实体内容"信息

4. 自定义类也可以去重写toString()方法，当调用此方法时，返回对象的"实体内容"

 */

import java.util.Date;

public class ToStringTest {
    public static void main(String[] args) {
        Customer cust1 = new Customer();
        System.out.println(cust1.toString());
        System.out.println(cust1);

        Date date = new Date();
        System.out.println(date.toString());

    }
}


class Customer{

}
