# 题目要求

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的每个数字在每个组合中只能使用一次。

**说明**：

所有数字（包括目标数）都是正整数。
**解集不能包含重复**的组合。 

**示例 1**:

```
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

**示例 2:**

```
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
```

# 解题过程

**回溯**s

和[LeetCode-组合总和](https://blog.csdn.net/qyb19970829/article/details/111026071)基本类似，主要在于去重的操作：

1. 先排序
2. 排除同层的重复元素
3. 保留不同层的重复元素

去重的详细解释可以参考：[大佬的评论](https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211)

```java
class Solution {
    List<List<Integer>> reslList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return reslList;
        }
        List<Integer> innerList = new ArrayList<>();
        // 需要先排序，方便后续去重
        Arrays.sort(candidates);
        dfs(0, candidates, innerList, target);
        return reslList;
    }

    public void dfs(int begin, int[] candidates, List<Integer> innerList, int target){
        if(target < 0){
            return;
        }else if(target == 0){
            reslList.add(new ArrayList<>(innerList));
            return;
        }else{
            for(int i = begin; i < candidates.length; i++){
                if(target < candidates[i]){
                    continue;
                }
                // 此时需要去重
                // candidates[i] == candidates[i - 1]因为排过序，所以相邻两个重复元素可以避免（保证了同一层级不会有重复的元素）
                // i > begin: 保证了不同层可以重复
                // 解释可参考：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211
                if(i > begin && candidates[i] == candidates[i - 1]){
                    continue;
                }
                innerList.add(candidates[i]);
                // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
                dfs(i + 1, candidates, innerList, target - candidates[i]);
                innerList.remove(innerList.size() - 1);
            }
        }
    }
}
```

