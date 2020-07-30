/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 15:22
 **/

package com.yuanbaoqiang.java5;
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

    }
}
