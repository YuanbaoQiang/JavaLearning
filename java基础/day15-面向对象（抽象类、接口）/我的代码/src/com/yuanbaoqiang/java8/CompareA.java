/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 18:59
 **/

package com.yuanbaoqiang.java8;





public interface CompareA {
    // 静态方法
    public static void method1(){
        System.out.println("CompareA：北京");
    }


    // 默认方法
    public default void method2(){
        System.out.println("CompareA：上海");
    }


    public default void method3(){
        System.out.println("CompareA：method3");
    }

}
