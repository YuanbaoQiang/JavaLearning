/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-20 16:49
 **//*


package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class test {

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        // 失败：不能添加不同类的对象
        set.add(123);
        set.add(456);
        set.add("AA");
        System.out.println(set);

        // 举例一
*/
/*        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(122);
        set.add(86);*//*


        // 举例二
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jmy",3));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",15));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}
*/
