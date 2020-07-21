package com.yuanbaoqiang.java;


/*
* 二维数组的使用
*
* 1. 理解
* 对于二维数组的理解，我们可以看成一维数组array1又作为另一个数组array2的元素而存在
* 其实，从数组底层的运行机制来看，其实并没有多为数组
* */
public class ArrayDouble {
    public static void main(String[] args) {
        // 二维数组的说明和初始化
        int[] arr = new int[]{1,2,3};// 一维数组

        // 静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{5,4},{7,8}}; // 二维数组
        // 动态初始化1
        String[][] arr2 = new String[3][2];
        // 动态初始化2
        String[][] arr3 = new String[3][];

        // 也是正确的写法
        int[] arr4[] = new int[][]{{1,2,3},{4,5,9,10},{6,7,8}};
        int[] arr5[] = {{1,2,3},{4,5},{6,7,8}};

        // 二维数组的调用
        System.out.println(arr1[0][1]); // 2
        System.out.println(arr1[2][0]); // 7
        System.out.println(arr2[2][0]); // null

        arr3[1] = new String[4];
        System.out.println(arr3[1][0]); // 得先对 arr3[1]进行定义，否则出现空指针异常

        // 获取数组的长度
        System.out.println(arr4.length); // 3
        System.out.println(arr4[0].length); // 3
        System.out.println(arr4[1].length); // 2

        //如何遍历二维数组
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }


        int[][] array = new int[4][];
        array[1] = new int[]{1,2,3};
        array[2] = new int[4];
        array[2][1] = 30;

    }
}
