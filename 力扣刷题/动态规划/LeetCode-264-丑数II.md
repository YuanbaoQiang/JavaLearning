# 题目要求

**原题链接**：[264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)

给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。

 

**示例 1**：

```
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
```


**示例 2**：

```
输入：n = 1
输出：1
解释：1 通常被视为丑数。
```

**提示**：

+ `1 <= n <= 1690`

---

# 解题过程

## 代码1

```java
class Solution {
    public int nthUglyNumber(int n) {
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(2 * dp[n2], Math.min(3 * dp[n3], 5 * dp[n5]));
            if(dp[i] == 2 * dp[n2]) n2++;
            if(dp[i] == 3 * dp[n3]) n3++;
            if(dp[i] == 5 * dp[n5]) n5++;
        }
        return dp[n - 1];
    }
}
```

