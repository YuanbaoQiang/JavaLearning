---
title: LeetCode-杨辉三角
date: 2020-12-06 23:32:46
tags:
---

# 题目要求

**原题链接**：[118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)

给定一个非负整数 *numRows，*生成杨辉三角的前 *numRows* 行。

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

**示例:**

```
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

# 解题过程

**简单两个for循环**

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        if(numRows == 0) return resList;
        // 定义杨辉三角中的行数，初始行数☞向-1
        int level = -1;
        // 外循环：进行定位到杨辉三角中的每一行
        for(int i = 0; i < numRows; i++){
            List<Integer> innerList = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                // 内循环：求除杨辉三角中每一行的具体元素
                // 如果当前元素为行中第一个或者最后一个 则add(1)
                if(j == 0 || j == i){
                    innerList.add(1);
                }else{ // 否则就开始找到上一个列表中 取出对应两个元素，相加，然后add即可
                    innerList.add(resList.get(level).get(j - 1) + resList.get(level).get(j));
                }
            }
            // 遍历得到一行innerList,就添加到resList中
            resList.add(innerList);
            level++;
        }
        return resList;
    }
}
```

