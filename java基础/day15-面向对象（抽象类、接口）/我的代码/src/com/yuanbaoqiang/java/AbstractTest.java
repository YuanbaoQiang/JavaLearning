/**
 * <h3>我的代码</h3>
 * <p>abstract关键字的使用</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 07:47
 **/

package com.yuanbaoqiang.java;


/*
* abstract关键字的使用
* 1. abstract：抽象的
* 2. abstract可以用来修饰的结构：类、方法
* 3. abstract修饰类：抽象类
*       > 此类不能实例化（目的）
*       > 抽象类中一定有构造器，便于子类对象实例化时调用（涉及：子类对象实例化的全过程）
*
*
* 4. abstract修饰方法：抽象方法
*       > 抽象方法只有方法的声明，没有方法体
*       > 包含抽象方法的类一定是抽象类。反之，抽象类中可以没有抽象方法的。
*       > 若子类重写了父类中的所有抽象方法后，此类方法可实例化
*         若子类没有重写了父类中的所有抽象方法后，则子类也是一个抽象类，需要使用abstract修饰
 * */

public class AbstractTest {
    public static void main(String[] args) {

        // 一旦Person类抽象，就不可以实例化
        //Person p1 = new Person();
        //p1.eat();
    }
}

abstract class Creature{
    public abstract void breath();
}


abstract class Person extends Creature{
    String name;
    int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 不是抽象方法
/*    public void eat(){

    }*/

    // 抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }

    @Override
    public void breath() {
        System.out.println("学生应该呼吸新鲜的没有雾霾的空气");
    }
}

class Student extends Person{


    public Student(){

    }

    public Student(String name, int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("学生多吃有营养的食物");
    }

}
