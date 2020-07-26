/**
 * <h3>我的代码</h3>
 * <p>可变个数形参的方法</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 10:11
 **/

package com.yuanbaoqiang.java1;
/*
* 1. 可变个数形参的格式： 数据类型 ... 变量名
* 2. 当调用可变个数形参的方法时，传入的参数个数可以是0个，1个，2个，或者多个
* 3. 可变形参的方法与本类中方法名相同，形参不同的方法之间构成重载
* 4. 可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载。换句话说，二者不能共存
* 5. 可变个数形参在方法的形参中，必须声明在末尾
* 6. 可变个数形参在方法的形参中，最多只能声明一个可变形参
* */


public class MethodArgsTest {

    public static void main(String[] args){
        MethodArgsTest test = new MethodArgsTest();
        // test.show(12);
        test.show("AA", "CC", "BB", "DD");

    }

    public void show(int i){

    }

    public void show(String s){
        System.out.println("show(String s)");
    }

    /**
     * @description: 可变个数形参的方法
     * @author: YuanbaoQiang
     * @date: 2020/7/26 10:45
     * @param strs
     * @return: void
     */
    public void show(String ... strs){
        System.out.println("show(String ... strs)");
        for(int i = 0; i < strs.length; i++){
            System.out.println(strs[i]);
        }
    }


/*    public void show(String[] strs){

    }*/

    public void show(int i, String ... strs){

    }

}
