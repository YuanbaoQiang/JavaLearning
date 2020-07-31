/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 19:49
 **/

package com.yuanbaoqiang.exer3;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.3);
        Circle c2 = new Circle(2.22,"white",2.0);

        System.out.println("颜色是否相等：" + c1.getColor().equals(c2.getColor()));
        System.out.println("半径是否相等：" + c1.equals(c2));

        System.out.println(c1);
        System.out.println(c2);

    }
}
