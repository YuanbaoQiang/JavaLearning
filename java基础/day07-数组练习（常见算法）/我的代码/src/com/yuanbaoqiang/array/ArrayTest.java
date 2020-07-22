package com.yuanbaoqiang.array;


import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args){

        // 1. boolean equals(int[] a, int[] b): 判断两个数组是否相等
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1,arr2);
        System.out.println(isEquals);

        // 2. String toString(int[] a): 输出数组信息
        System.out.println(Arrays.toString(arr1));

        // 3. void fill(int[] a, int val): 将指定值填充到数组之中
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        // 4. void sort(int[] a): 对数组排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        // 5. int binarySearch(int[] a, int key)
        int[] arr3 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
        int index = Arrays.binarySearch(arr3,210);
        System.out.println(index);

    }
}
