/**
 * <h3>JavaSenior</h3>
 * <p>注解的使用</p>
 *
 * 1. 理解Annotation：
 *      >jdk 5.0新增
 *      >
 *
 *
 * 2. Annotation的使用示例
 *
 * 3. 如何自定义注解：参照 @SuppressWarning 定义
 *      声明为@interface
 *
 *      自定义注解通常会指明两个元注解：Retention、Target
 *
 *
 * 4. jdk 提供的4中元注解
 *      元注解：对现有的注解进行解释说明的注解
 *
 *      Retention：指定所修饰的Annotation的生命周期：SOURCE CLASS（默认行为） RUNTIME
 *                  只有声明为RUNTIME生命周期的注解，才能够通过反射获取。
 *      Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 *      Document：表示所修饰的注解在被javadoc解析时，保留下来。
 *      Inherited：被它修饰的Annotation，将具有继承性
 *
 * 5. 通过的反射获取注释信息
 *
 * 6. jdk 8中注解的新特性：可重复注解、类型注解
 *      6.1 可重复注解：
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-17 09:01
 **/

package com.yuanbaoqiang.java1;

public class AnnotationTest {
}

@MyAnnotation(value = "hi")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}


class Students extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }

    @Override
    public void show() {

    }
}
