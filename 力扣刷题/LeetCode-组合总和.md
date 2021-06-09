# 题目要求

**原题链接**：[39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。

**说明：**

- 所有数字（包括 `target`）都是正整数。
- 解集不能包含重复的组合。 

**示例 1：**

```
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
```

**示例 2：**

```
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

**提示**：

- 1 <= candidates.length <= 30
- 1 <= candidates[i] <= 200
- candidate 中的每个元素都是独一无二的。
- 1 <= target <= 500

# 解题过程

**回溯**

**参考**：[回溯击败了99.87%的用户，所有的组合都给你找齐了](https://leetcode-cn.com/problems/combination-sum/solution/di-gui-hui-su-tu-wen-fen-xi-ji-bai-liao-9987de-yon/)

这类题目可以看成树结构的遍历题，只不过是N叉树。

这道题需要注意的是：List属于引用传递，之前[LeetCode-括号生成](https://blog.csdn.net/qyb19970829/article/details/110675068)中利用String类型的path变量属于值传递。

![](https://i.loli.net/2020/12/10/MZT7JAESUme9nBq.png)zho

```java
class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> innerList = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return resList;
        }
        dfs(0, candidates, innerList, target);
        return resList;
    }

    public void dfs(int begin, int[] candidates,List<Integer> innerList, int target){
        if(target == 0){
            resList.add(new ArrayList<>(innerList));
            return;
        }else{
            // 此处类似于N叉树的遍历
           for(int i = begin; i < candidates.length; i++) {
               // 如果当前的节点元素大于target，则该节点肯定不满足
               if(candidates[i] > target){
                   continue;
               }
               innerList.add(candidates[i]);
               dfs(i, candidates,innerList, target - candidates[i]);
               innerList.remove(innerList.size() - 1);
           }
        }
    }
}
```

