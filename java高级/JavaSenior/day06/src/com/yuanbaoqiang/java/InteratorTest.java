/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 *
 * 集合元素的遍历操作，使用迭代器Interator接口
 * 1. 内部的方法：hasNext()和next()
 * 2. 集合对象每次调用interator()方法都得到一个全新的迭代器对象，
 *     默认游标都在集合的第一个元素之前
 * 3. 内部定义了remove()，可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove()
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-17 15:26
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 方向
        int count = coll.size();
        while(count > 0){
            count--;
            System.out.println(iterator.next());
        }

        // 推荐写法
        // hasNext()：判断是否还有下一个元素
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 错误方式一：
        while(iterator.next() != null){
            System.out.println(iterator.next());
        }

    }

    // Interator remove()
    // 如果还未调用next()或在上一次调用next方法之后调用了removw方法
    // 再调用remove都会报IllegalStateException
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        // 删除集合中的"Tom"
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }

        // 遍历集合
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }


}
