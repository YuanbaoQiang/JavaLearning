package com.yuanbaoqiang.exer;

public class ArrayDemon {
    public static void main(String[] args){ // 19898810207//  1 9 8 0 2 7
        int[] arr = new int[]{9,8,0,2,7,1};
        int[] index = new int[]{5,0,1,0,1,1,5,2,3,2,4};
        String tel = "";
        for (int i = 0; i < index.length; i++) {
            tel += arr[index[i]];

        }
        System.out.println("Á·Ï°·½Ê½£º" + tel);
    }
}
