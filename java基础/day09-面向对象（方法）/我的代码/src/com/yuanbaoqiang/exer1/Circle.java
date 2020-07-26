/**
 * <h3>我的代码</h3>
 * <p>圆面积</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 14:46
 **/

package com.yuanbaoqiang.exer1;
/*
* 定义一个Circle类，包含一个double型的radius属性代表圆的半径
* 一个findArea()方法返回圆的面积
* */
public class Circle {
    double radius; // 圆半径

    // 求圆的面积
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
