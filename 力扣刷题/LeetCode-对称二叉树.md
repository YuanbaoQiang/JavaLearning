---
title: LeetCode-对称二叉树
date: 2020-08-08 21:17:25
tags:
- Algorithm
- 树结构
category: LeetCode
---





![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200808225506.jpg)

<!--more-->

# 题目要求

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```java
    1
   / \
  2   2
 / \ / \
3  4 4  3
```



但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```java
    1
   / \
  2   2
   \   \
   3    3
```

原题链接：[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

# 解题过程

> 没错！我偷懒了😶

gif出处：[动画演示+多种实现 101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/)

解题思路参考：[递归 & 迭代，🤷‍♀️ 必须秒懂！](https://leetcode-cn.com/problems/symmetric-tree/solution/di-gui-die-dai-bi-xu-miao-dong-by-sweetiee/)、[【101题】对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/solution/101ti-dui-cheng-er-cha-shu-by-iceblood/)

## 递归



![](https://pic.leetcode-cn.com/2449af8862537df2cbbc45a07764415c1a10769677c822fa271ea7447c8fa128-2.gif)

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 根结点为null
        if(root == null){
            return true;
        }
        // 判读左右子树是否对称
        return isMirror(root.left, root.right);

    }

    /*
     * @description: 判断左右子树是否对称（递归法）
     * @author: YuanbaoQiang
     * @date: 2020/8/8 21:26
     * @param node1
     * @param node2
     * @return: boolean
     */
    public boolean isMirror(TreeNode node1, TreeNode node2){
        // 节点都为空，返回true
        if(node1 == null && node1 == null){
            return true;
        }

        // 节点不同：
        // 1. 一个为空，一个不为空
        // 2. 都不为空，但是值不同
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }

        // 判断左右子树是否对称
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

}
```

## 迭代（队列）

![](https://pic.leetcode-cn.com/45a663b08efaa14193d63ef63ae3d1d130807467d13707f584906ad3af4adc36-1.gif)

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            // 每次出队两个节点
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 两个比较节点同时为空，则不需要再比较节点值。
            if(node1 == null && node2 == null){
                continue;
            }

            // 两节点一个为空，一个不为空
            // 两节点不为空，但是值不相同
            if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }

            // 将node1的左节点和node2的右节点一起入队列
            queue.offer(node1.left);
            queue.offer(node2.right);

            // 将node1的右节点和node2的左节点一起入队列
            queue.offer(node1.right);
            queue.offer(node2.left);

        }

        return true;
        
    }
    
}

```

