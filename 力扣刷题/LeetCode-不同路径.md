@[TOC](目录😏)

***

# 题目要求

**原题链接**：[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。问总共有多少条不同的路径？

**示例 1：**

![](https://i.loli.net/2020/12/30/kiOoQW1jC8zuYLZ.png)

```
输入：m = 3, n = 7
输出：28
```

**示例 2**：

```
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。

1. 向右 -> 向右 -> 向下

2. 向右 -> 向下 -> 向右

3. 向下 -> 向右 -> 向右
```

**示例 3**：

```
输入：m = 7, n = 3
输出：28
```

**示例 4**：

```
输入：m = 3, n = 3
输出：6
```

**提示**：

- 1 <= m, n <= 100
- 题目数据保证答案小于等于$2 \times 10^9$

# 解题过程

<font color=green size=4>动态规划</font>

首先找到转移方程，对于上边界和左边界，都只有一种

其余的坐标点的路径数量满足转移方程`dp[i][j] = dp[i - 1][j] + dp[i][j - 1]`

可以参考：[动态规划](https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 边界都是1
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int i = 0; i < n; i++) dp[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // 转移方程
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

