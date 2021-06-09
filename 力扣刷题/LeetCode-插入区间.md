@[TOC](目录🏇)

***

# 题目要求

**原题链接**：[57. 插入区间](https://leetcode-cn.com/problems/insert-interval/) 
给出一个*无重叠的 ，*按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

**示例 1**：

```
输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
```

**示例 2**：

```
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
```



# 解题过程

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int i = 0;
        int resIndex = 0;
        // 将最终的结果分成三个部分：1. 未发生重叠的区间； 2. 发生重叠的区间； 3. 剩下的区间
        // 1. 未发生重叠的区间
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res[resIndex++] = intervals[i++];
        }

        // 2. 发生重叠的区域
        // 重叠区域内 则 intervals[i][0]  <=  newIntervals[1]
        // 找到重叠区域的范围即可
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[resIndex] = newInterval;
        // 3. intervals[i][0] 已经 大于 newIntervals[1]了，此时intervals与newInterval已经无重叠
        
        while(i < intervals.length){
            res[++resIndex] = intervals[i++];
        }
        return Arrays.copyOf(res, resIndex + 1);
    }
}
```

