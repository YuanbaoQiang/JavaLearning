/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()。
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-17 14:21
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.util.*;

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        // contains(Object obj)；判断当前集合中是否包含obj
        // 我们在判断时会调用obj对象所在类的equals()方法
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry",20))); // true

        // containsAll(Collection coll1)：判断形参coll1中的所有元素是否存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

    }


    @Test
    public void test2(){
        // 3. remove(Object obj)：从当前集合中溢出obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

/*
        boolean remove = true;
        remove = coll.remove(123);
        System.out.println(coll.contains(123) + " " + remove);
        System.out.println(coll);
*/


        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        // 4.removeAll(Collection coll1)：差集：从当前集合中移除coll1所有的元素
        Collection coll1 = Arrays.asList(77);
        boolean b = coll.removeAll(coll1);
        System.out.println(b);
        System.out.println(coll);

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        // 5. retainAll(Collection coll1)：交集：获取当前集合和coll1的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll);

        // 6. equals(Object obj)：

/*        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(new Person("Jerry",20));
        coll1.add(false);

        System.out.println(coll.equals(coll1));*/
    }



    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        // 7. hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // 8. 集合 --> 数组：toArray()
        Object[] arr = coll.toArray();
        for(Object data : arr){
            System.out.println(data);
        }

        // 拓展：数组 --> 集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "bb", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size()); // 1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size()); // 1


        // iterator()：返回Interator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试


    }



}
