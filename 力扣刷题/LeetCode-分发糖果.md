@[TOC](目录🎄)

***

# 题目要求



**原题链接**：[135. 分发糖果](https://leetcode-cn.com/problems/candy/)

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

**示例 1**:

```
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
```


**示例 2**:

```
输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
```



# 解题过程

<font color=green size=5>两次遍历</font>

第一次从左到右遍历，使得右边分数高的孩子，糖果比前面的孩子多。

第二次从右到左遍历，使得左边分数高的孩子，糖果比后面的孩子多。

```java
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length - 1] = 1;
        // 从左向右遍历
        for(int i = 1; i < ratings.length; i++){
            // 如果后一个孩子的分数比前一个孩子高
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int count = left[ratings.length - 1];
        // 从右向左遍历
        for(int i = ratings.length - 2; i > -1; i--){
            // 如果前一个孩子的分数比后一个孩子高
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }else{
                right[i] = 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
```

