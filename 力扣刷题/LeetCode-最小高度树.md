---
title: LeetCode-最小高度树
date: 2020-11-06 20:47:01
tags:
---

# 题目要求

**原题链接**：[面试题 04.02. 最小高度树](https://leetcode-cn.com/problems/minimum-height-tree-lcci/)

给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

**示例:**

```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 
```



# 解题过程

**分治思想**

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        // 构建左子树
        node.left = helper(nums,left,mid-1);
        // 构建右子树
        node.right = helper(nums,mid+1,right);
        return node;
    }
}
```

