package com.yuanbaoqiang.OOPTest;

/*
* 类中方法的声明和使用
*
* 方法：描述类应该具有的功能。
* 比如：Math类：sqrt()\random()\
*      Scanner类：nextXxxx()
*      Arrays类：sort() \ binarySearch() \ toString() \ equals() \ ...
*
* 1. 举例：
* public void eat(){}
* public void sleep(int hour){}
* public String getName(){}
* public String getNation(String nation){}
*
* 2. 方法的声明：权限修饰符  返回值类型  方法名（形参列表）{
*                       方法体
* }
*
* 3. 说明：
* 3.1 关于
*
* */
public class CustomerTest {

}

class Customer{
    // 属性

    String name;
    int age;
    boolean isMale;

    // 方法
    public void eat(){
        System.out.println("客户吃饭");
    }

    public void sleep(int hour){
        System.out.println("休息了" + hour + "个小时");
    }

    public String getName(){
        return name;
    }

    public String getNation(String nation){
        String info = "我的国籍是：" + nation;
        return info;
    }


}
