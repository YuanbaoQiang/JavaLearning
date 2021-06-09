---
title: LeetCode-二叉树展开为链表
date: 2020-11-01 23:27:12
tags:
---

# 题目要求

**原题链接**：[114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)

给定一个二叉树，[原地](https://baike.baidu.com/item/原地算法/8010757)将它展开为一个单链表。

例如，给定二叉树

```
    1
   / \
  2   5
 / \   \
3   4   6
```

将其展开为：

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

# 解题过程

**前序**：

```java
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        // 将左子树转换为链表
        flatten(root.left);
        // 将右子树转换为链表
        flatten(root.right);
        // 以下都为本次递归实现的功能；
        // 保存root 的左子树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = temp;
    }
}
```

**后序**：

```java
class Solution {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        // 后序输出：6,5,4,3,2,1
        // 第一次root是6，则6.right = pre, 6.left = null, pre = root
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
```

