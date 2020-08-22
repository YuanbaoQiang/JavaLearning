/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-18 14:50
 **/

package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /*
    * 1. 向TreeSet中添加的数据，要求是相同类的对象
    * 2. 两种排序方式：自然排序(实现Comparable接口) 和 定制排序（Comparator）
    * 3. 自然排序中，比较两个对象是否为相同的标准：compareTo()返回0，不再是equals().
    * 4. 定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
    *
    * */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        // 失败：不能添加不同类的对象
/*        set.add(123);
        set.add(456);
        set.add("AA");
        System.out.println(set);*/

        // 举例一
/*        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(122);
        set.add(86);*/

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

    @Test
    public void test2(){


        Comparator com = new Comparator() {
            // 按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    // System.out.println(user1 + "<->" + user2);
                    int result;
                    result = user1.getAge() > user2.getAge() ? 1 : user1.getAge() == user2.getAge() ? 0 : -1;
                    if(result == 0){
                        result = user1.compareTo(user2);
                    }
                    return result;

                    // return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("传入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",20));
        set.add(new User("Jerry",45));
        set.add(new User("Marry",78));
        set.add(new User("Jmy",45));
        set.add(new User("Mike",66));
        set.add(new User("Jack",43));
        set.add(new User("Jack",34));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}
