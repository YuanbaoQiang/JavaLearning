
/*
* 定义一个两个int数字相加的方法。三要素
* 返回值类型：int
* 方法名称：sum
* 参数列表：int a, int b
*
* */


/*
* 调用的三种方式
*
* 1. 单独调用
* 2. 打印调用，System.out.println(方法名称（参数）)
* 2. 赋值调用：数据类型  变量名称 = 方法名称（参数）
*
*
* */
public class Demon02MethodDefine {
    public static void main(String[] args){
        // 单独调用
        sum(5,6);
        System.out.println("======================");

        // 打印调用
        System.out.println(sum(10,20));

        // 赋值调用
        int input = sum(5,6);

        System.out.println("======================");

        method();

    }

    public static int sum(int a, int b){
        int result = a + b;
        return result;
    }

    // 打印输出固定十次文本字符串
    public static void method(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World"+i);
        }
    }
}
