---
title: LeetCode-二叉树简单题（9月27日更新）
date: 2020-09-27 09:30:50
tags:
---

# 二叉树遍历相关

## 前序、中序、后序遍历

[二叉树前序-中序-后序遍历（递归、栈结构）](https://blog.csdn.net/qyb19970829/article/details/108013252)

## 层序遍历

![image-20200927143136257](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20200927143136257.png)



## [606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

**示例 1:**

```
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
```

**示例 2:**

```
输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
```

**解题过程**

```java
class Solution {
    public String tree2str(TreeNode t) {
        String str = "";
        if(t == null) return str;
        // 建一个栈  同时存放字符串和TreeNode
        Stack<Object> stack = new Stack<>();
        stack.push(t);
        while(!stack.isEmpty()){
            Object ele = stack.pop();
            // 如果ele是TreeNode的实例
            if(ele instanceof TreeNode){
                TreeNode node = (TreeNode) ele;
                str += node.val;
                // 判断右子树
                if(node.right != null){
                    stack.push(")");
                    stack.push(node.right);
                    stack.push("(");
                }

                // 判断左子树
                if(node.left != null){
                    stack.push(")");
                    stack.push(node.left);
                    stack.push("(");
                }

                //  判断特殊条件
                if(node.left == null && node.right != null) str += "()";
            }else str += ele;  // 如果ele是字符串类型
            
        }
        return str;
    }
}
```



## [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

给定一个 N 叉树，返回其节点值的*前序遍历*。

例如，给定一个 `3叉树` :

<img src="https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/narytreeexample.png" style="zoom:50%;" />

返回其前序遍历: `[1,3,5,6,2,4]`。

**解题过程**

递归

```java
class Solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        nPreOrder(root);
        return list;
    }

    public void nPreOrder(Node root){
        if(root == null) return;
        //  添加root值
        list.add(root.val);
        // 每一个child节点都开启递归
        for(Node node : root.children) nPreOrder(node);
        return;
    }
}
```

非递归

```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return list; //  节点为空的情况
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            // 注意前序遍历  使用栈  需要从右向左压栈
            // children是个集合对象 可以使用size() get()等命令
            int count = node.children.size();
            for(int i = count - 1; i > -1; i--) stack.push(node.children.get(i));
        }
        return list;

    }
}
```





## [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

**题目要求**

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
 给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

**解题过程**

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        if(root == null) return resList; //  节点数为0的情况
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // 每次都要新建一个空的内层List集合
            List<Integer> innerList = new LinkedList<>();
            // 记录此时stack中的节点数量  即二叉树每层的节点数
            int count = queue.size(); 
            // 将每层的节点全都poll出
            for(int i = 0; i < count; i++){ 
                TreeNode node = queue.poll();
                // 加入innerList中
                innerList.add(node.val);
                //  若root不为叶子节点，则需要将其左右子树节点加入到队列
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            // 加入到innerList中
            resList.add(innerList);
        }
        return resList;
    }
}
```



## [897. 递增顺序查找树](https://leetcode-cn.com/problems/increasing-order-search-tree/)

给你一个树，请你 **按中序遍历** 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

 **示例 ：**

```
输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
```

**解题过程**

```java
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        List<Integer> list = new LinkedList<>();
        inOrder(root,list);
        // 遍历中序遍历的升序集合，将节点添加至结果节点的右子树
        for(int data : list){
            cur.right = new TreeNode(data);
            cur = cur.right;
        }
        return res.right;
    }

    // 中序递归遍历 得到遍历的集合
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
```

## [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
 给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

**解题过程**



## [107. 二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)

给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其自底向上的层次遍历为：

```
[
  [15,7],
  [9,20],
  [3]
]
```

**解题过程**

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        if(root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> innerList = new LinkedList<>();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            resList.add(0,innerList);
        }
        return resList;
    }
}
```



# 二叉树的高度相关

## [剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

**解题过程**

```java
class Solution {
    public int maxDepth(TreeNode root) {
        // 终止条件
        if(root == null) return 0;
        // 此次递归的目的
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //  返回的值
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```

## [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

> 一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过1。

**示例 1:**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

**示例 2:**

给定二叉树 `[1,2,2,3,3,null,null,4,4]`

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

返回 `false` 。

**解题过程**

```java
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode root){
        // 边界条件  root == null  
        if(root == null) return 0;
        // 开启递归
        int leftDepth = getDepth(root.left) + 1; // 左子树
        int rightDepth = getDepth(root.right) + 1;  // 右子树
        if(Math.abs(leftDepth - rightDepth) > 1) flag = false; // 左子树和右子树的高度差绝对值大于1, flag置为false
        return Math.max(leftDepth,rightDepth); // 返回整个二叉树的深度
    }
}
```



# 二叉搜索树相关

## [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

返回 `true`, 因为存在目标和为 22 的根节点到叶子节点的路径 `5->4->11->2`。

**解题过程**

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 调用方法即可
        return hasSum(root,0,sum);
    }

    public boolean hasSum(TreeNode root, int curSum, int sum){
        /*
        root: 遍历的节点
        curSum: 记录每次到达叶子节点的路径和，不能设置为全局变量，必须作为形参传入
                第一次传入的初始值为0
        sum:  目标路径和的值
        */

        // 1.1 终止条件1  无节点  返回false
        if(root == null) return false;

        // 2. 本次递归的目的：  求出root节点下的路径和
        curSum += root.val;

        // 1.2  终止条件2： 此时root为叶子节点 结束递归 
        // 此时应该判断最终的结果了
        if(root.left == null && root.right == null) return curSum == sum;

        // 3. 开启递归
        // 注意此时开启一个递归方向即可，所以两个方向为或的关系
        // 只要有一个方向  满足条件  即为真
        return hasSum(root.left,curSum,sum) || hasSum(root.right,curSum,sum);
    }
}
```



## [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

**示例 1：**

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

**示例 2：**

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

**解题过程**

递归

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode root1, TreeNode root2){
        // 边界条件
        // 两个必须同时为null  才可以返回true 
        if(root1 == null && root2 == null) return true; // 遍历结束
        // 一个为null  一个不为null
        if(root1 == null || root2 == null) return false; //  中途return false
        // 同时开启左右递归
        // 左右  右左  传参
        //  同时也要保证  每次遍历的两个节点值要相同
        return root1.val == root2.val && helper(root1.left,root2.right) && helper(root1.right,root2.left);
    }
}
```

非递归

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 两个都为空的时候    
            if(node1 == null && node2 == null) continue;

            // 一个为空  一个不为空
            // 或
            // 两个值不相同
            if(node1 == null || node2 == null || node1.val != node2.val) return false;

            // 左右
            queue.offer(node1.left);
            queue.offer(node2.right);

            // 右左
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
```

## [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

**示例 1:**

```
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
```

**注意:** 合并必须从两个树的根节点开始。

**解题过程**

```java
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 终止条件
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        // 两个节点都不为null的时候
        /*
                root
               /   \ 
       root.left   root.right  
        
        新建一个root节点  此时的root节点值为  t1  t2 值之和
        root.left --> root的左子树
        root.right --> root的右子树
        */
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
```

## [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

翻转一棵二叉树。

**示例：**

输入：

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**解题过程**

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = helper(stack.pop());
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return root;
    }
    
    // 翻转两个节点
    public TreeNode helper(TreeNode root){
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        return root;
    }
}
```

## [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

<img src="https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/binarysearchtree_improved.png" style="zoom:150%;" />

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

**示例 2:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

**解题过程**

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            // 如果p 和 q都小于root，则说明p和q都在root的左子树中
            if(p.val < root.val && q.val < root.val) root = root.left;
            // 如果p 和 q都大于root，则说明p和q都在root的右子树中
            else if(p.val > root.val && q.val > root.val) root = root.right;
            // 否则p和q在root的左右两侧，root则为最近的公共祖先
            else break;
        }
        return root;
    }
}
```



## [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

**示例 1:**

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

**示例 2:**

```
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
```

**示例 3:**

```
输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false
```

**解题过程**

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 递归终止条件
        // 条件1  两个同时为 null 时  返回  ture
        if(p == null && q == null) return true;
        // 条件2  有一个为null  时  此时返回false
        if(p == null || q == null) return false;
        // 条件3： 如果两个值不相同  则返回false
        if(p.val != q.val) return false;
        // 开启递归
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
```

## [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)

给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

**示例：**

```
输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
```

**解题过程**

```java
class Solution {
    private TreeNode pre = null; // 记录前一个遍历的节点
    int min = Integer.MAX_VALUE; // 最小值
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    //  递归中序遍历
    public void inOrder(TreeNode root){
        // 边界条件
        if(root == null) return;
        inOrder(root.left);
        if(pre != null) min = Math.min(min,Math.abs(root.val - pre.val));
        pre = root;  // pre为前一个节点
        inOrder(root.right);
        return;
    }
}
```

## [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)

计算给定二叉树的所

有左叶子之和。

**示例：**

```
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
```

**解题过程**

```java
class Solution {
    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        // 边界条件
        if(root == null) return 0;
        // 左叶子节点
        if(root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;
        // 开启左右递归
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;
    }
}
```

## [965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree/)

如果二叉树每个节点都具有相同的值，那么该二叉树就是*单值*二叉树。

只有给定的树是单值二叉树时，才返回 `true`；否则返回 `false`。

**示例 1：**

<img src="https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/screen-shot-2018-12-25-at-50104-pm.png" style="zoom: 33%;" />

```
输入：[1,1,1,1,1,null,1]
输出：true
```

**示例 2：**

<img src="https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/screen-shot-2018-12-25-at-50050-pm.png" style="zoom:33%;" />

```
输入：[2,2,2,5,2]
输出：false
```

**解题过程**

```java
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root,root.val);
    }

    public boolean helper(TreeNode root, int value){
        // 边界条件
        if(root == null) return true;
        if(root.val != value) return false;
        return helper(root.left,value) && helper(root.right,value);
    }
}
```



```java
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root,null);
    }

    public boolean helper(TreeNode root, TreeNode pre){ // 利用pre来记录
        // 边界条件 1
        if(root == null) return true;
        // 边界条件 2
        if(pre != null){
            if(pre.val != root.val){
                return false;
            }
        }
        pre = root;
        return helper(root.left,pre) && helper(root.right,pre);
    }
}
```

## [669. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree/)

给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

**示例 1:**

```
输入: 
    1
   / \
  0   2

  L = 1
  R = 2

输出: 
    1
      \
       2
```

**示例 2:**

```
输入: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

输出: 
      3
     / 
   2   
  /
 1
```

**解题过程：**

```java
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果root为空  则直接返回null
        if(root == null) return root;
        // 如果root的值小于low，则说明左子树不满足条件，需要更大的值，即向右开启递归
        if(root.val < low) return trimBST(root.right, low, high);
        // 如果root的值大于high，则说明右子树不满足条件，需要更小的值，即向左开启递归
        if(root.val > high) return trimBST(root.left, low, high);

        //  处理正常的节点
        // 涉及到树结构的变化，一定要改变链接
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
```

