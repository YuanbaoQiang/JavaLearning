/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 13:05
 **/

package com.yuanbaoqiang.exer1;

public class Circle {
    private double radius; // 圆半径

    public Circle(){
        radius = 1;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double findArea(){
        return Math.PI * radius * radius;
    }


}
