

@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

镜像输出：

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**示例 1**：

```
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```

***

# 解题过程

<font color=green size=4>递归</font> | 时间复杂度： $O(n)$ | 空间复杂度：$O(n)$

> 树的每个节点都需要遍历，所以时间复杂度为O(n)
>
> 如果树退化成链表，则递归深度为n

![image-20210211160356756](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210211160356756.png)

![LeetCode-剑指offer-27-二叉树的镜像01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/LeetCode-%E5%89%91%E6%8C%87offer-27-%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%95%9C%E5%83%8F01.jpeg)

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        // 保存当前的左节点
        TreeNode temp = root.left;
        // 向右深搜
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
```

<font color=green size=4>辅助栈</font> | 时间复杂度： $O(n)$ | 空间复杂度：$O(n)$

![image-20210211160321233](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210211160321233.png)

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
```

