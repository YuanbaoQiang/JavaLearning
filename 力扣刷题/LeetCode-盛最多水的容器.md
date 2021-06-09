@[TOC](目录)

***

# 题目要求

**原题链接**：[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

**说明**：你不能倾斜容器。

**示例 1：**

![](https://i.loli.net/2021/01/15/L4i2lhYmcKdOE5S.jpg)

```
输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
```

**示例 2**：

```
输入：height = [1,1]
输出：1
```

**示例 3**：

```
输入：height = [4,3,2,1,4]
输出：16
```


**示例** 4：

```
输入：height = [1,2,1]
输出：2
```

**提示**：

- n = height.length
- 2 <= n <= 3 * $10^4$
- 0 <= height[i] <= 3 * $10^4$

***

# 解题过程

<font color=green size=4>双指针</font>

```java
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(i < j){
            // 双指针 i j
            // 当height[i] < height[j]的时候，则说明左边的杆子低，右边的杆子高，这个时候右边的指针j向左偏移，寻找一个短杆
            // 当height[i] >= height[j]的时候，说明左边的杆子高，右边的杆子低，这个时候左边的指针i向右偏移，寻找一个短杆
            area = height[i] < height[j] ? Math.max(area, (j - i) * height[i++]) : Math.max(area, (j - i) * height[j--]);
        }
        return area;
    }
}
```

<font color=green size=4>暴力解法重拳出击</font>

```java
class Solution {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return area;
    }
}
```

