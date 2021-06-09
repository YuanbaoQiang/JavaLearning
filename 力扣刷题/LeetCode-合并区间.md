@[TOC](目录🤹‍♀️)

# 题目要求

**原题链接**：[56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/) 
给出一个区间的集合，请合并所有重叠的区间。

**示例 1**:

```
输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```

**示例 2**:

```
输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
```

# 解题过程

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for(int i = 0; i < intervals.length; i++){
            // 如果此时intervals的第一个元素，大于  res的最后的元素
            // 此时区间没有发生重叠
            if(index == -1 || intervals[i][0] > res[index][1]){
                res[++index] = intervals[i];
            }else{
                // 此时intervals[i][0] <= res[index][1]
                // res[index][1]  在intervals[i][0]和intervals[i][1]之间，产生了重叠
                // res 区间中的第二个元素为   原来的第二个元素 和 intervals的第二个元素中最大的数字
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }	
        }
        return Arrays.copyOf(res, index+1);
    }
}
```

