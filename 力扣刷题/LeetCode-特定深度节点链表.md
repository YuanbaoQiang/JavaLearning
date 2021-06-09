---
title: LeetCode-特定深度节点链表
date: 2020-10-28 21:53:52
tags:
---

# 题目要求

**原题链接**：[面试题 04.03. 特定深度节点链表](https://leetcode-cn.com/problems/list-of-depth-lcci/)

给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 `D`，则会创建出 `D` 个链表）。返回一个包含所有深度的链表的数组。

 **示例：**

```
输入：[1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
```

# 解题过程

**层序遍历**

```java
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return null;
        ListNode[] res = new ListNode[getDepth(tree)];
        int j = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            int count = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            ListNode head = new ListNode(0);
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                cur = cur.next;
            }
            res[j] = dummy.next;
            j++;
        }
        return res;
    }

    // 先求出二叉树的深度
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
}
```

