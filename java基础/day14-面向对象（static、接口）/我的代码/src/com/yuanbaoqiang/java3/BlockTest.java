/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-01 16:27
 **/

package com.yuanbaoqiang.java3;

/*
* 类的成员之四：代码块（或初始块）
*
* 1. 代码块的作用：用来初始化类、对象
* 2. 代码块如果有修饰：只能是static.
* 3. 分类：静态代码块 vs 非静态代码块
*
*
* 4. 静态代码块
*   > 内部可以有输出语句
*   > 随着类的加载而执行，而且只加载一次
*   > 如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
*
*
* 5. 非静态代码块
*   > 内部可以有输出语句
*   > 随着对象的创建而执行
*   > 每创建一个对象，就执行一次非静态代码
*   > 作用：可以创建对象时，对对象的属性等进行初始化
*
*
* 对属性可以赋值的位置：
* 默认初始化
* 显式初始化
* 构造器初始化
* 有了对象之后，可以通过"对象.属性"或者"对象.方法"的方式，进行赋值
* 在代码块中赋值
*
* */

public class BlockTest {
    public static void main(String[] args) {
        // String desc = Person.desc;
        // Person.info();
        Person p1 = new Person();
        Person p2 = new Person();
    }

}

class Person{
    // 属性
    String name;
    int age;
    static  String desc = "我是一个人";

    // 构造器
    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 代码块
    static {
        System.out.println("helo, static block");

    }

    // 非静态代码块
    {
        System.out.println("helo, block");
    }


    //方法
    public void eat(){
        System.out.println("吃饭");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void info(){
        System.out.println("我是一个快乐的人");
    }


}
