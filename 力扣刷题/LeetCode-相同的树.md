---
title: LeetCode-相同的树
date: 2020-08-07 18:42:15
tags:
- Algorithm
- 树结构
category: LeetCode
---

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200807185045.jpg)

<!--more-->

# 题目要求

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

```
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
```

原题链接：[100. 相同的树](https://leetcode-cn.com/problems/same-tree/)

# 解题思路

1. 两个二叉树全为null：true
2. 分支一个为空，一个不为空：false
3. 所在位置的之不同：false
4. 递归判断其左子树和右子树

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
            }
        if((p == null && q!= null) || (p != null && q == null) || (p.val != q.val)) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
```

