package com.yuanbaoqiang.java; /**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 15:22
 **/

/*
* 面向对象特征之三：多态性
*
* 1. 理解多态性：可以理解为一个事物的多种形态。
* 2. 何为多态性：
* 对象的多态性，父类的引用指向子类的对象（或子类的对象赋给父类的引用）
*
* 3. 多态的使用：虚拟方法调用
* 有了对象以后，我们在编译期，只能调用父类中声明的方法，但在以运行期，我们实际执行的是子类重写父类的方法。
* 总结：编译，看左边；运行看右边
*
* 4. 多态性的使用前提：1. 要有类的继承关系；2. 要有方法的重写
* 5. 对象的多态性
*
* */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();

        Woman woman = new Woman();
        woman.eat();

        /****************************************************/
        // 对象的多态性：父类的引用指向子类的对象
        Person p2 = new Man();

        // 多态的使用：当调用子父类同名参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
        p2.eat();
        p2.walk();

        //*************************************************
        // 不能调用子类所特有的方法，编译时p2是Person类型。
        // 使用强制类型转换符
        Man m1 = (Man)p2;
        m1.earnMoney();

        // 使用强转式，可能出现ClassCastException的异常
/*        Woman w1 = (Woman)p2;
        w1.goShopping();*/

        /*
        * instanceof关键字的使用
        *
        * a instanceof A: 判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false
        *
        * 使用情境：为了避免出现ClassCastException的异常，我们在向下转型之前，先进行instaceof的判断，一旦返回true，就进行向下转型。
        *
        * 如果a instanceof A返回true，则a instanceof B也返回true，则类B是类A的父类
        * */

        if(p2 instanceof Woman){
            Woman w1 = (Woman)p2;
            w1.goShopping();
            System.out.println("*****Woman*****");
        }

        if(p2 instanceof Man){
            Man m2 = (Man)p2;
            m2.earnMoney();
            System.out.println("*****Man*****");
        }

        if(p2 instanceof Person){
            System.out.println("*****Person*****");
        }

        if(p2 instanceof Object){
            System.out.println("*****Object*****");
        }

        // 练习
        // 问题一：编译时通过，运行时不通过
/*        Person p3 = new Woman();
        Man m2 = (Man)p3;*/

        // 问题二：编译通过，运行时也通过
        Object obj = new Woman();
        Person p = (Person)obj;



    }
}
