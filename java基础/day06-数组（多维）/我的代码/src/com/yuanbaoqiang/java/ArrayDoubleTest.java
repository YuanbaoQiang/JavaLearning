package com.yuanbaoqiang.java;

/*
* 二维数组的使用
* 规定：二维数组 分为 外层数组的元素  内存数组的元素
* int[] arr = new int[4][3];
* 内存元素：arr[0], arr[1]等
* 外层元素：arr[0][0], arr[1][2]等
*
* 数组元素的默认初始化值
* 争对初始化方式1 比如int[][] arr = new int[4][3]
* 外层元素的初始化值为：地址值
* 内存元素的初始化值为：与一维数组初始化情况相同
*
* 针对初始化方式2 比如 int[][] arr = new int[4][];
* 外层元素的初始化值为：null
* 内层的初始化值为：不能带调用 否则报错
*
*
*
*
* 数组的内存解析
*
*
*
* */
public class ArrayDoubleTest {
    public static void main(String[] args){
        int[][] arr = new int[4][3];
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[0][0]); // 0


    }
}
