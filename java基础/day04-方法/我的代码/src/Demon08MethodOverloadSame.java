/*
* 题目要求：
* 比较两个数据是否相等
* 参数类型分别式两个byte,两个short，两个int，两个long类型
* 并在main方法中测试
* */

public class Demon08MethodOverloadSame {
    public static void main(String[] args){
        byte a = 10;
        byte b = 20;
        System.out.println(isSame(a , b));

        System.out.println(isSame((short) a, (short) b));

        System.out.println(isSame(15,20));

        System.out.println(isSame(20L,20L));



    }

    public static boolean isSame(byte a, byte b){
        System.out.println("两个byte参数的方法执行！");
        return a == b;
    }

    public static boolean isSame(short a, short b){
        System.out.println("两个short参数的方法执行！");
        return a == b;
    }

    public static boolean isSame(int a, int b){
        System.out.println("两个int参数的方法执行！");
        return a == b;
    }

    public static boolean isSame(long a, long b){
        System.out.println("两个long参数的方法执行！");
        return a == b;
    }


}
