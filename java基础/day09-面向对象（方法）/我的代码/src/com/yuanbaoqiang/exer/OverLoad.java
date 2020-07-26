/**
 * <h3>我的代码</h3>
 * <p>重载练习</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 09:24
 **/

package com.yuanbaoqiang.exer;

/*
* 定义三个重载方法并调用。方法名为mOL
* 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
* 分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息
* 在主类main()方法中分别用参数调用三个方法
* */
public class OverLoad {

    public static void main(String[] args){
        OverLoad test = new OverLoad();
        double max = test.max(15,31,30);
        System.out.println(max);
    }

    // 1. 如下的三个方法构成重载
    /**
     * @description: 平方和
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:28
     * @param a
     * @return: int
     */
    public int mOL(int a){
        return a * a;
    }

    /**
     * @description: 两数相乘
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:29
     * @param a
     * @param b
     * @return: int
     */
    public int mOL(int a, int b){
        return a * b;
    }

    /**
     * @description: 输出字符串信息
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:30
     * @param s
     * @return: void
     */
    public void mOL(String s){
        System.out.println(s);
    }

    // 2. 如下的三个方法构成重载
    /**
     * @description: 两个int最大值
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:56
     * @param i
     * @param j
     * @return: int
     */
    public int max(int i, int j){
        return (i > j) ? i : j;
    }

    /**
     * @description: 两个double最大值
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:56
     * @param i
     * @param j
     * @return: double
     */
    public double max(double i, double j){
        return (i > j) ? i : j;
    }

    /**
     * @description: 三个double最大值
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:56
     * @param i
     * @param j
     * @param k
     * @return: double
     */
    public double max(double i, double j, double k){
        double m1 = i > j ? i : j;
        double max = m1 > k ? m1 : k;
        return max;
    }
}
