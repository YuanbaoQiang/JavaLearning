---
title: LeetCode-最大层内元素和
date: 2020-11-24 23:21:35
tags:
---

# 题目描述

**原题链接**：[1161. 最大层内元素和](https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/)

给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。

请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小的那个。

**示例 1：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201124232652.jpeg)

```
输入：root = [1,7,0,7,-8,null,null]
输出：2
解释：
第 1 层各元素之和为 1，
第 2 层各元素之和为 7 + 0 = 7，
第 3 层各元素之和为 7 + -8 = -1，
所以我们返回第 2 层的层号，它的层内元素之和最大。
```

**示例 2：**

```
输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
输出：2
```

**提示：**

- 树中的节点数介于 `1` 和 `10^4` 之间
- `-10^5 <= node.val <= 10^5`

# 解题过程

```java
class Solution {
    int sum = 0;
    int level = 1;
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        bfs(root);
        // 遍历得到对应的key，即为对应的层数
        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                return key;
            }
        }
        return -1;
    }

    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            map.put(level, sum); // 将level, sum存入到map中
            max = Math.max(max, sum); // 求得最大和
            level++;
            sum = 0;
        }
    }
}
```

