/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * 一、集合框架的概述
 * 1. 集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *      说明：此时的存储，只要指内存层面的存储，不涉及到持久化的存储（.txt, .jpg, .avi）
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了
 *      > 数组元素的类型也就确定了。只能操作指定类型的数据了。
 *          比如String[] arr; int[] arr1; Object[] arr2
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不方便，同时效率不高
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或者方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 *
 * 二、集合框架
 *          |----Collection接口：单列集合
 *              |----List接口：存储有序的、可重复的数据。 --> “动态”数组
 *                  |----ArrayList  LinkedList  Vector
 *              |----Set接口：存储无序的、不可重复的数据 ---> 高中讲的“集合”
 *                  |----HashSet    LinkedHashSet   TreeSet
 *          |----Map接口：双列集合，用来存储一对（key - value）一对的数据 ---> 高中函数：y = f(x)
 *                  |---- HashMap   LinkedHashMap   TreeMap     HashTable   properties
 *
 * 三、Collection接口中的方法
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-17 13:21
 **/

package com.yuanbaoqiang.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        // add(Object e)：将元素e添加到集合coll中
        // add()
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // size()
        System.out.println(coll.size()); // 4

        //addAll(Collection coll1)：将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(454);
        coll1.add("cc");
        coll.addAll(coll1);

        System.out.println(coll.size()); // 6

        //clear()：清空集合元素
        coll.clear();

        // isEmpty()：判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }


}
