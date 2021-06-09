---
title: LeetCode-层数最深叶子节点的和
date: 2020-11-07 22:22:34
tags:
---

# 题目要求

**原题链接**：[1302. 层数最深叶子节点的和](https://leetcode-cn.com/problems/deepest-leaves-sum/)

给你一棵二叉树，请你返回层数最深的叶子节点的和。

**示例：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201107222614.png)

```
输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
```

# 解题过程

**BFS (Breadth First Search)**

```java
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            sum = 0;
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }
}
```

