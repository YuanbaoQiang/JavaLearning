---
title: LeetCode-祖父节点值为偶数的节点和
date: 2020-11-22 19:47:46
tags:
---

# 题目要求

**原题链接**：[1315. 祖父节点值为偶数的节点和](https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/)

给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。

**示例：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201122195006.png)

```
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
```

# 解题过程

```java
class Solution {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        if(root.val%2 == 0){ // 此时节点为偶数，查找符合条件的孙子节点即可
            if(root.left != null){
                if(root.left.left != null){
                    sum += root.left.left.val;
                }

                if(root.left.right != null){
                    sum += root.left.right.val;
                }
            }

            if(root.right != null){
                if(root.right.left != null){
                    sum += root.right.left.val;
                }

                if(root.right.right != null){
                    sum += root.right.right.val;
                }
            }
        }
        dfs(root.left);
        dfs(root.right);
    }
}
```

