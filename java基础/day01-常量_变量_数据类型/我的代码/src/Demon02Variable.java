public class Demon02Variable{
    public static void main(String[] args){
        // 创建一个变量
        // 格式： 数据类型 变量名称
        int num1;
        // 向变量中存入一个数据
        // 格式： 变量名称 = 数据值
        num1 = 10;
        System.out.println(num1);
        // 改变变量当中本来的数字，变成新的数字
        num1 = 20;
        System.out.println(num1);

        // 采用一步到位得方法
        // 格式：数据类型 变量名称 = 数据值
        int num2 = 25;
        System.out.println(num2);

        int num3 = num2;
        System.out.println(num3);

    }
}

