/*
 * 四则运算当中的加号“+”有常见的三种用法
 *
 * 1. 对于数值来说，那就是加法
 * 2. 对于字符char类型来说，计算之前会被提升成int，然后再计算
 * 3. 对于字符串String（首字母大写，并不是关键字）来说，加号代表字符串连接操作
 *
 * 任何数据类型和字符串进行连接的时候，都会变成字符串
 *
 * */

public class Demon05Plus{
    public static void main(String[] args){
        String str1 = "Hello";
        System.out.println(str1);

        System.out.println(str1+"World");

        String str2 = "JAVA";
        // String + int --> String
        System.out.println(str2 + 20);

        // 优先级问题
        // String + int + int
        // String       + int
        // String
        System.out.println(str2 + 20 + 30);
        System.out.println(str2 + (20 + 30));
    }
}