@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/) | [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/) 

> 如果是大数可以参考：[LeetCode-剑指offer-14-II-剪绳子（大数取余、动态规划、循环取余、快速幂）](https://blog.csdn.net/qyb19970829/article/details/113741109)

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

**示例 1**:

```
输入: 2.00000, 10
输出: 1024.00000
```

**示例 2**:

```
输入: 2.10000, 3
输出: 9.26100
```

**示例 3**:

```
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```

**说明**:

- -100.0 < x < 100.0
- n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

***

# 解题过程

<font color=green size=4>快速幂</font> | 时间复杂度：$O(logn)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210208121432703](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208121432703.png)

详细可参考：[快速幂讲解](https://www.cnblogs.com/CXCXCXC/p/4641812.html)

比如要求$x^{11}$，正常的乘积需要循环乘11次，时间复杂度为`O(n)`

快速幂的思想就是将指数11 可以转成二进制数1011，则原来的式子可以转化成$x^{11} = x^{2^{3} + 2^{1} + 2^{0}} = x^{2^{3}} \times x^{2^{1}} \times x^{2^{0}}$，此时指运算了3次乘积，时间复杂度降至`O(logn)`

下方代码中的`x *= x`是一个累乘的过程，得到四位的二进制数，对应的四个权重，$x$，$x *= x$，$x^2 \ *= x^2$，$x^4 \ *= x^4$

1011二进制数，从右至左分别为1 1 0 1 ，只有在1的位置上，才有相应的权重，通过与运算：`(b & 1) == 1`判断最后一位是否为1。

$x ---> x^{2^{0}}$ --------->    1

$x^2 ---> x^{2^{1}}$ ------------->  1

$x^4 ---> x^{2^{2}}$  ----------------->  0

$x^8 ---> x^{2^{3}}$  -----------------------> 1

```java
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0){
            // 此时b的最低位为1（也可以理解为b为偶数）
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
```

