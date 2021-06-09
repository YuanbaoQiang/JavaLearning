@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

**示例 1**：

```
输入：m = 2, n = 3, k = 1
输出：3
```

**示例 2**：

```
输入：m = 3, n = 1, k = 0
输出：1
```

**提示**：

- 1 <= n,m <= 100
- 0 <= k <= 20

***

# 解题过程

与[LeetCode-剑指offer-12-矩阵中的路径](https://blog.csdn.net/qyb19970829/article/details/113358518)类似

可参考：[面试题13. 机器人的运动范围（ 回溯算法，DFS / BFS ，清晰图解）](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/)

<font color=green size=4>回溯</font>

```java
class Solution {
    int m, n, k;
    boolean[][] visisted;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visisted = new boolean[m][n];
        return dfs(0, 0);
    }


    public int dfs(int i, int j){
        if(sum(i) + sum(j) > k || i < 0 || i >= m || j < 0 || j >= n || visisted[i][j]){
            return 0;
        }
        visisted[i][j] = true;
        return 1 + dfs(i, j + 1) + dfs(i, j - 1) + dfs(i + 1, j) + dfs(i - 1, j + 1);
    }

    // 求数位之和
    public int sum(int x){
        int s = 0;
        while(x != 0){
            s += x%10;
            x /= 10;
        }
        return s;
    }
}
```

