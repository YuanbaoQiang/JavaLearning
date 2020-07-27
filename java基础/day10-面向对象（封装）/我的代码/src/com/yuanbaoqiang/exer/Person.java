/**
 * <h3>我的代码</h3>
 * <p>练习</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 14:05
 **/

package com.yuanbaoqiang.exer;
/*
* 创建程序，在其中定义两个类：Person和PersonTest类。定义如下：
* 用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄
* 在PersonTest类中实例化Person类的对象b，调用setAge()和getAge()方法。
*
* */
public class Person {
    private int age;

    public void setAge(int a){
        if(a < 0 || a > 130){
            // throw new RuntimeException("传入的数据非法");
            System.out.println("传入的数据非法！！");
        }else{
            age = a;
        }
    }

    public int getAge(){
        return age;
    }

}
