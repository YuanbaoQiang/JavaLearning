/**
 * <h3>我的代码</h3>
 * <p>练习</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 14:05
 **/

package com.yuanbaoqiang.exer;
/*
* 在PersonTest类中实例化Person类的对象b，调用setAge()和getAge()方法。
*
* */
public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.setAge(12);
        System.out.println("年龄为：" + p1.getAge());
    }
}
