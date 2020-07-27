/**
 * <h3>我的代码</h3>
 * <p>属性赋值的过程</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 15:30
 **/

package com.yuanbaoqiang.java1;
/*
* 总结：属性赋值的先后顺序
*
* 1. 默认初始化
* 2. 显式初始化
* 3. 构造器中初始化
*
*
* 4. 通过 "对象.方法" 或者 "对象.属性" 的方式，赋值
*
* 以上操作的先后顺序：1 -- 2 -- 3 -- 4
* */
public class UserTest {
    public static void main(String[] args) {
        User u = new User();
        System.out.println(u.age);

        User u1 = new User(10);
        u1.setAge(20);
        System.out.println(u1.age);
    }
}

class User{
    String name;
    int age = 1;
    public User(){

    }


    public User(int a){
        age = a;
    }

    public void setAge(int a){
        age = a;
    }


}
