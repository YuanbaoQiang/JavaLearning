/**
 * <h3>我的代码</h3>
 * <p>面向对象的特征一：封装与隐藏</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 10:53
 **/

package com.yuanbaoqiang.java;

/*
* 一、问题的引入：
* 当我们创建一个类的对象以后，我们可以通过“对象.属性”的方式，对对象的属性进行赋值。
* 这里，赋值参数操作要受到属性的数据类型和存储范围的制约。但是在实际情况中，我们往往需要给属性赋值加上额外的限制条件。
* 这个条件就不能在属性声明时体现，我们只能通过方法进行限制条件的添加。
* （比如setlegs()），同时我们需要避免用户再使用“对象.属性”的方式对属性进行赋值，则需要将属性声明为私有的(private)
* -->此时，针对属性就体现了封装性。
*
* 二、封装性的体现：
* 我们将类的属性私有化（private），同时，提供公共的（public）方法来获取（getXxx）和设置（setXxx）此属性的值。
* 拓展：封装性的体现：1. 如上；2. 不对外暴露的私有的方法；3. 单例模式...
*
* 三、封装性的体现，需要权限修饰符来配合
* 1. Java规定的4种权限（从小到大排列）：private、缺省、protected、public
* 2. 4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
*                修饰类的话：只能使用：缺省、public
* 总结封装性：Java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在调用时的可见性的大小。
*
* */
public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "大黄";
        // a.legs = 4;
        // a.age = 1;
        a.show();


        // a.legs = -4;
        a.setLegs(6);
        a.show();
    }
}

class Animal{
    String name;
    private int age;
    private int legs; // 腿的个数

    // 提供关于属性age的set和get方法
    public int getAge(){
        return age;
    }

    public void setAge(int a){

    }


    // 对于属性的设置
    public void setLegs(int l){
        if(l >= 0 && l % 2 == 0){
            legs = l;
        }else{
            legs = 0;
            // 抛出一个异常（暂时未讲）
        }
    }

    // 对于属性的获取
    public int getLegs(){
        return legs;
    }


    public void eat(){
        System.out.println("动物进食");
    }

    public void show(){
        System.out.println("name = " + name + ", age = " + age + ", legs = " + legs);
    }
}
