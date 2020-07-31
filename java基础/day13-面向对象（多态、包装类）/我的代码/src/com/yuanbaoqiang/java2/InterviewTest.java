/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 22:16
 **/

package com.yuanbaoqiang.java2;

import org.junit.Test;

public class InterviewTest {

    @Test
    public void test1(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
    }

    @Test
    public void test2(){
        Object o2;
        if(true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);
    }

    @Test
    public void test3(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false



        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true

        // Interger内部定义了IntergerCache结构，IntergerCache中定义了Interger[]
        // 保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Interger赋值的范围在
        // -127~128范围内时，可以直接使用数组中的元素，不用去new了。 目的: 提高效率

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false
    }



}
