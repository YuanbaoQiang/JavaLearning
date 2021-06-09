@[TOC](目录🤞)

***



# 题目要求



**原题链接**：[103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)

给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],

```
    3
   / \
  9  20
    /  \
   15   7
```

返回锯齿形层序遍历如下：

```
[
  [3],
  [20,9],
  [15,7]
]
```

# 解题过程

<font color=green size=5>双端队列</font>

左右横跳系列，最原始的层序遍历可以通过一个单向队列，从一个方向依次弹出。
而锯齿遍历可以通过一个双向队列，对于奇数层和偶数层分类讨论即可。

> **ps**: 如果上一层是从尾端加入的，则这一层就从头部开始弹出。

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null) return resList;
        deque.addLast(root);
        int level = 0;
        while(!deque.isEmpty()){
            int count = deque.size();
            List<Integer> innerList = new LinkedList<>();
            for(int i = 0; i < count; i++){
                // 奇数层
                if(level%2 == 0){
                    TreeNode node = deque.pollFirst();
                    innerList.add(node.val);
                    if(node.left != null) deque.addLast(node.left);
                    if(node.right != null) deque.addLast(node.right);

                }
                // 偶数层
                if(level%2 == 1){
                    TreeNode node = deque.pollLast();
                    innerList.add(node.val);
                    if(node.right != null) deque.addFirst(node.right);
                    if(node.left != null) deque.addFirst(node.left);

                } 
            }
            resList.add(innerList);
            level++;
        }
        return resList;
    }
}
```

