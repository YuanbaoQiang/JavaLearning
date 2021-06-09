@[TOC](目录)

***

# 题目要求

**原题链接**：[547. 省份数量](https://leetcode-cn.com/problems/number-of-provinces/)

有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 `isConnected[i][j] = 1` 表示第 i 个城市和第 j 个城市直接相连，而 `isConnected[i][j]` = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。



**示例 1：**

![](https://i.loli.net/2021/01/07/xPR4cZk7hCFzSMD.jpg)

```
输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2
```

**示例 1：**

![](https://i.loli.net/2021/01/07/rM1KiBmusUx9oEj.jpg)

```
输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
输出：3
```

**提示**：

- 1 <= n <= 200
- n == isConnected.length
- n == isConnected[i].length
- `isConnected[i][j]` 为 1 或 0
- `isConnected[i][i]` == 1
- `isConnected[i][j]` == `isConnected[j][i]`

***

# 解题过程

<font color=green size=4>深度优先遍历</font>

**求无向图中连通域的个数**，具体可以参考：[DFS + BFS + 并查集，3 种方法计算无向图连通域数量](https://leetcode-cn.com/problems/number-of-provinces/solution/dfs-bfs-bing-cha-ji-3-chong-fang-fa-ji-s-edkl/)。

```java
class Solution {
    private int length;
    public int findCircleNum(int[][] isConnected) {
        this.length = isConnected.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for(int i = 0; i < length; i++){
            // 如果没有被做标记，则为一个新的连通域，即和i不是一个省份
            // 如果被做了标记，说明和i是一个省份的
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    public void dfs(int i, int[][] isConnected, boolean[] visited){
        // 对当前定点的标记
        visited[i] = true;
        for(int j = 0; j < length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                // 此时i和j是一个省份的，则以j为起点进行遍历
                dfs(j, isConnected, visited);
            }
        }
    }
}
```

