---
title: LeetCode-二叉树的所有路径
date: 2020-11-22 19:53:19
tags:
---

# 题目要求

**原题链接**：[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

给定一个二叉树，返回所有从根节点到叶子节点的路径。

**说明:** 叶子节点是指没有子节点的节点。

**示例:**

```
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```



# 解题过程

```java
class Solution {
    List<String> list= new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;
    }

    public void dfs(TreeNode root, String path){
        // 边界条件
        if(root == null) return;
        path += root.val;
        if(root.left == null && root.right == null){// 此时为叶子节点
            list.add(path);
        }else{
            path += "->";
            dfs(root.left, path);
            dfs(root.right, path);
        }
        return;
    }
}
```

