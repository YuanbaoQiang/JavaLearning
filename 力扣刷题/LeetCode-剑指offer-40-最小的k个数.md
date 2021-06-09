@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

**示例 1**：

```
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
```

**示例 2**：

```
输入：arr = [0,1,2,1], k = 1
输出：[0]
```

**限制：**

- `0 <= k <= arr.length <= 10000`
- `0 <= arr[i] <= 10000`

***

# 解题过程

和[LeetCode-数组中的第K个最大元素](https://blog.csdn.net/qyb19970829/article/details/113002352)类似

<font color=green size=4>快速选择</font>

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int left, int right, int k){
        if(left >= right) return;

        int cutPoint = partition(arr, left, right);

        if(cutPoint - left + 1 > k){
            // 第k个数在 left ------ cutPoint区间内
            quickSort(arr, left, cutPoint - 1, k);
        }else if(cutPoint - left + 1 < k){
            // 第k个数在 cutPoint ------ right区间内
            quickSort(arr, cutPoint + 1, right, k - (cutPoint - left + 1));
        }else{
            return;
        }
    }

    public int partition(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int baseValue = arr[left];
        while(i < j){
            while(i < j && arr[j] >= baseValue) j--;
            while(i < j && arr[i] <= baseValue) i++;
            if(i < j) swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

<font color=green size=4>最小堆</font>

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        buildMinHeap(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[0];
            swap(arr, 0, arr.length - 1 - i);
            adjustMinHeap(arr, 0, arr.length - 1 - i);
        }
        return res;

    }

    // 构建小顶堆
    public void buildMinHeap(int[] arr){
        // i
        // 2i+1
        // 2i+2
        int mid = arr.length / 2 - 1;
        for(int i = mid; i > -1; i--){
            adjustMinHeap(arr, i, arr.length);
        }
    }


    // 调整小顶堆
    public void adjustMinHeap(int[] arr, int root, int len){
        int i = root;
        int left = 2*root + 1;
        int right = 2*root + 2;
        
        if(left < len && arr[left] < arr[root]){
            root = left;
        }

        if(right < len && arr[right] < arr[root]){
            root = right;
        }

        if(root != i){
            swap(arr, root, i);
            adjustMinHeap(arr, root, len);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

