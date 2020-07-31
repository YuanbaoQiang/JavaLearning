package com.yuanbaoqiang.exer;

/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 12:43
 **/

public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count); // 20
        s.display(); // 20
        Base b = s;
        // == 对于引用数据类型来讲，比较的是两个引用数据类型的地址值是否相同
        System.out.println(b == s); // true!!!!!!!!
        System.out.println(b.count); // 10   多态只对方法有用 对属性无用
        b.display(); // 20


    }
}
