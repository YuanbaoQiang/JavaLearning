---
title: LeetCode-替换空格
date: 2020-08-05 16:07:54
tags:
- Algorithm
- 字符串
category: LeetCode
---

# 题目要求

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。

示例：

> 输入：s = "We are happy."
> 输出："We%20are%20happy."

原题链接：[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

<!--more-->

# 解题过程

这个比较简单欸✌

## StringBuilder

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
```

## 直接调用API

```java
class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
```

