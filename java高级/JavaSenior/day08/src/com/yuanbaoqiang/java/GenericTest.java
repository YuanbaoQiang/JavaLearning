/**
 * <h3>JavaSenior</h3>
 * <p>泛型的使用</p>
 *
 *
 * 在集合中使用泛型：
 * 总结：
 * 1. 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * 2. 在实例化集合类中，可以指明具体的泛型类型
 * 3. 指明完以后，在集合类或接口中凡是定义类或接口时，
 *      内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化时泛型类型
 *      比如 add(E e) --> add(Integer e)
 * 4. 注意点：泛型的类型必须时类，不是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 * 5. 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 *
 *
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 *
 *
 *
 *
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-20 08:36
 **/

package com.yuanbaoqiang.java;


import org.junit.Test;

import java.util.*;

public class GenericTest {

    // 在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        // 需求：存放学生的成绩
        list.add(123);
        list.add(76);
        list.add(90);
        list.add(78);

        // 问题一：类型不安全
        list.add("Tom");

        for(Object score : list){
            // 问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }


    // 在集合中使用泛型之前的情况：以ArrayList
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(89);
        list.add(100);
        list.add(56);
        // 编译时就会进行类型检查，保证数据的安全
        // list.add("Tom");

/*        // 方式一
        for(Integer score : list){
            // 避免了强转操作
            int stuScore = score;
            System.out.println(stuScore);
        }*/

        // 方式二
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    // 在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        // map.put(123,"ABC");

        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.printf("%s ---> %d\n", key, value);
        }

    }



}
