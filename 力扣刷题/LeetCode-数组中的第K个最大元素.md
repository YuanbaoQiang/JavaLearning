@[TOC](目录)

***

# 题目要求

原题链接：[215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

在未排序的数组中找到第 **k** 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

**示例 1**:

```
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```


**示例 2**:

```
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

***

# 解题过程

> 十大排序算法可参考：[十大排序算法—这一篇远远不够](https://blog.csdn.net/qyb19970829/article/details/112971465)
>
> TopK问题可参考：[Top K问题的两种解决思路](https://www.cnblogs.com/en-heng/p/6336625.html)

<font color=green size=4>大顶堆</font>

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return selectTopK(nums, k);
    }

    public static int selectTopK(int[] arr, int k){
        // 构建一个大顶堆
        buildMaxHeap(arr);
        // 如果K大于数组的长度
        if(k >= arr.length){
            k = arr.length;
        }
        // 对于选择前K个最大的数，则遍历K个循环就可以将大顶堆的元素换到数组的最后一个位置
        for(int i = 0; i < k; i++){
            // 将大顶堆堆顶元素与最后一个数组元素交换，完成下沉操作
            ex(arr, 0, arr.length - 1 - i);
            // 调整大顶堆
            adjustMaxHeap(arr, 0, arr.length - 1 - i);
        }

        return arr[arr.length - k];
    }


    /*
     * @description: 构建一个大顶堆
     * @author: yuanbaoqiang
     * @date: 2021/1/22 下午1:28
     * @param: arr
     * @return: void
    */
    public static void buildMaxHeap(int arr[]){
        // i, 2i + 2 < len  ---->  i < (len - 2) / 2
        int mid = (arr.length - 2) / 2;
        for(int i = mid; i > -1; i--){
            adjustMaxHeap(arr, i, arr.length);
        }
    }

    /*
     * @description: 调整大顶堆
     * @author: yuanbaoqiang
     * @date: 2021/1/22 下午7:45
     * @param: arr
     * @param: root
     * @param: len
     * @return: void
    */
    public static void adjustMaxHeap(int[] arr, int root, int len){
        int initialValue = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // 大顶堆
        if(left < len && arr[left] > arr[root]){
            root = left;
        }
        if(right < len && arr[right] > arr[root]){
            root = right;
        }

        // 小顶堆
        /*if(left < len && arr[left] < arr[root]){
            root = left;
        }
        if(right < len && arr[right] < arr[root]){
            root = right;
        }*/

        if(root != initialValue){
            ex(arr, root, initialValue);
            adjustMaxHeap(arr, root, len);
        }
    }


    public static void ex(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

<font color=green size=4>Quick Sort</font>

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int quickSelect(int[] arr, int left, int right, int k){
        if(left >= right) return arr[right];
        int cutPoint = partition(arr, left, right);
        if(cutPoint - left + 1 > k) return quickSelect(arr, left, cutPoint - 1, k);
        else if(cutPoint - left + 1 == k) return arr[cutPoint];
        else return quickSelect(arr, cutPoint + 1, right, k - (cutPoint - left + 1));
    }

    public static int partition(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int baseValue = arr[left];
        while(i < j){
            while(i < j && arr[j] <= baseValue) j--;
            while(i < j && arr[i] >= baseValue) i++;
            if(i < j) ex(arr, i, j);
        }
        ex(arr, left, i);
        return i;
    }

    public static void ex(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

