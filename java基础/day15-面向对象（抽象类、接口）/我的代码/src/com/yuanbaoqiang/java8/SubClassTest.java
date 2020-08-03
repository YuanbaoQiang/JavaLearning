/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 19:03
 **/

package com.yuanbaoqiang.java8;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();

        // 知识点1：接口中定义的静态方法，只能通过接口来调用
        CompareA.method1();
        // 知识点2：通过实现类的对象，可以调用接口中的默认方法
        s.method2();

        // 知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，
        // 那么子类在没有重写此方法的情况下，默认的时 父类中的同名同参数的方法。-->类优先原则
        // 知识点4：如果实现类实现了多个接口，而这多个接口定义了同名同参数的默认方法
        // 那么在实现类没有重写此方法的情况下，报错。 --> 接口冲突
        // 这就需要我们必须在实现类中重写此方法
        s.method3();

    }
}

class SubClass extends SuperClass implements CompareA,CompareB{
    @Override
    public void method2() {

    }


    @Override
    public void method3() {
        System.out.println("重写。。。。。。。。。");
    }
}
