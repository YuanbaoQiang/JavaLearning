/*
 * 使用变量的时候，有一些注意事项
 * 1. 变量不可以重复定义
 * 2. 对于float和long，后缀F和L不要丢掉
 * 3. 如果使用byte和short类型的变量，那么右侧的数据不能超过左侧类型的范围
 * 4. 变量定义后，不可以直接使用，一定要赋值
 * 5. 变量使用不可以超过作用域的范围
 * 【作用域】：从定义变量的一行开始，一直到直接所属的大括号结束为止
 * 6. 可以一个语句创建多个变量
 * */


public class Demon03VariableNotice {
    public static void main(String[] args){
        int num1 = 10;
        // int num1 = 20; 名称不可以重复

        int num2;
        // System.out.println(num2); 未赋值，不可直接使用

        long num3 = 100L;// long后缀L
        System.out.println(num3);

        System.out.println(10.66F);// float后缀F

        byte b1 = 127;
        System.out.println(b1);
        // byte b2 = 128;
        // System.out.println(b2); // 超出数据类型
        short s1 = 32767;
        System.out.println(s1);
        //short s2 = 32768; // 超出数据类型
        //System.out.println(s2);

        {
            int num4 = 10;
            System.out.println(num3);
        } // 作用域包含大括号内，超出范围就不可调用

        // 再次定义num4不会出错
        int num4 = 100;
        System.out.println(num3);
    }
}