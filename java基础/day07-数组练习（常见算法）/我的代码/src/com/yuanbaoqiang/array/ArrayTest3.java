package com.yuanbaoqiang.array;

/*array1和array2的复制*/

public class ArrayTest3 {
    public static void main(String[] args) {
        System.out.println();
        int[] array1, array2;

        array1 = new int[]{2,3,5,7,11,13,17,19};

        // 显示array1的内容
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        // 复制array2变量等于array1
        array2 = new int[array1.length];

        // 修改array2中的偶索引元素，使其等于索引值（如array[0]=0, array[2]=2）
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[i];
        }

        // 显示array1的内容
        System.out.println();
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }

    }
}
