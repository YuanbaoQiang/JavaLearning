/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 13:13
 **/

package com.yuanbaoqiang.exer1;

public class Circle extends GeometricObject{
    private double radius;

    public Circle(double radius,String color, double weight){
        super(color,weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double findArea() {
        return 3.14 * radius * radius;
    }
}
