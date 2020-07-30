/**
 * <h3>我的代码</h3>
 * <p>super关键词的使用</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 09:27
 **/

package com.yuanbaoqiang.java4;

/*
* 1. super理解为：父类的
* 2. super可以用来调用属性，方法，构造器
*
* 3. super的使用
* 3.1 我们可以在子类的方法或者构造器中。通过使用super.属性或者super.方法的方式，显式的调用父类中声明的属性和方法，通常情况，我们习惯省略"super."
* 3.2 特殊情况：当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的方法，则必须显示的使用"super.属性"的方式，表明调用的是父类中声明的属性。
* 3.3 特殊情况：当子类重写了父类的方法以后，我们想在子类的方法中调用父类中被重写的方法时。则必须显式的使用"super.方法"的方式，表明调用的是父类中被重写的方法。
*
* 4. super调用构造器
* 4.1 我们可以在子类的构造器中显式子的使用"super(形参列表)"的方式，调用父类中声明的构造器；
* 4.2 "super(形参列表)"，必须声明在子类构造器的首行！
* 4.3 我们在类的构造器中，争对"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
* 4.4 当我们在类的构造器中，争对"针对this(形参列表)" 或者 "super(形参列表)"，则默认调用父类中空参的构造器：super()
* 4.5 在类的多个构造器中，至少有一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器
*
* */

import javax.xml.stream.events.StartDocument;

public class SupderTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();

        System.out.println();
        s.study();


        Student s1 = new Student("Tom", 21, "IT");
        s1.show();

        Student s2 = new Student();
    }



}
