---
title: LeetCode-二叉树中的列表
date: 2020-11-16 21:59:36
tags:
---

# 题目要求

**原题链接**：[1367. 二叉树中的列表](https://leetcode-cn.com/problems/linked-list-in-binary-tree/)

给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。

如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。

一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。

**示例 1：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201116220048.png)

```
输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true
解释：树中蓝色的节点构成了与链表对应的子路径。
```

**示例 2：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201116220125.png)

```
输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true
```

**示例 3：**

```
输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：false
解释：二叉树中不存在一一对应链表的路径。
```



# 解题过程

```java
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        // 不一样要从根路径开始，所以从root.left或者root.right开始查找也是可以的
        // 只要有一个为true就为true
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean helper(ListNode head, TreeNode root){
        // 特殊条件：如果head为null，说明链表已经遍历完，返回true
        if(head == null) return true;
        // 特殊条件：走到这一步，说明root已经为空，返回false
        if(root == null) return false;
        // 如果链表节点值和当前树的节点值不相同，返回false
        if(head.val != root.val) return false;
        // 同时遍历树的左右节点，只要一个满足条件即可
        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}
```

