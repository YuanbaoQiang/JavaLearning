---
title: LeetCode-最大二叉树
date: 2020-11-05 22:00:43
tags:
---

# 1题目要求

**原题链接**：[654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)

**分享一个大佬**：[mata川](https://leetcode-cn.com/u/lyl0724-2/)

给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

**示例 ：**

```
输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
```



# 解题过程

```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }
    
    /* 
        递归三要素：
        1. 终止条件：当l>r，说明数组中已经没有元素了，返回null
        2. 每次递归返回的信息是什么：返回构造好的再打二叉树的root节点
        3. 每次递归干了什么：找到[l,r]区间的最大值作为root节点，将数组分成两段，分别构造root左右节点
    */

    public TreeNode maxTree(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        // cutPoint为当前数组最大值的索引
        int cutPoint = findMaxIndex(nums,l,r);
        TreeNode root = new TreeNode(nums[cutPoint]);
        root.left = maxTree(nums, l, cutPoint - 1);
        root.right = maxTree(nums, cutPoint + 1, r);
        return root;
    }

    // 找出最大值的索引
    public int findMaxIndex(int[] nums, int l, int r){
        int maxIndex = l;
        int maxValue = nums[l];
        for(int i = l; i <= r; i++){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
```

