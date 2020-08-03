/**
 * <h3>我的代码</h3>
 * <p>接口的使用</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 12:53
 **/

package com.yuanbaoqiang.java1;

/*
* 接口的使用
* 1. 接口使用interface来定义
* 2. Java中，接口和类是并列的两个结构
* 3. 如何定义接口：定义接口中的成员
*       3.1 JDK7及以前: 只能定义全局常量和抽象方法
*               > 全局常量： public static final的，但是书写时，可以省略不写
*               > 抽象方法： public abstract的
*       3.2 JDK8：除了定义全局变量和抽象方法之外，
* 4. 接口中不能定义构造器！意味着接口不可以被实例化
*
* 5. Java开发中，接口通过让类去实现（implements）的方式来使用
*     如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
*     如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
* 6. Java类可以实现多个接口 --> 弥补了Java单继承性的
*       格式：class AA extends BB implements CC, DD, EE
*
* 7. 接口与接口之间可以多继承
*
* *********************************************************************
* 8. 接口具体的使用，体现多态性
* 9. 接口，实际上可以看作是一种规范
*
*
* 面试题：抽象类和接口有哪些异同？
*
*
* */

public class InterfaceTest {
    public static void main(String[] args) {

    }

}

interface Flyable{
    // 全局常量
    public static final int MAX_SPEED = 7900; // 第一宇宙速度
    int MIN_SPEED = 1; // 省略了 public static final

    // 抽象方法
    public abstract void fly();

    // 省略了public abstract
    void stop();
}


interface Attackable{
    public abstract void attack();
}

class plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}


abstract class Kite implements Flyable{
}


class Bullet extends Object implements Flyable, Attackable, CC{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }


    @Override
    public void attack() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}



interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{

}