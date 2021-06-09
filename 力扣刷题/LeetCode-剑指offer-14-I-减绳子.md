@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/) | [343. 整数拆分](https://leetcode-cn.com/problems/integer-break/)

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

**示例 1**：

```
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
```


**示例 2**:

```
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```

**提示**：

2 <= n <= 58

***

# 解题过程

该题的解决过程，大致思路和先前博客：[LeetCode-剑指offer-10-I-斐波那契数列（记忆化递归、尾递归、动态规划）](https://blog.csdn.net/qyb19970829/article/details/113706262)、[LeetCode-剑指offer-10-II-青蛙跳台阶](https://blog.csdn.net/qyb19970829/article/details/113715004)相同，涉及到传统递归的重复节点计算以及如何实现记忆化。

<font color=green size=4>传统递归</font> | 时间复杂度：$O(2^n)$| 空间复杂度：$O(2^n)$ | <font color=red>**不推荐**</font>

![image-20210207104258916](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207104258916.png)

![剑指offer-14-I-剪绳子01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-14-I-%E5%89%AA%E7%BB%B3%E5%AD%9001.jpeg)

```java
class Solution {
    public int cuttingRope(int n) {
        if(n <= 2) return 1;
        int res = 0;
        for(int i = 1; i < n; i++){
            // i * cuttingRope(n - i) ： 得到长度为i的绳子后，还要对长度为n-i的绳子继续减
            // i * (n - i) 将绳子剪成两端，一段长度为i,另一段长度为n - i,并且不再继续往下减
            res = Math.max(res, Math.max(i * cuttingRope(n - i), i * (n - i)));
        }
        return res;
    }
}
```

<font color=green size=4>记忆化递归</font> | 时间复杂度：$O(2^n)$| 空间复杂度：$O(n)$ | <font color=red>**推荐**</font>

> 只需要在传统递归的基础上，额外设置一个存储节点值的空间（数组和哈希表均可），一个节点完全搜索完，就将该值添加在备忘录中。



![image-20210207105037638](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207105037638.png)

```java
class Solution {
    int res = 0;
    public int cuttingRope(int n) {
        return recur(n, new HashMap<Integer, Integer>());
    }

    public int recur(int n, HashMap<Integer, Integer> map){
        if(n <= 2) return 1;
        if(map.containsKey(n)) return map.get(n);
        for(int i = 1; i < n; i++){
            res = Math.max(res, Math.max(i * recur(n - i, map), i * (n - i)));
        }
        // 每次得到一个结果时，都需要将结果存储到对应的节点中
        map.put(n, res);
        return res;
    }
}
```

<font color=green size=4>动态规划</font> | 时间复杂度： $O(n^2)$ | 空间复杂度：$O(n)$ | <font color=green>**推荐**</font>

![image-20210207123241955](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207123241955.png)

```java
class Solution {
    public int cuttingRope(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
        // i: 代表长度为i的一段绳子
       for(int i = 2; i < n + 1; i++){
           // j: 代表在i长度绳子的基础上，开始剪，所以范围是 [1, n - 1];
           for(int j = 1; j < i; j++){
               // j * (i - j)：将绳子剪成两段，一段为j, 一段为i - j
               // j * dp[i - j]：将绳子剪成至少两段：第一段为j，dp[i - j]代表可能还要继续剪 ,即绳子初始长度为 i - j。
               dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
           }
       }
       return dp[n];
    }
}
```

以上方法的时间效率并不是最高，因此以上的方法并不是解决这道题的最好方式，但是是最成熟的，最容易想到的！

****

本题最佳解决方式是通过数学推导的方式找规律（谁想得到呢:D），详细过程不在本文推导，各位可以参考Krahets的题解：[面试题14- I. 剪绳子（数学推导 / 贪心思想，清晰图解）](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/)

**最终得出的结论**：

- **推论一：** 将绳子 **以相等的长度等分为多段** ，得到的乘积最大。
- **推论二：** 尽可能将绳子以长度 3 等分为多段时，乘积最大。

**切分规则**：

- 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
- 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
- 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 +1 替换为 2 + 2，因为 $2 \times 2$ > 3 × 1。

时间复杂度：$O(n)$，空间复杂度：$O(1)$

![image-20210207123349636](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207123349636.png)

```java
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
```

或者还可以写成这样，省去了调用Math库的时间开销，效率更高！

![image-20210207133743561](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207133743561.png)

```java
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        else if(n == 4) return n;
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        } // 跳出while循环的时候，n只能为2，3，4，和上述的切分规则一致
        res = res * n;
        return res;
    }
}
```



评论区翻到的找规律：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/comments/

```java
class Solution {
public:
    void dfs(int n, long sum, long multi, long& ans) {
        if (sum == n) {
            ans = max(ans, multi);
            return;
        } else if (sum > n) {
            return;
        }
        for (long i = 1; i < n; i++) {
            dfs(n, i+sum, i*multi, ans);
        }
        return;
    }

    int cuttingRope(int n) {
        long ans = 0;
        dfs(n, 0, 1, ans);
        return ans;
    }
};

//--->
n     乘积     子数字
2       1       1 1
3       2       1 2
4       4       2 2
5       6       2 3
6       9       3 3
7       12      2 2 3
8       18      2 3 3
9       27      3 3 3
10      36      2 2 3 3
11      54      2 3 3 3
12      81      3 3 3 3
13      108     2 2 3 3 3
14      162     2 3 3 3 3
15      243     3 3 3 3 3
16      324     2 2 3 3 3 3
17      486     2 3 3 3 3 3
18      729     3 3 3 3 3 3
19      972     2 2 3 3 3 3 3
20      1458    2 3 3 3 3 3 3
21      2187    3 3 3 3 3 3 3
22      2916    2 2 3 3 3 3 3 3
23      4374    2 3 3 3 3 3 3 3
24      6561    3 3 3 3 3 3 3 3
25      8748    2 2 3 3 3 3 3 3 3
26      13122   2 3 3 3 3 3 3 3 3
27      19683   3 3 3 3 3 3 3 3 3
28      26244   2 2 3 3 3 3 3 3 3 3
29      39366   2 3 3 3 3 3 3 3 3 3
```

