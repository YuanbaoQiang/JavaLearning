/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-01 18:33
 **/

package com.yuanbaoqiang.java3;

/*
* final:最终的
* 1. final可以修饰的结构：类、方法、变量
*
* 2. final用来修饰一个类: 此类不能被其他类继承
*          比如：String类、System类、StringBuffer类
* 3. final用来修饰方法：表明此方法不可以被重写
*           比如：Object类中getclass()；
*
* 4. final用来修饰变量：此时的"变量"就称为是一个常量
*       4.1 final修饰属性：可以考虑值得位置有：显式初始化、代码块中初始化、构造器中初始化
*       4.2 final修饰局部变量：
*               尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参
*               一旦赋值以后，就只能再方法体内使用此形参，但不能进行重新赋值。
*
* static final 用来修饰属性：全局常量
*
* */

public class FinalTest {
    final int WIDTH = 0;
    final int LEFT;
    final int RIGHT;
    // final int DOWN;

    {
        LEFT = 1;
    }

    public FinalTest(){
        RIGHT = 20;
    }

    public FinalTest(int n){
        this();
    }

    public void show(){
        final int NUM = 10;
        // NUM++;
    }


    public void show(final int num){
        System.out.println(num);
    }



}

final class FinalA{

}
