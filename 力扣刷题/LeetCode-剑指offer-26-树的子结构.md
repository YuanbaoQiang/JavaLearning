@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:

给定的树 A:

```
   3
  / \
  4  5
 / \
 1  2
```


给定的树 B：

```
   4 
  /
 1
```


返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

**示例 1**：

```
输入：A = [1,2,3], B = [3,1]
输出：false
```


**示例 2**：

```
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```


**限制**：

- 0 <= 节点个数 <= 10000

***

# 解题过程

<font color=green size=4>两层递归</font>

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        // recur(A, B)   ---->   判断以A为根节点  和  以B为根节点的两个树  是否匹配
    }

    public boolean recur(TreeNode A, TreeNode B){
        // B为空 说明B已经顺利的遍历完了  此时是匹配的
        if(B == null) return true;
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是A的子结构，直接返回false
        if(A == null || A.val != B .val) return false;
        // 继续遍历左右子节点
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
```

