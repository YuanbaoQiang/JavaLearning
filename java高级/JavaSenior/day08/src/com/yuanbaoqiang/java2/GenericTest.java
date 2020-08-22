/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * 1. 泛型在继承方面的体现
 *
 * 2. 通配符的使用
 *
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-20 13:55
 **/

package com.yuanbaoqiang.java2;

import com.yuanbaoqiang.java1.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {




    /*
    * 泛型在继承方面的体现
    *
    *
    * 类A是类B的父类，G<A> 和 G<B>二者不具备子父关系，二者是并列关系
    *
    * 补充：类A是类B的父类，A<G> 是 B<G>的父类
    *
    *
    *
    * */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;


        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;


        // 编译不通过
        // Date date = new Date();
        // str = date;

        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时的list1和list2不具有子父类关系
        // list1 = list2;
        /*
        * 反证法：
        * 假设list1 = list2
        * list1.add(123) 导致混入非String类型的数据，除出错
        *
        *
        *
        * */


        // show(list1);
        // show(list2);

    }



    @Test
    public void test2(){
        List<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();
    }





    public void show(List<String> list){


    }


    /*
    * 通配符的使用
    *
    * 通配符：？
    *
    * 类A是类B的父类， G<A> 和 G<B> 是没有关系额，二者共同的父类是：G<?>
    *
    * */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;


/*        print(list1);
        print(list2);*/


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        // 添加：对于List<?>就不能向其内部添加数据
        // list.add("DD");
        // list.add("?");

        list.add(null);


        // 获取（读取）：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);


    }













    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }


    /*
    * 3. 有限制条件的通配符的使用
    *
    * ? extends A：
    *       G<? extends A> 可以作为G<A> 和 G<B>的父类，其中B是A的子类
    *
    * ? super A：
    *       G<? super A> 可以作为G<A> 和 G<B>的父类，其中B是A的父类
    *
    *
    *
    * */

    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

/*        list1 = list3;
        list1 = list4;
        list1 = list5;*/


/*        list2 = list3;
        list2 = list4;
        list2 = list5;*/



    }




}
