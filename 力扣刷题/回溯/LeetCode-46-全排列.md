@[TOC](目录👾)

***

# 题目要求

**原题链接**：[46. 全排列](https://leetcode-cn.com/problems/permutations/)

给定一个 **没有重复** 数字的序列，返回其所有可能的全排列。

**示例:**

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

# 解题过程

<font color=green size=4>回溯和深度优先遍历</font>

参考：[回溯算法入门级详解 + 练习（持续更新）](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/)

> 注意：path在整个遍历过程中为同一个对象，属于值传递。需要在递归出口的时候，做一次复制，创建一个新的对象。

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        // 定义一个nums.length长度的boolean数组，用来判断该元素是否被使用过
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, used, path, res);
        return res;
    }

    public void dfs(int[] nums, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        // 递归结束条件：当深度和数组长度相同时
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 每次递归的功能
        // 将没有使用过字母进行添加
        for(int i = 0; i < nums.length; i++){
            // 如果当前的元素没有使用过
            if(!used[i]){
                // 添加该元素
                path.add(nums[i]);
                // 该元素已经使用过了，需要重置该元素的状态
                used[i] = true; // 代表该元素已经使用过了

                // 开启递归
                dfs(nums, depth + 1, used, path, res);

                // 此时递归已经结束了，需要重置元素的状态
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
```

