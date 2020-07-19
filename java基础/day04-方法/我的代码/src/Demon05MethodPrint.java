/*
* 题目要求：
* 定义一个方法，用来打印指定次数的HelloWorld
* */
public class Demon05MethodPrint {
    public static void main(String[] args){
        print(2);
    }

    public static void print(int num){
        for (int i = 0; i < num; i++) {
            System.out.println("HelloWorld"+(i+1));
        }

    }
}
