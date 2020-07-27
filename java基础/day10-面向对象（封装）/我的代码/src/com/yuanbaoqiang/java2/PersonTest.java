/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 16:20
 **/

package com.yuanbaoqiang.java2;
/*
* this关键字的使用：
* 1. this 可以用来修饰：属性、方法、构造器
* 2. this 修饰属性和方法：
*    this 理解为：当前对象 或 当前正在创建的对象
*
* 2.1 在类的方法中，我们可以使用"this.属性" 或 "this.方法" 的方式，调用当前对象属性或方法。但是，通常情况下，我们都选择省略 "this."。
* 特殊情况下，如果方法的形参和类的属性同名时，我们必须显式地使用 "this.变量" 的方式，表明此变量是属性，而非形参。
*
* 2.2 在类的构造器中，我们可以使用"this.属性" 或 "this.方法" 的方式，调用当前对象属性或方法。但是，通常情况下，我们都选择省略 "this."。
* 特殊情况下，如果构造器的形参和类的属性同名时，我们必须显式地使用 "this.变量" 的方式，表明此变量是属性，而非形参。
*
* 3. this调用构造器
* 3.1 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
* 3.2 构造器中不能通过"this(形参列表)"方式调用自己
* 3.3 如果一个类中有n个构造器，则最多有n-1个构造器中使用了"this(形参列表)"
* 3.4 规定："this(形参列表)" 必须声明在当前构造器的首行
* 3.5 构造器内部，最多只能声明一个 "this(形参列表)"，用来调用其他的构造器
* */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();

    }
}
class Person{
    private String name;
    private int age;

    public Person(){
        this.eat();
        String info = "Person初始化，需要考虑如下的1，2，3，4...（共40行代码）";
        System.out.println(info);
    }

    public Person(int age){
        this();
    }

    public Person(String name, int age){
        this(age);
        // this.name = name;
        this.age = age;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

}
