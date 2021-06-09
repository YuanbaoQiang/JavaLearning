---
title: LeetCode-搜索插入位置
date: 2020-12-01 23:38:33
tags:
---

# 题目要求

**原题链接**：[35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

**示例 1**:

```
输入: [1,3,5,6], 5
输出: 2
```


**示例 2**:

```
输入: [1,3,5,6], 2
输出: 1
```


**示例 3**:

```
输入: [1,3,5,6], 7
输出: 4
```


**示例 4**:

```
输入: [1,3,5,6], 0
输出: 0
```

# 解题过程

**二分**

left -------------------------------------mid-----------------------------------------right

left------------------mid---------------right

​						         left----mid----right

....................................

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                // 如果此时中间值小于等于目标值
                // 则说明target在[mid+1, right]区间内
                // 此时需要将左边界修改为此时的mid+1位置
                left = mid + 1;
            }else{
                // 如果中间值大于目标值
                // 则说明该target在[left, mid]区间中
                // 此时需要将右边界修改为此时的mid位置
                right = mid;
            }
        }
        return left;
    }
}
```

