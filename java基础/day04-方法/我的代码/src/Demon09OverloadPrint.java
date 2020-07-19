
// 在调用输出语句的时候，println()就是进行了多种数据类型的重载形式

public class Demon09OverloadPrint {

    public static void main(String[] args){
        myPrint((byte) 10);
        myPrint((short) 10);
        myPrint(10);
        myPrint(100L);

        myPrint('c');
    }


    public static void myPrint(byte num){
        System.out.println(num);
    }

    public static void myPrint(short num){
        System.out.println(num);
    }

    public static void myPrint(int num){
        System.out.println(num);
    }

    public static void myPrint(long num){
        System.out.println(num);
    }

    public static void myPrint(float num){
        System.out.println(num);
    }

    public static void myPrint(double num){
        System.out.println(num);
    }

    public static void myPrint(char num){
        System.out.println(num);
    }

    public static void myPrint(boolean num){
        System.out.println(num);
    }
}
