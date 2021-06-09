---
title: LeetCode-有效的山脉数组
date: 2020-11-03 20:26:42
tags:
---

# 题目要求

**原题链接**：[941. 有效的山脉数组](https://leetcode-cn.com/problems/valid-mountain-array/)

给定一个整数数组 `A`，如果它是有效的山脉数组就返回 `true`，否则返回 `false`。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

- A.length >= 3
- 在 0 < i < A.length - 1 条件下，存在 i 使得：
- A[0] < A[1] < ... A[i-1] < A[i]
- A[i] > A[i+1] > ... > A[A.length - 1]

![](https://assets.leetcode.com/uploads/2019/10/20/hint_valid_mountain_array.png)

**示例 1：**

```
输入：[2,1]
输出：false
```

**示例 2：**

```
输入：[3,5,5]
输出：false
```

**示例 3：**

```
输入：[0,3,2,1]
输出：true
```

# 解题过程

**循环**

```java
class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        int i = 1;
        // 找到数组中的峰值处
        while(A[i] > A[i-1]){
            i++;
            if(i == A.length) return false;
        } 
        // 找到峰值初，进行判断
        for(int j = i - 1; j < A.length-1; j++){
            if(A[j] <= A[j+1]){
                return false;
            }
        }
        return A[0] < A[1]; // 最后判断第一个元素是否大于第二个元素，因为上述代码没有考虑此条件
    }
}
```

**双指针**

```java
class Solution {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        while(left < len - 1 && A[left] < A[left+1]) left++;
        while(right > 0 && A[right-1] > A[right]) right--;
        return left < len - 1 && right > 0 && left == right;
    }
}
```

