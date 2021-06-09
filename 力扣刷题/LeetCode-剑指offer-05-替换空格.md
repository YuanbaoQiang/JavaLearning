@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。

**示例 1：**

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

**限制：**

0 <= s 的长度 <= 10000

***

# 解题过程

<font color=green size=4>StringBuilder逐一添加元素</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(n)$ | <font color=green> **推荐**</font>

> 

![image-20210204203311026](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210204203311026.png)

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```