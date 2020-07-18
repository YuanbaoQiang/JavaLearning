/*
 * 强制类型转换
 * 1. 特点：代码需要进行特殊的格式处理，不能自动完成
 * 2. 格式：范围小的类型  范围小的变量名 = （范围小的类型）原本范围大的数据
 *
 * 注意事项：
 * 1. 强制类型转换一般不推荐使用，因为可能会有精度损失，数据溢出
 * 2. byte/short/char这三种类型都可以发生数学运算，例如加法“+”
 * 3. byte/short/char这三种类型在运算的时候都会先提升成int， 然后再计算
 * 4. 在Java中boolen类型不能发生任何数据类型转换
 * */
public class Demon02DataType{
    public static void main(String[] args){
        int num1 = (int) 100L;
        System.out.println(num1);

        // long强制转换成int类型
        int num2 = (int) 60000000000L;
        System.out.println(num2);

        // double -->int 强制类型转换
        int num3 = (int) 3.99;
        System.out.println(num3);

        char zifu1 = 'A';
        System.out.println(zifu1+1);

        byte num4 = 40;
        byte num5 = 50;

        // byte +byte --> int + int
        int result1 = num4 +num5;
        System.out.println(result1);

        short num6 = 60;
        // byte + short --> int +int --> int
        //int 强制转换成short: 注意必须保证逻辑上真实大小
        short result2 = (short) (num4 + num6);
    }
}