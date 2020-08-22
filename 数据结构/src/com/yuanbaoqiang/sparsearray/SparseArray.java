package com.yuanbaoqiang.sparsearray;

import java.util.Arrays;

/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-16 19:02
 **/

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        //0：表示没有棋子， 1表示黑子 2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        chessArr1[4][5] = 2;

        // 输出原始的二维数组
        System.out.println("原始的二维数组");
        print(chessArr1);

/*
        0	0	0	0	0	0	0	0	0	0	0
        0	0	1	0	0	0	0	0	0	0	0
        0	0	0	0	2	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	2	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0
        0	0	0	0	0	0	0	0	0	0	0

        */


        // 将二维数组 转 稀疏数组
        // 1. 先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        // System.out.println("sum = " + sum);

        // 创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存储到sparseArr中
        int count = 0; // count用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~");
        print(sparseArr);
        /*
        11	11	3
        1	2	1
        2	4	2
        4	5	2
        */


        // 将稀疏数组--> 原始的二维数组

        // 读取稀疏数组的第一行，根据第一行的数据，创建原始的数组
        int rows = sparseArr[0][0];
        int cols = sparseArr[0][1];

        int[][] chessArr2 = new int[rows][cols];

        System.out.println();
        System.out.println("创建的原始数组~~~~");
        print(chessArr2);
        System.out.println();

        // 给初始数组赋值
        for (int i = 1; i < sum + 1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        // 输出恢复后的二维数组
        print(chessArr2);

    }



    /*
     * @description: 打印二维数组
     * @author: YuanbaoQiang
     * @date: 2020/8/16 20:21
     * @param arr
     * @return: void
     */
    public static void print(int[][] arr){
        for(int[] row : arr){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
