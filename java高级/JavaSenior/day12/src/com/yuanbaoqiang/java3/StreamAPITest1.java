/**
 * <h3>JavaSenior</h3>
 * <p>测试Stream的中间操作</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-26 08:45
 **/

package com.yuanbaoqiang.java3;


import com.yuanbaoqiang.java2.Employee;
import com.yuanbaoqiang.java2.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        //        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
//        limit(n)——截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        //        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();
//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素

        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",41,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));


        list.stream().distinct().forEach(System.out::println);

    }


}
