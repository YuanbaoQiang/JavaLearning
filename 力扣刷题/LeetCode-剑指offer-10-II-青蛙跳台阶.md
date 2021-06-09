@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) | [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1**：

```
输入：n = 2
输出：2
```


**示例 2**：

```
输入：n = 7
输出：21
```


**示例 3**：

```
输入：n = 0
输出：1
```


**提示**：

- 0 <= n <= 100


***

# 解题过程

详细信息可见先前博客记录：[LeetCode-剑指offer-10-I-斐波那契数列（记忆化递归、尾递归、动态规划）](https://blog.csdn.net/qyb19970829/article/details/113706262)

<font color=green size=4>动态规划</font> | 时间复杂度： $O(n)$ | 空间复杂度： $O(1)$ | <font color=green>**推荐**</font>

![image-20210206103106212](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210206103106212.png)

```java
class Solution {
    int mod = 1000000007;
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = (a + b) % mod;
            a = b % mod;
            b = sum % mod;
        }
        return a;
    }
}
```

<font color=green size=4>尾递归</font> | 时间复杂度： $O(n)$ | 空间复杂度： $O(1)$ | <font color=green>**推荐**</font>

![image-20210206103151982](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210206103151982.png)

```java
class Solution {
    int mod = 1000000007;
    public int numWays(int n) {
        return recur(n, 1, 1);
    }

    public int recur(int n, int first, int second){
        if(n < 2) return second;
        return recur(n - 1, second % mod, (first + second) % mod);
    }
}
```

