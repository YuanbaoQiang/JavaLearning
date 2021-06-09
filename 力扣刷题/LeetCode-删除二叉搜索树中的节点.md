---
title: LeetCode-删除二叉搜索树中的节点
date: 2020-11-03 20:21:15
tags:
---

# 题目要求

**原题链接**：[450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)

给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

**示例**:

```
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
```

# 解题过程

> **博客**：[【最详细的算法视频题解】—— Leetcode 450. 删除二叉搜索树中的节点](https://blog.csdn.net/weixin_42322309/article/details/104350188) 
>
> **官方题解**：[删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/shan-chu-er-cha-sou-suo-shu-zhong-de-jie-dian-by-l/)

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key > root.val){
            // 如果要查找的值大于当前节点，则向右子树查找
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            // 如果要查找的值小于当前节点，则向左子树查找
            root.left = deleteNode(root.left,key);
        }else{ // 如果当前节点为查找值
            if(root.left == null && root.right == null){ // 叶子节点，直接删除
                root = null;
            }else if(root.right != null){ // 如果有右子树，找到右子树中最小的那个数字，并赋值，然后删除
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            }else{ // 如果左子树，找到左子树中最大的那个数字，赋值，然后删除
                root.val = predecessor(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;  
    }

    public int successor(TreeNode root){ // 以root为根节点，找到其右子树的最小值
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }

    public int predecessor(TreeNode root){// 以root为根节点，找到其左子树的最大值
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
```

