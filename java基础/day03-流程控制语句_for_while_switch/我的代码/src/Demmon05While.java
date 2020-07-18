/*
 * while 循环有一个标准格式
 * 初始化表语句；
 * while（条件判断）{
 * 循环体；
 * 步进语句；
 *
 * }
 * */
public class Demmon05While{
    public static void main(String[] args){
        int i = 1;
        while(i<=100){
            System.out.println("我错了"+i);
            i++;
        }
        System.out.println("程序已经结束,并且这是第"+i+"行");
    }
}