[TOC](目录)

***

# 题目要求

**原题链接**：[189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

**示例 1**:

```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```


**示例 2**:

```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```


**说明**:

- 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
- 要求使用空间复杂度为 O(1) 的 原地 算法。

***

# 解题过程

<font color=green size=4>反转数组</font>

```java
class Solution {
    public void rotate(int[] nums, int k) {
        // 1，2，3，4，5，6，7     k = 3
        // 如果 k = nums.length 则旋转后的数组和原数组相同
        // 所以需要取模
        k %= nums.length;
        // 7，6，5，4，3，2，1
        reverse(nums, 0, nums.length - 1);
        // 5，6，7，4，3，2，1
        reverse(nums, 0, k - 1);
        // 5，6，7，1，2，3，4
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

