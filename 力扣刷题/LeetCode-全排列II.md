@[TOC](目录😶)

***

# 题目要求

**原题链接**：[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

给定一个可包含重复数字的序列 `nums` ，**按任意顺序**返回所有不重复的全排列。

**示例 1**：

```
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
```

**示例 2**：

```
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**提示**：

- 1 <= nums.length <= 8
- -10 <= nums[i] <= 10

# 解题过程

<font color=green size=4>回溯+深度优先+剪枝</font>

在[LeetCode-全排列](https://blog.csdn.net/qyb19970829/article/details/111934787)的基础上，加以剪枝，避免重复。

> 注意：需要先对数组排序

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        // 需要先对数组排序
        Arrays.sort(nums);
        dfs(nums, 0, used, path, res);
        return res;

    }

    public void dfs(int[] nums, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            // 减枝  将同一层中的  相邻的 重复的并且没有使用的元素  排除
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
```

