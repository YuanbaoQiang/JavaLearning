/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 15:06
 **/

package com.yuanbaoqiang.exer1;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1 = new TriAngle();
        System.out.println("base: " + t1.getBase() + ", height: " + t1.getHeight());

        TriAngle t2 = new TriAngle(10.2,20.4);
        System.out.println("base: " + t2.getBase() + ", height: " + t2.getHeight());
    }
}
