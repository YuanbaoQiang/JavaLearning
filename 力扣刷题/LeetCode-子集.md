[TOC](目录)

***

# 题目要求

**原题链接**：[78. 子集](https://leetcode-cn.com/problems/subsets/)

给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。

**示例 1**：

```
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

**示例 2**：

```
输入：nums = [0]
输出：[[],[0]]
```

**提示**：

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

***

# 解题过程

<font color=green size=4>回溯算法</font>

图片来自：[回溯算法套路详解](https://zhuanlan.zhihu.com/p/93530380)

![preview](https://i.loli.net/2021/01/13/NeJMX9px8L2DTIc.jpg)

回溯三部曲：

1. 做出选择
2. 递归
3. 撤销选择

  `path.remove(path.size() - 1);`撤销选择是因为要返回到上一级节点的状态。

`res.add(new ArrayList<>(path));`是因为ArrayList属于引用传递，所以需要在每一个节点新建一个对象保存一下节点信息。

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, res, path);
        return res;
    }

    public void dfs(int[] nums, int begin, List<List<Integer>> res, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = begin; i < nums.length; i++){
            // 做出决定
            path.add(nums[i]);
            // 深度优先遍历
            dfs(nums, i + 1, res, path);
            // 撤回掉此次for循环下path的信息
            path.remove(path.size() - 1);
        }
    }
}
```

