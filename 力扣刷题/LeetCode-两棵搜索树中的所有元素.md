---
title: LeetCode-两棵搜索树中的所有元素
date: 2020-11-29 21:45:34
tags:
---

# 题目要求

**原题链接**：[1305. 两棵二叉搜索树中的所有元素](https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/)

给你 `root1` 和 `root2` 这两棵二叉搜索树。

请你返回一个列表，其中包含 **两棵树** 中的所有整数并按 **升序** 排序。

**示例 1：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201129214636.png)

```
输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
```

**示例 2：**

```
输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]
```

**示例 3：**

```
输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]
```

**示例 4：**

```
输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]
```

**示例 5：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201129214731.png)

```
输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]
```

**提示：**

- 每棵树最多有 `5000` 个节点。
- 每个节点的值在 `[-10^5, 10^5]` 之间。

# 解题过程

分别存入两个链表，然后按照元素大小合并两个有序链表。

```java
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        merge(list1, list2, resList);
        return resList;
    }

    // 合并两个有序列表
    public void merge(List<Integer> list1, List<Integer> list2, List<Integer> resList){
        int size1 = list1.size();
        int size2 = list2.size();
        int index1, index2;
        for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2;) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            if (num1 < num2) {
                resList.add(num1);
                index1++;
            } else {
                resList.add(num2);
                index2++;
            }
        }
        while (index1 < size1) {
            resList.add(list1.get(index1++));
        }

        while (index2 < size2) {
            resList.add(list2.get(index2++));
        }
    }

    // 中序遍历
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return;
    }
}
```

