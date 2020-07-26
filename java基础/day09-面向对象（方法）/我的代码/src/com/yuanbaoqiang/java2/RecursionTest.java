/**
 * <h3>我的代码</h3>
 * <p>递归方法的使用（了解）</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 15:06
 **/

package com.yuanbaoqiang.java2;

/*
* 递归方法的使用（了解）
* 1. 递归方法：一个方法体内调用它自身
* 方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
* 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环
*
* */


public class RecursionTest {
    public static void main(String[] args) {
        // 计算1-100之间所有自然数的和
        // 方式一

/*        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum +=i;
        }
        System.out.println("总和为：" + sum);*/

        // 方式二
        RecursionTest test = new RecursionTest();
        int sum = test.getSum(100);
        System.out.println("总和为：" + sum);

        System.out.println("***********************************");
        int f = test.f(10);
        System.out.println(f);
        System.out.println("***********************************");
        test.hanNuo(2,'A','B','C');

    }

    /**
     * @description: 1 - n 之和
     * @author: YuanbaoQiang
     * @date: 2020/7/26 15:24
     * @param n
     * @return: int
     */
    public int getSum(int n){
        if(n == 1 ){
            return 1;
        }else{
            return n + getSum(n - 1);
        }
    }

    /**
     * @description: n!
     * @author: YuanbaoQiang
     * @date: 2020/7/26 15:25
     * @param n
     * @return: int
     */
    public int getProduct(int n){
        if(n == 1 ){
            return 1;
        }else{
            return n * getSum(n - 1);
        }
    }

    // 例3：已知有一个数列：f(0) = 1, f(1) = 4, f(n+2) = 2*f(n+1)+f(n)
    // 其中n是大于0的整数，求f(10)的值
    /**
     * @description:
     * @author: YuanbaoQiang
     * @date: 2020/7/26 15:38
     * @param n
     * @return: int
     */
    public int f(int n){
        if(n == 0){
            return 1;
        }else if (n == 1){
            return 4;
        }else{
            return 2 * f(n-1) + f(n-2);
        }
    }

    // 例4：斐波那契数列
    // 例5：汉诺塔问题
    public void hanNuo(int num, char A, char B, char C){
        if(num == 1){
            System.out.println(A + "--> " + C);
        }else{
            hanNuo(num -1, A, C, B);
            System.out.println(A + "--> " + C);
            hanNuo(num -1, B, A, C);
        }
    }

    // 例6：快速排序

}
