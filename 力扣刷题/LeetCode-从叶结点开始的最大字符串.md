---
title: LeetCode-从叶结点开始的最大字符串
date: 2020-11-23 23:13:59
tags:
---

# 题目要求

**原题链接**：[988. 从叶结点开始的最小字符串](https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/)

给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。

找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。

（小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）

**示例 1：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201123231805.png)

```
输入：[0,1,2,3,4,3,4]
输出："dba"
```

**示例 2：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201123231811.png)

```
输入：[25,1,3,1,3,0,2]
输出："adz"
```

**示例 3：**

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201123231818.png)

```
输入：[2,2,1,null,1,0,null,0]
输出："abc"
```

**提示：**

1. 给定树的结点数介于 `1` 和 `8500` 之间。
2. 树中的每个结点都有一个介于 `0` 和 `25` 之间的值。

# 解题过程

```java
class Solution {
    String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs("", root);
        return res;
    }

    public void dfs(String str, TreeNode root){
        if(root == null) return;
        str = (char)('a' + root.val) + str;
        if(root.left == null && root.right == null){ // 此时为叶子节点
            if(str.compareTo(res) < 0){
                res = str;
            }
        }else{
            dfs(str, root.left);
            dfs(str, root.right);
        }
    }
}
```

