---
title: LeetCode-四数相加Ⅱ
date: 2020-11-27 21:54:53
tags:
---

# 题目要求

**原题链接**：[454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii/)

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -$2^{28}$ 到  $2^{28}$- 1 之间，最终结果不会超过 $2^{31}$ - 1 。

**例如:**

```
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```



# 解题过程

```java
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // 将A、B数组中的和存入map中
        for(int a : A){
            for(int b : B){
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        // 遍历C、D数组中的和情况，map中存在c+d的相反数，则对应的值
        for(int c : C){
            for(int d : D){
                if(map.containsKey(-(c + d))){
                    ans += map.get(-(c + d));
                }
            }
        }
        return ans;
    }
}
```

