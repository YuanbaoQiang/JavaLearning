---
title: LeetCode-岛屿的周长
date: 2020-10-30 21:53:51
tags:
---

# 题目要求

**原题链接**：[463. 岛屿的周长](https://leetcode-cn.com/problems/island-perimeter/)

给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 **示例 :**

```
输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16

解释: 它的周长是下面图片中的 16 个黄色的边：
```

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201030215533.png)



# 解题过程

**参考题解**：[「手画图解」463. 岛屿的周长 | 很简单的解法](https://leetcode-cn.com/problems/island-perimeter/solution/shou-hua-tu-jie-463-dao-yu-de-zhou-chang-by-xiao_b/)

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201030215722.png)

所有土地的四边减去内部的边界即可！

```java
class Solution {
    public int islandPerimeter(int[][] grid) {
        int land = 0;
        int border = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    land++;
                    if( i < grid.length - 1 && grid[i+1][j] == 1){
                        border++;
                    }
                    if( j < grid[0].length - 1 && grid[i][j+1] == 1){
                        border++;
                    }
                }
            }
        }
        return 4*land - 2*border;
    }
}
```

