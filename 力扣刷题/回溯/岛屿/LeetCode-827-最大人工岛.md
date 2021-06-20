# 题目要求

**原题链接**：[827. 最大人工岛](https://leetcode-cn.com/problems/making-a-large-island/)

给你一个大小为 `n x n` 二进制矩阵 `grid` 。最多 只能将一格 `0` 变成 `1` 。

返回执行此操作后，`grid` 中最大的岛屿面积是多少？

岛屿 由一组上、下、左、右四个方向相连的 1 形成。

 

**示例 1**:

```
输入: grid = [[1, 0], [0, 1]]
输出: 3
解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
```

**示例 2**:

```
输入: grid = [[1, 1], [1, 0]]
输出: 4
解释: 将一格0变成1，岛屿的面积扩大为 4。
```

**示例 3**:

```
输入: grid = [[1, 1], [1, 1]]
输出: 4
解释: 没有0可以让我们变成1，面积依然为 4。
```

**提示**：

+ `n == grid.length`
+ `n == grid[i].length`
+ `1 <= n <= 500`
+ `grid[i][j] 为 0 或 1`

---

# 解题过程

## 代码1

```java
class Solution {
    public int largestIsland(int[][] grid) {
        int res = 0;
        Map<Integer, Integer> indexAndArea = new HashMap<>();
        int index = 2;
        // 第一次遍历，给同一个岛屿编上同样的编号
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, index);
                    indexAndArea.put(index, area);
                    index++;
                    res = Math.max(res, area);
                }
            }
        }

        if(res == 0) return 1;

        // 第二次遍历，查找海洋块
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    int area = 1;
                    HashSet<Integer> set = findNeighbour(grid, i, j);
                    if(set.size() < 1) continue;
                    for(int cur : set){
                        area += indexAndArea.get(cur);
                    }
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }

    // 查找海洋块的四周
    public HashSet<Integer> findNeighbour(int[][] grid, int i, int j){
        HashSet<Integer> set = new HashSet<>();
        if(isInArea(grid, i - 1, j) && grid[i - 1][j] != 0){
            set.add(grid[i - 1][j]);
        }
        if(isInArea(grid, i + 1, j) && grid[i + 1][j] != 0){
            set.add(grid[i + 1][j]);
        }
        if(isInArea(grid, i, j - 1) && grid[i][j - 1] != 0){
            set.add(grid[i][j - 1]);
        }
        if(isInArea(grid, i, j + 1) && grid[i][j + 1] != 0){
            set.add(grid[i][j + 1]);
        }
        return set;
    }

    public int dfs(int[][] grid, int i, int j, int index){
        if(!isInArea(grid, i, j)){
            return 0;
        }

        if(grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = index;

        return 1 +
            dfs(grid, i - 1, j, index) +
            dfs(grid, i + 1, j, index) + 
            dfs(grid, i, j + 1, index) + 
            dfs(grid, i, j - 1, index);
    }

    public boolean isInArea(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        return true;
    }
}
```

