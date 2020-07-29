/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 13:10
 **/

package com.yuanbaoqiang.exer1;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        // c.setRadius();
        // c.setLength(10);
        double a = c.findArea();
        System.out.println("该圆柱的底面积为：" + a);

        double v = c.findVolume();

        System.out.println("该圆柱的体积为：" + v);
    }

}
