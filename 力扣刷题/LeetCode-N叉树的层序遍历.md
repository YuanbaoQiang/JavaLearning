---
title: LeetCode-N叉树的层序遍历
date: 2020-11-26 19:53:59
tags:
---

# 题目要求

**原题链接**：[429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

给定一个 N 叉树，返回其节点值的*层序遍历*。 (即从左到右，逐层遍历)。

例如，给定一个 `3叉树` :

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png)

返回其层序遍历:

```
[
     [1],
     [3,2,4],
     [5,6]
]
```

# 解题过程

```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            for(int i = 0; i < count; i++){
                Node node = queue.poll();
                List<Node> nodeList = node.children;
                list.add(node.val);
                for(Node child : nodeList){
                    queue.offer(child);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
```

