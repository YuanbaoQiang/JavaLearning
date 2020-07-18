/*
 * 自增运算符："++"
 * 自减运算符："--"
 *
 * 基本含义：让一个变量涨一个数字1，或者让一个变量降一个数字
 * 使用格式：
 * 1. 单独使用：不和其他操作混合，自己独立成为一个步骤
 * 2. 混合使用：和其他操作混合，例如与赋值混合，或者与打印操作
 *
 * */

public class Demon06Operator{
    public static void main(String[] args){
        int num1 = 10;
        System.out.println(num1);

        // 与打印混合使用的时候
        int num2 = 20;
        // 混合使用，先++，变量立刻马上变成21，然后打印输出21
        ++num2;
        System.out.println(num2); // 21
        System.out.println("======================");

        int num3 = 30;
        // 混合使用，后++，首先使用变量本来的30，然后让变量+1得到31
        System.out.println(num3++); // 30
        System.out.println(num3);// 31
        System.out.println("======================");

        int num4 = 40;
        // 混合使用，先——，直接将num4
        System.out.println(--num4);
        System.out.println("======================");

        int num5 = 50;
        num5++;
        System.out.println(num5++); // 51
        System.out.println(num5); // 52
        System.out.println("======================");

        int x = 10;
        int y = 20;
        int result1 = ++x + y--; // 实际写代码一般不这么写，要简单明了
        System.out.println(result1); // 31
        System.out.println(x); // 11
        System.out.println(y); // 19

        // 常量不可++，不可--
        // System.out.println(60++);
    }
}