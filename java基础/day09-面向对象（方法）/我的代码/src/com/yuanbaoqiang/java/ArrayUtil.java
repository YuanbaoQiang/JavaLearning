/**
 * <h3>我的代码</h3>
 * <p>自定义数组的工具类</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 08:25
 **/

package com.yuanbaoqiang.java;

public class ArrayUtil {

    // 求数组的最大值
    /**
     * @description: 求数组的最大值
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:38
     * @param arr
     * @return: int
     */
    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }

    // 求数组的最小值
    /**
     * @description: 求数组的最小值
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:38
     * @param arr
     * @return: int
     */
    public int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = arr[i] < min ? arr[i] : min;
        }
        return min;
    }

    // 求数组的总和
    /**
     * @description: 求数组的总和
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:41
     * @param arr
     * @return: int
     */
    public int getSum(int[] arr){
        int sum= 0;

        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        return sum;
    }

    // 求数组的平均值
    /**
     * @description: 求数组的平均数
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:50
     * @param arr
     * @return: double
     */
    public double getAve(int[] arr){
        return getSum(arr) / arr.length;
    }


    // 反转数组
    /**
     * @description: 反转数组
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:53
     * @param arr
     * @return: void
     */
    public void reverse(int[] arr){
        for(int min=0, max=arr.length-1; min < max; min++, max--){
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
    }

    // 复制数组
    /**
     * @description: 复制数组
     * @author: YuanbaoQiang
     * @date: 2020/7/26 18:56
     * @param arr
     * @return: int[]
     */
    public int[] copy(int[] arr){
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }


    // 数组排序
    /**
     * @description: 冒泡排序
     * @author: YuanbaoQiang
     * @date: 2020/7/26 8:59
     * @param arr
     * @return: void
     */
    public void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // 遍历数组
    /**
     * @description: 遍历数组
     * @author: YuanbaoQiang
     * @date: 2020/7/26 18:56
     * @param arr
     * @return: void
     */
    public void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 查找指定元素
    /**
     * @description: 查找指定元素
     * @author: YuanbaoQiang
     * @date: 2020/7/26 9:07
     * @param arr
     * @param dest
     * @return: int
     */
    public int getIndex(int[] arr, int dest){
        // 线性查找
        for (int i = 0; i < arr.length; i++) {
            if(dest == arr[i]){
                return  i;
            }
        }
        return -1; // 返回一个负数，表示没有找到
    }
}
