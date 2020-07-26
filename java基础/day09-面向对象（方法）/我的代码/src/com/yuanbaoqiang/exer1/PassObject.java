/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 14:49
 **/

package com.yuanbaoqiang.exer1;

/*
* 定义一个PassObject，在类中定义一个方法printArea(), 该方法的定义如下：public void printAreas(Circle c, int time)
* 在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。
* 例如：times为5，则输出1，2，3，4，5，以及对应的圆面积
*
* */
public class PassObject {

    public static void main(String[] args){

        PassObject test = new PassObject();
        Circle c = new Circle();
        test.printAreas(c,5);
        System.out.println("now radius is " + c.radius);

    }



    public void printAreas(Circle c, int time){
        System.out.println("Radius\t\tArea");

        // 设置圆的半径
        for(int i = 1; i <= time; i++){
            c.radius = i;
            System.out.println(c.radius + "\t\t\t" + c.findArea());
        }
        c.radius = time + 1;
    }
}
