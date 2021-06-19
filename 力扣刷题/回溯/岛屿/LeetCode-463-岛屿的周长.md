# 题目要求

**原题链接**：[463. 岛屿的周长](https://leetcode-cn.com/problems/island-perimeter/)

给定一个 `row x col` 的二维网格地图 grid ，其中：`grid[i][j] = 1` 表示陆地， `grid[i][j] = 0` 表示水域。

网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 

**示例 1**：

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/island.png)

```
输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
输出：16
解释：它的周长是上面图片中的 16 个黄色的边
```

**示例 2**：

```
输入：grid = [[1]]
输出：4
```

**示例 3**：

```
输入：grid = [[1,0]]
输出：4
```

**提示**：

+ row == grid.length
+ col == grid[i].length
+ 1 <= row, col <= 100
+ `grid[i][j]` 为 0 或 1

----

# 解题过程

## 代码1

```
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0] == null) {
			return 0;
		}
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i , j));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        // 如果超出岛屿范围
        if(!isInGrid(grid, i, j)) return 1;
        // 如果遇到水域
        if(grid[i][j] == 0) return 1;
        // 如果访问过
        if(grid[i][j] == 2) return 0;

        grid[i][j] = 2;

        int count = 0;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }

    public boolean isInGrid(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        return true;
    }
}
```

