/*
数组可以作为方法的参数
当调用方法的时候，向方法的小括号进行传参，传递进去的其实是数组的地址值


*/

public class Demon07ArrayParameter {
    public static void main(String[] args){
        int[] array = {10, 20, 30, 40, 50, 60};
        System.out.println(array); // 地址值
        printArray(array); // 传递进去的就是array的地址值

    }

    // 定义一个方法
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
