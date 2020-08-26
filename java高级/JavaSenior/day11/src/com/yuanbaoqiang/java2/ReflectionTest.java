/**
 * <h3>JavaSenior</h3>
 * <p>
 *     调用运行时类指定的结构：属性、方法、构造器
 *
 *
 *
 * </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-24 15:54
 **/

package com.yuanbaoqiang.java2;

import com.yuanbaoqiang.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        // 创建运行时类的对象
        Person p = clazz.newInstance();


        // 获取指定的属性：要求运行时类中属性声明为public
        // 通常不采用此方法
        Field id = clazz.getField("id");



        /*
        * 设置当前属性的值
        *
        * set()：参数1：指明设置哪个对象的属性   参数2：将此属性值为多少
        *
        * */
        id.set(p,1001);

        /*
        * 获取当前属性的值
        *
        * get()：参数1：获取哪个对象的当前属性值
        * */
        int pID = (int) id.get(p);
        System.out.println(pID);


    }

    @Test
    public void testField1() throws Exception {
        Class<Person> clazz = Person.class;
        // 创建运行时类的对象
        Person p = clazz.newInstance();

        //
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);

        name.set(p,"Yuanbaoqiang");
        String s = (String) name.get(p);
        System.out.println(s);
    }

    /*
    * 如何操作运行时类中的指定的方法 -- 需要掌握
    *
    *
    * */

    @Test
    public void testMethod() throws Exception {

        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person p = clazz.newInstance();

        /*
        * 1. 获取指定的某个方法
        * getDeclaredMethod()：参数1：指明获取的方法的名称        参数2：指明获取的方法的形参列表
        *
        * */
        Method show = clazz.getDeclaredMethod("show", String.class);

        // 2. 保证当前方法是可访问的
        show.setAccessible(true);

        /*
        * 调用方法的invoke()：参数1：方法的调用者       参数2：给方法形参赋值的实参
        * invoke()的返回值即为对应类中调用的方法的返回值
        * */
        Object returnValue = show.invoke(p, "CHN"); // String nation = p.show("CHN")
        System.out.println(returnValue);

        System.out.println("*******************************************");

        // private static void showDesc(){}
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal); // null
    }

    /*
    如何调用运行时类中的指定的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */

        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);

    }


}
