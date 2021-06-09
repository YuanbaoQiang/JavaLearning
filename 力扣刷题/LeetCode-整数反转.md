---
title: LeetCode-整数反转
date: 2020-11-26 20:45:33
tags:
---

# 题目要求

**原题链接**：[7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

**示例 1:**

```
输入: 123
输出: 321
```

**示例 2:**

```
输入: -123
输出: -321
```

**示例 3:**

```
输入: 120
输出: 21
```

**注意:**

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−$2^{31}$, $2^{31}$ − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

# 解题过程

```java
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            // 求出个位数的数字
            int pop = x % 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))  return 0;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))  return 0;
            // 在求ans之前，需要判断目前ans的值：
            // 正数判断：
            // 如果ans大于Integer.MAX_VALUE的1/10时，此时也不行，返回0
            // 如果ans等于Integer.MAX_VALUE的1/10时，此时的pop值大于2^31 − 1的个位数7，此时也不行，返回0
            // 负数判断：
            // 如果ans小于Integer.MIN_VALUE的1/10，此时也不行，返回0
            // 如果ans等于Integer.MIM_VALUE的1/10，并且此时的pop值小于-2^31的个位数8，此时也不行，返回0
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }
}
```

