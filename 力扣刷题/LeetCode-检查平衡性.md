---
title: LeetCode-检查平衡性
date: 2020-11-18 20:33:58
tags:
---

# 题目要求

**原题链接**：[面试题 04.04. 检查平衡性](https://leetcode-cn.com/problems/check-balance-lcci/)

实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

**示例 1:**

```
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
```

**示例 2:**

```
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。
```

# 解题过程

```java
class Solution {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        return flag;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftDepth = dfs(root.left) + 1;
        int rightDepth = dfs(root.right) + 1;
        // 在每个节点都判断一下，是否满足要求
        if(Math.abs(leftDepth - rightDepth) > 1){
            flag = false;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
```

