@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/) | [343. 整数拆分](https://leetcode-cn.com/problems/integer-break/)

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

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

2 <= n <= 1000

***

# 解题过程

该题需要在[LeetCode-剑指offer-14-I-剪绳子（记忆化递归、动态规划、数学推导）](https://blog.csdn.net/qyb19970829/article/details/113739157)的基础之上，继续进行操作！

唯一的不同之处在于，本题涉及 **“大数越界的求余问题”** 。

> **大数越界：** 剪绳子问题（不考虑取余）最终的结果是以$3^a$指数级别增长，可能超出 `int32` 甚至 `int64` 的取值范围，导致返回值错误。

<font color=green size=4>动态规划：大数取余</font> | 时间复杂度： $O(n^2)$ | 空间复杂度：$O(n)$ | <font color=red>**不推荐**</font>

> 经典击败5%，同样递归方法也可以用下列的方法，但是开销也会很大！

![image-20210207140145326](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207140145326.png)

```java
import java.math.BigInteger;
class Solution {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
         Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
```

<font color=green size=4>循环取余</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210207143908068](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207143908068.png)

```java
class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }else if(n == 4){
            return n;
        }
        long res = 1;
        while(n > 4){
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        // 最终剩下来的肯定是2,3,4
        return (int) (res * n % 1000000007);
    }
}
```

<font color=green size=4>快速幂解法（最优解）</font> | 时间复杂度：$O(logn)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> **快速幂**部分见我先前的博客记录: [LeetCode-剑指offer-16-数值的整数次方](https://blog.csdn.net/qyb19970829/article/details/113407668)
>
> 快速幂是在循环取余的基础上，进一步降低时间复杂度，因此效率也是很直观的有了提升！

![image-20210207142006395](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210207142006395.png)

```java
class Solution {
    int mod = 1000000007;
    public int cuttingRope(int n) {
        if(n < 4) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if(b == 0) return (int) (myPow(3, a) % mod);
        else if(b == 1) return (int) (myPow(3, a - 1) * 4 % mod);
        else return (int) (myPow(3, a) * 2 % mod);
    }

    public long myPow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }
}
```

