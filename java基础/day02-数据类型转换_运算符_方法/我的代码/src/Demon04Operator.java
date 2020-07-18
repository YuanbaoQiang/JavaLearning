/*
 * 运算符： + - * /
 * 表达式：
 *
 * 四则运算
 * 加
 * 减
 * 乘
 * 除
 * */

public class Demon04Operator{
    public static void main(String[] args){
        // 两个常量之间也可以进行数学运算
        System.out.println(20+30);

        // 两个变量之间也可以进行数学运算
        int a = 10;
        int b = 20;
        System.out.println(a+b);

        // 变量和常量之间可以混合使用
        System.out.println(a+10);

        int x = 10;
        int y =3;
        int result1 = x / y;
        System.out.println(result1);

        int result2 = x % y;
        System.out.println(result2); // 余数 模：1

        // int + double --> double + double --> double
        double result3 = x + 2.5;
        System.out.println(result3); // 12.5
    }
}