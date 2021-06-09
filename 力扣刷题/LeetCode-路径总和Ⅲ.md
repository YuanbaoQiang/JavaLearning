---
title: LeetCode-路径总和Ⅲ
date: 2020-11-13 17:34:44
tags:
---

# 题目要求

**原题链接**：[437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

**示例：**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
```



# 解题过程

**双重递归**

```java
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    public void dfs(TreeNode root, int sum){
        if(root == null) return;
        if(root.val == sum){
            count++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
```

