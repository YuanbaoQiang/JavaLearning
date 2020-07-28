/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-28 21:11
 **/

package com.yuanbaoqiang.java;
/*
* 面向对象的特征之二：继承性
*
* 一、继承性的好处
* 1. 减少了代码的冗余，提高了代码的复用性
* 2. 便于代码的扩展
* 3. 为之后的多态性的使用提供了前提
*
* 二、继承性的格式：class A extends B{ }
* A: 子类、派生类、subclass
* B：父类、超类、基类、superclass
*
* 2.1 体现： 一旦子类A继承父类B后，子类A中就获取了父类B中所有的声明的结构：属性、方法
* 特别的，父类中声明为private的属性和方法，子类继承父类以后，仍然认为获取了父类中私有的结构。只有因为封装性的影响，使得子类不能直接调用父类的结构而已。
*
* 2.2 子类继承父类以后，还可以声明自己特有的属性和方法：实现功能的拓展
* 子类和父类的关系，不同于子集和集合的关系。
* extends：延展、扩展
*
* 三、Java中关于继承性的规定
* 1. 一个类可以被多个子类继承
* 2. Java中类的单继承性：一个类只能有一个父类
* 3. 子父类是相对的概念
* 4. 子类直接继承的父类，称为：直接父类以及所有间接父类中声明的属性和方法
*
* 四、
* 1. 如果我们没有显式声明一个类的父类的话，则此类继承于java.lang.Object类
* 2. 所有的Java类（除java.lang.Object类之外）都直接或间接地继承于java.lang.Object类
* 3. 意味着 所有地java.lang.Object类声明地功能
*
*
* */
public class ExtendsTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 1;
        p1.eat();

        Student s1 = new Student();
        s1.eat();
        s1.sleep();
    }

}
