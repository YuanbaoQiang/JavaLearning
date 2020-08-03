---
title: LeetCode-字符串相加
date: 2020-08-03 13:02:17
tags:
- Algorithm
- 字符串
category: LeetCode
mathjax: true
---

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200803132249.jpg)

<!--more-->

# 题目要求

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

> num1 和num2 的长度都小于 5100.
> num1 和num2 都只包含数字 0-9.
> num1 和num2 都不包含任何前导零。
> 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

原题链接：[415. 字符串相加](https://leetcode-cn.com/problems/add-strings/)

# 解题过程

字符串-->字符-->整数型-->字符串

```java
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder(); 
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--){
            int a = (i >= 0) ? num1.charAt(i) - '0' : 0; // 字符型 --> 整型
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0; // 字符型 --> 整型
            int sum = a + b + carry; // 上下两位之和
            sb.append(sum%10); // 余数保留
            carry = sum/10; // 进位数（0 或 1）
        }

        if(carry > 0){ // 判断最后一次相加是否有进位
            sb.append(1);
        }
        return sb.reverse().toString(); // 每次append，都是在后面添加，需要对sb进行反转，然后转换成字符串型
    }
}
```

