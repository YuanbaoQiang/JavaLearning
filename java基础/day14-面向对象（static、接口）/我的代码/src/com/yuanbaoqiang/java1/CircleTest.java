/**
 * <h3>我的代码</h3>
 * <p>static关键字的应用</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-01 11:31
 **/

package com.yuanbaoqiang.java1;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(3.5);
        Circle c2 = new Circle(2.5);

        System.out.println("c1的id：" + c1.getId());
        System.out.println("c2的id：" + c2.getId());


        System.out.println("创建的圆的个数为：" + Circle.getTotal());
    }
}

class Circle{
    private double radius;
    private int id; // 自动赋值

    private static int total; // 记录创建的圆的个数
    private static int init = 1001; // static声明的属性被所有对象共享

    public Circle(){
        id = init++;
        total++;
    }

    public Circle(double radius){
        this();
        // id = init++;
        // total++;
        this.radius = radius;
    }

    public double findArea(){
        return 3.14 * radius * radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }
}
