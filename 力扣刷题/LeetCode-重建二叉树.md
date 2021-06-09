---
title: LeetCode-重建二叉树
date: 2020-11-06 20:40:41
tags:
---

# 题目要求

**原题链接**：[剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

# 解题过程

**分治**

```java
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder; // 声明一个属性，用来保存前序遍历数组
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,0,preorder.length-1);

    }

    public TreeNode buildTree(
        // 根节点在前序遍历中的索引值
        int root, 
        // 中序遍历的索引
        int left, 
        // 中序遍历的索引
        int right){
        // 如果左边界大于右边界，则递归结束
        if(left > right) return null;
        
        TreeNode node = new TreeNode(preorder[root]);
        // 根据前序遍历的根节点值，在中序遍历中找到对应的索引值
        int i = map.get(preorder[root]); 

        // 此时要寻找左子树的根节点：
        // 左子树的根节点在前序遍历的根节点后一个位置，所以要root+1
        // 而左子树的边界则为:【left,i-1】
        node.left = buildTree(root+1,left,i-1);
        // 此时要寻找右子树的根节点：
        // 右子树的根节点在前序遍历数组中的位置：【当前的节点的位置】加上【左子树节点数量】 + 1
        // 左子树节点数量 = i - left
        // 右子树的边界：【i+1，right】
        node.right = buildTree(root + (i - left) + 1, i + 1, right);
        return node;
    }
}
```

