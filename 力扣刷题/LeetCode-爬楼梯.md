@[TOC](目录😁)

***

# 题目要求

**原题链接**：[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

假设你正在爬楼梯。需要 *n* 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

**注意：**给定 *n* 是一个正整数。

**示例 1**：

```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。

1.  1 阶 + 1 阶
2.  2 阶

```

**示例 2**：

```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

***

# 解题过程

<font color=green size=4>动态规划</font>

> 类似的题目
>
> [LeetCode-不同路径](https://blog.csdn.net/qyb19970829/article/details/111998918)
>
> [LeetCode-最小路径和](https://blog.csdn.net/qyb19970829/article/details/111999001)

```java
class Solution {
    public int climbStairs(int n) {
        // dp[i] = dp[i - 1] + dp[i - 2]
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            if(i == 0 || i == 1) dp[i] = 1;
            else dp[i] = dp[i - 1] +dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
```

