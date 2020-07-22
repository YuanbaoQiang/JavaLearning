package com.yuanbaoqiang.array;

/*
* 1. 创建一个名为ArrayTest2 的类，在 main() 方法中声明 array1 和array2两个变量， 他们 是int[] 类型的数组
* 2. 使用大括号{}，把array1初始化为8个素数：2，3，5，7，11，13，17，19
* 3. 显示array1的内容
* 4. 赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值（如array[0]=0, array[2]=2） 打印出array1
*
* //  array1和array2的地址值一样
*
* */

public class ArrayTest2 {
    public static void main(String[] args) {
        System.out.println();
        int[] array1, array2;

        array1 = new int[]{2,3,5,7,11,13,17,19};

        // 显示array1的内容
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        // 赋值array2变量等于array1
        array2 = array1;

        // 修改array2中的偶索引元素，使其等于索引值（如array[0]=0, array[2]=2）
        for (int i = 0; i < array2.length; i++) {
            if(i % 2 == 0){
                array2[i] = i;
            }
        }

        // 显示array1的内容
        System.out.println();
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }

    }
}
