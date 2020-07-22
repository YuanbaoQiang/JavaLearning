package com.yuanbaoqiang.array;

/*
* 查找（或搜索）
* 线性查找：
* */

public class ArraySearch01 {
    public static void main(String[] args) {

        // 查找（或搜索）
        // 线性查找：
        String dest = "BB";
        boolean isFalse = true;

        String[] arr = new String[]{"JJ","DD","MM","BB","GG","CC"};
        for (int i = 0; i < arr.length; i++) {

            if(dest.equals(arr[i])){
                System.out.println("找到了指定的元素，位置为：" + i);
                isFalse = false;
                break;
            }
        }
        if(isFalse){
            System.out.println("很遗憾，没有找到哦！");

        }

        // 二分法查找
        // 前提：所要查找的数组必须有序
        int[] arr2 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
        int dest1 = 334;
        int head = 0; // 初始的首索引
        int end = arr.length-1; // 初始的末索引
        boolean isFalse1 = true;
        while(head <= end){
            int middle = (head + end)/2;
            if(dest1 == arr2[middle]){
                System.out.println("找到了指定的元素，位置为：" + middle);
                isFalse1 = false;
                break;
            }else if(arr2[middle]>dest1){
                end = middle - 1;
            }else{// arr2[middle]<dest1
                head = middle +1;
            }
        }

        if(isFalse1){
            System.out.println("很遗憾 没有找到");
        }




    }



}
