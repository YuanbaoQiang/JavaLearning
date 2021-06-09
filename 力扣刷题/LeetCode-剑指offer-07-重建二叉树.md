@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/) | [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

难度中等859收藏分享切换为英文接收动态反馈

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

**限制：**

0 <= 节点个数 <= 5000

***

# 解题过程

**详情见本人的lc题解**：[简单理解-递归重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/jian-dan-li-jie-di-gui-zhong-jian-er-cha-ursl/)

<font color=green size=4>递归</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(n)$ | <font color=green>**推荐**</font>

> 时间复杂度：HashMap的遍历存储需要$O(n)$，递归共创建了n个节点，每次递归占用$O(1)$的节点创建开销损耗
>
> 空间复杂度：HashMap占$O(n)$，最差情况，树退化为链表，占用$O(n)$的深度，最好的情况为满二叉树，深度为$o(logn)$

![image-20210205133458565](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205133458565.png)

```java
class Solution {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    // 前序遍历 preorder: 根 -- 左 -- 右   第一个肯定是根节点
    // 中序遍历 inorder: 左 -- 根 -- 右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return rebuild(0, 0, inorder.length - 1);  
    }

    // pre_root_index : 根节点 在 前序遍历中的下标
    // in_left_index: 左节点 在中序遍历中的下标
    // in_right_index: 右节点 在中序遍历中的下标
    public TreeNode rebuild(int pre_root_index, int in_left_index, int in_right_index){
       if(in_left_index > in_right_index)  return null;
       // 根节点在中序遍历中的位置：in_root_index
       int in_root_index = map.get(preorder[pre_root_index]);
       // 创建一个根节点
       TreeNode node = new TreeNode(preorder[pre_root_index]);
       // 寻找node的左节点: 
       // 在前序遍历中的位置就是  根节点的下标 + 1（右边一个单位）
       // 在中序遍历中的位置就是： 1. 左边界不变（因为无法确定），2. 右边界就是根节点的左边一个单位 in_root_index - 1
       node.left = rebuild(pre_root_index + 1, in_left_index, in_root_index - 1);
       // 寻找node的右节点: 
       // 在前序遍历中的位置就是  根节点的下标 + 左子树长度 + 1
       // 在中序遍历中的位置就是： 1. 左边界在根节点的右边一个单位  in_root_index + 1, 2. 右边界无法确定
       node.right = rebuild(pre_root_index + in_root_index - in_left_index + 1, in_root_index + 1, in_right_index);
       return node;
    }
}
```

