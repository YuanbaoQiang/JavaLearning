package com.yuanbaoqiang.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
/*        int[] arr = new int[]{43,23,56,-95,56,86,95,36,45};

        // 冒泡排序
        for(int i = 0 ; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }*/

        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
