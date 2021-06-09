---
title: LeetCode-在每个树行中找最大值
date: 2020-11-25 23:32:03
tags:
---

# 题目要求

**原题链接**：[515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)

您需要在二叉树的每一行中找到最大的值。

**示例：**

输入：

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]

# 解题过程

**bfs**

```java
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        int maxOfEachLevel = Integer.MIN_VALUE;
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                maxOfEachLevel = Math.max(maxOfEachLevel, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            resList.add(maxOfEachLevel);
            maxOfEachLevel = Integer.MIN_VALUE;
        }
        return resList;    
    }
}
```

**dfs**

```java
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        dfs(root, resList, 0);
        return resList;
    }


    public void dfs(TreeNode root, List<Integer> resList, int curLevel){
        if(root == null) return;
        // 如果当前的层数大于或者等于当前的列表的元素数量
        if(curLevel >= resList.size()){
            resList.add(root.val);
        }else{
            // 如果当前的列表个数和当前的层数相同
            // 说明此时需要比较当前的root值，和列表中层数对应的值
            int maxOfEachLevel = Math.max(resList.get(curLevel), root.val);
            resList.set(curLevel, maxOfEachLevel);
        }
        dfs(root.left, resList, curLevel+1);
        dfs(root.right, resList, curLevel+1);
        return;
    }
}
```