package com.yuanbaoqiang.array;

public class ArrayTest4 {
    public static void main(String[] args){
        String[] arr = new String[]{"JJ","DD","MM","BB","GG","CC"};

        // 数组的复制  区别于 赋值
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
            System.out.print(arr1[i] + " ");
        }

        // 数组的反转
        String temp;
        for (int min = 0, max = arr1.length-1; min < max; min++, max--) {
            temp = arr1[min];
            arr1[min] = arr1[max];
            arr1[max] = temp;
        }

        // 遍历
        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }


        }


}
