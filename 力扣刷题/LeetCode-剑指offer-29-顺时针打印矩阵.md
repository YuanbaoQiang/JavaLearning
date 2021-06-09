@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/) 

难度简单186收藏分享切换为英文接收动态反馈

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

**示例 1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例 2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

**限制：**

- `0 <= matrix.length <= 100`
- `0 <= matrix[i].length <= 100`

***

# 解题过程

<font color=green size=4>按层遍历</font>

截图来自官方：[螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/)

![image-20210129223640041](https://i.loli.net/2021/01/29/u31RmYJiQCKFDdl.png)

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }

        int[] res = new int[matrix.length * matrix[0].length];

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int index = 0;
        while(l <= r && t <= b){
            for(int i = l; i <= r; i++){
                res[index++] = matrix[t][i];
            }

            for(int i = t + 1; i <= b; i++){
                res[index++] = matrix[i][r];
            }

            if(l < r && t < b){
                for(int i = r - 1; i >= l + 1; i--){
                    res[index++] = matrix[b][i];
                }

                for(int i = b; i >= t + 1; i--){
                    res[index++] = matrix[i][l];
                }
            }
            l++;
            r--;
            t++;
            b--;
        }

        return res;
    }
}
```

<font color=green size=4>根据边界条件切换状态</font>

代码来自：[54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)，这俩题几乎一样

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visisted = new boolean[rows][columns];
        int total = rows * columns;
        // 定义四个状态
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0;
        int column = 0;
        for(int i = 0; i < total; i++){
            res.add(matrix[row][column]);
            visisted[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visisted[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return res;
    }
}
```

