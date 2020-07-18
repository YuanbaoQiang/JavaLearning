/*
 * 当数据类型不一样时，数据将会发生自动转换
 *
 * 自动类型转换（隐式）
 *
 * 1. 特点：代码不需要进行特殊处理
 * 2. 规则：数据范围从小到到大
 *
 * 强制类型转换（显式）
 * */

/*
 * 自动类型转换（隐式）
 * */
public class Demon01DataType {
    public static void main(String[] args){
        System.out.println(1024); // 整数 默认为int
        System.out.println(3.14); // 浮点数 默认为double

        // 左边是long类型  右边是int类型  左右不一样
        // int --> long, 符合从小到大的规则
        long num1 = 100L;
        System.out.println(num1); // 100

        // 左边是double类型  右边是float
        // float --> double, 符合从小到大的规则
        // 4字节 --> 8字节
        double num2 = 2.5F;
        System.out.println(num2);

        // 左边float类型，右边是long类型
        // long -->float，符合从小到大的规则（数据范围）
        // 8字节 -->4字节  也可以实现转换，转换和数据范围有关，和占用内存范围无关
        float num3 = 100L;
        System.out.println(num3);

    }
}