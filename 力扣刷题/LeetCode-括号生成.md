---
title: LeetCode-括号生成
date: 2020-12-04 23:17:49
tags:
---

# 题目要求

**原题链接**：[22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

数字 *n* 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

**示例：**

```
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
```

# 解题过程

**回溯**

参考：[入门级别的回溯法，学会套路，秒懂十题！](https://leetcode-cn.com/problems/generate-parentheses/solution/ru-men-ji-bie-de-hui-su-fa-xue-hui-tao-lu-miao-don/)

只要满足条件就调用自身函数。维护两个变量res和path，其中res为最终结果，path保存已经走过的路径。如果搜到一个满足条件的结果，就将path保存在res结果中。类似的题目可见：[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)，其中path不是引用传递，属于值传递。

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201204232219.png)

最后五条画黑线的就是最终的结果，其中左分支都是添加左括号，右分支都是添加右括号。两个递归的开启，是单独的两个if判断，只要满足条件就调用函数，完成相应的功能（加括号）。

```java
class Solution {
     List<String> resList = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return resList;
    }

    public void dfs(int left, int right, String path){
        if(left == 0 && right == 0){
            resList.add(path);
        }

        if(left > 0){
            dfs(left - 1, right, path + "(");
        }

        if(left < right){
            dfs(left, right - 1, path + ")");
        }
    }
}
```



***

# 2021年2月13日更新

这道题属于标准回溯问题，如果不进行剪枝，则就是一棵满二叉树，结果集中含有多余的结果，所以需要进行剪枝操作！

所以完成这道题的合适思路是：1. 先构建出一棵满二叉树，即有画出二叉深搜树。 2. 结果筛选，即剪枝。

深搜过程中，“(”的数量记为left，“)”记为right，由于是先添加"("，所以只要满足以下三个条件，就不能继续递归，需要直接返回至上层节点：

1. right > left
2. left > n
3. right > n

![LeetCode-22-括号生成04](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/LeetCode-22-%E6%8B%AC%E5%8F%B7%E7%94%9F%E6%88%9004.jpeg)

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(0, 0, n, 0, new StringBuilder(), res);
        return res;
    }
    
    public void dfs(int left, int right, int n, int depth, StringBuilder path, List<String> res){
        if(right > left || left > n || right > n) return;
        if(depth == n * 2){
            res.add(path.toString());
            return;
        }

        dfs(left + 1, right, n, depth + 1, path.append("("), res);
        path.deleteCharAt(path.length() - 1);
        
        dfs(left, right + 1, n, depth + 1, path.append(")"), res);
        path.deleteCharAt(path.length() - 1);
    }
}
```

