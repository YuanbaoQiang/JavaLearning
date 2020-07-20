
/*
* 数组一旦创建，长度不能再发生改变
*
*
* */


public class Demon04ArrayLength {
    public static void main(String[] args){
        int[] arrayA = new int[3];

        int [] arrayB = {10, 20, 30, 50, 60, 80, 966};

        int len = arrayB.length;
        System.out.println("arrayB数组的长度是：" + len);
        System.out.println("==================");

        int[] arrayC = new int[3];
        System.out.println(arrayC);
        System.out.println(arrayC.length); // 3

        // arrayC只是一个命名，但实际上new的同时就已经多了一个数组
        // 地址也发生了改变
        arrayC = new int[5];
        System.out.println(arrayC);
        System.out.println(arrayC.length);

    }
}
