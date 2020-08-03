/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 19:47
 **/

package com.yuanbaoqiang.java2;
/*
* 类的内部类成员之五： 内部类
* 1. Java中允许将一个类A声明在另一个类B中。则类A就是内部类，类B就是外部类
* 2. 内部类的分类： 成员内部类 vs 局部内部类（方法内，代码块内，构造器内）
* 3. 成员内部类：
*           一方面，作为外部类的成员：
*               > 调用外部类的结构
*               > 可以被static修饰
*               > 可以被四种不同的权限修饰
*
*           另一方面，作为一个类：
*               > 类内可以定义属性、方法、构造器等
*               > 可以被final修饰，表示此类不能被继承，言外之意，不适用final就可以被继承
*               > 可以被abstract修饰
* 4. 关注如下的3个问题：
*       4.1 如何实现实例化成员内部类的对象
*       4.2 使用在成员内部类中区分调用外部类的结构
*       4.3 开发中局部内部类的使用
*
* */

public class InnerClassTest {

    public static void main(String[] args) {
        // 创建Dog（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();
        // 创建Bird实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
    }


}

class Person{


    String name;
    int age;

    public void eat(){
        System.out.println("人：吃饭");
    }




    // 静态成员内部类
    static class Dog{

        String name;
        int age;
        public void show(){

        }

    }

    // 非静态成员内部类
     final class Bird{
        String name;
        public void sing(){
            System.out.println("我是一只小小鸟");
            Person.this.eat(); // 调用外部类的方法
        }


    }




    public void method(){
        // 局部内部类
        class AA{

        }
    }

    {
        // 局部内部类
        class BB{

        }


    }


    public Person(){
        // 局部内部类

    }


}
