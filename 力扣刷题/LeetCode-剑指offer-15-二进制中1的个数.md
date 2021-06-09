@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 15. 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

**示例 1**：

```
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
```

**示例 2**：

```
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
```


**示例 3**：

```
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
```

**提示**：

输入必须是长度为 32 的 二进制串 。

***

# 解题过程

<font color=green size=4>常规思路：每一位都检查</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ 

> 需要每一位都进行检查

![image-20210208114411950](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208114411950.png)

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            // 0 & 1 = 0
            // 1 & 1 = 1
            res += n & 1;
            n >>>= 1;
        }
        return res; 
    }
}
```

<font color=green size=4>n & (n - 1)操作</font> | 时间复杂度：$O(1)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

详细解释见我的博客记录：[位运算—简单理解n&(n-1)操作](https://blog.csdn.net/qyb19970829/article/details/113754418)

> 循环操作只和二进制数中1的个数有关，时间复杂度为$O(1)$
>
> 但最差情况，如果每一位都是1，时间复杂度将退化到$O(n)$

![image-20210208114448367](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208114448367.png)

```java
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
```

