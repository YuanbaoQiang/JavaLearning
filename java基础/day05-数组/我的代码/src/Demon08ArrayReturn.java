/*
* 一个方法可以有0、1、多个参数；但只能有0或者1个返回值，不能有多个返回值
* 如果希望一个方法产生了多个结果数据进行返回，怎么办？
*
* 解决方案：使用一个数组作为返回值类型即可
* */
public class Demon08ArrayReturn {
    public static void main(String[] args){
        int[] result = calculate(10, 20, 30);
        System.out.println("result的地址值："+ result);
        System.out.println("总和为"+result[0]);
        System.out.println("平均数为"+result[1]);

    }

    public static int[] calculate(int a, int b, int c){
        int sum = a + b + c; //总和
        int ave = sum / 3; // 平均数

        int [] array = new int[2];
        array[0] = sum; // 总和
        array[1] = ave; // 平均数

        System.out.println("array的地址值："+array);
        return array;
    }
}
