/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 09:16
 **/

package com.yuanbaoqiang.java3;

import com.yuanbaoqiang.java2.Order;

public class SubOrder extends Order {
    public void method(){
        orderProtected = 1;
        orderPublic = 2;

        methodProtected();
        methodPublic();


        // 不同包的子类中，不能调用Order类中声明为private和缺省权限的属性、方法
/*        orderDefault = 3;
        orderPrivate = 4;

        methodDefault();
        methodPrivate();*/
    }
}
