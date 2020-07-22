package com.yuanbaoqiang.array;

/*
*
* 定义一个 int 型的一维数组，包含 10 个元素， 分别赋一些随机整数个元素，
* 然后求出所有元素的最大值， 然后求出所有元素的最大值， 最小值，平均值， 并输出 出来 。
*
* [10,99]
* (int) (Math.random() * (99 - 10 + 1) + 10)
*
* */

public class ArrayTest1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 求最大值
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxValue = arr[i] > maxValue ? arr[i] : maxValue;
        }
        System.out.println("最大值为：" + maxValue);

        // 求最小值
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minValue = arr[i] < minValue ? arr[i] : minValue;
        }
        System.out.println("最小值为：" + minValue);

        // 求总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总和为：" + sum);


        // 求平均数
        int ave = sum/arr.length;
        System.out.println("平均数为：" + ave);
    }
}
