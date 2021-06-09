@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/) | [240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**示例**:

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = 5，返回 true。

给定 target = 20，返回 false。

**限制**：

0 <= n <= 1000

0 <= m <= 1000

***

# 解题过程

图片来源：[面试题04. 二维数组中的查找（标志数，清晰图解）](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/)

> 可以将这个数组看成一个二叉搜索树，根节点就是数字的右上角元素

![Picture1.png](https://i.loli.net/2021/02/04/2N4x8ZynTreRP9c.png)

<font color=green size=4>线性查找</font> | 时间复杂度：$O(m+n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 下标的行最多增加 `m` 次，列最多减少 `n` 次，循环体最多执行 `n + m` 次。

![image-20210204114659062](https://i.loli.net/2021/02/04/IkuLHXnlp3gi7FA.png)

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = 0;
        // 1. 起点为matrix[matrix.length - 1][0]，从二维数组的左下角开始搜索
        while(m >= 0 && n <= matrix[0].length - 1){
            // 2. target小于该元素，则需要向上搜索
            if(matrix[m][n] > target){
                m--;
            }else if(matrix[m][n] < target){ // 3. target大于该元素，则需要向右搜索
                n++;
            }else{ // 3. 搜索结束，找到target值
                return true;
            }
        }
        return false;
    }
}
```

<font color=green size=4>递归</font> | 时间复杂度：$O(m+n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 线性搜索的递归写法，不过递归也意味着需要额外运行时方法栈的空间

![image-20210204114420461](https://i.loli.net/2021/02/04/jaJPFfQAimg7ENV.png)

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        return recur(matrix, 0, matrix[0].length - 1, target);
    }
    
    // 从右上角的顶点开始
    public boolean recur(int[][] matrix, int row, int col, int target){
        if(row <= matrix.length - 1 && col >= 0){
            if(target == matrix[row][col]) return true;
            // 如果当前数组中的数 小于 target，则向下走
            else if(target > matrix[row][col]) return recur(matrix, row + 1, col, target);
            // 如果当前数组中的数 大于target，则向左走
            else if(target < matrix[row][col]) return recur(matrix, row, col - 1, target);
        }
        // 如果不满足上面的if条件，则返回false
        return false;
    }
}
```

<font color=green size=4>暴力搜索</font> | 时间复杂度：$O(mn)$ | 空间复杂度：$O(1)$ | <font color=red>**不推荐**</font>

![image-20210204115013224](https://i.loli.net/2021/02/04/GDrtPoUVqL6XJe4.png)

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
```

