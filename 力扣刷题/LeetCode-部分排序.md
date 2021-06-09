---
title: LeetCode-部分排序
date: 2020-12-05 20:36:52
tags:
---

# 题目要求

**原题链接**：[面试题 16.16. 部分排序](https://leetcode-cn.com/problems/sub-sort-lcci/)

给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

**示例**：

```
输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]
```

# 解题过程

**找逆序对**

**参考**：[你吼那么大声干什么嘛](https://leetcode-cn.com/u/abcdlsj/)的评论

```java
class Solution {
    public int[] subSort(int[] array) {
        // 特殊情况判断
        if(array == null || array.length == 0 || array.length == 1) return new int[]{-1,-1};
        /*
        1,2,4, || 7,10,11,7,12,6,7, || 16,18,19
        左边               中间                  右边
        最后是三个部分，左边的最大值必须小于其右边（中间和右边）的最小值，右边的最小值必须大于其左边（左边和中间）的最大值;
        那么从左往右找的是最大值，如果出现小于左边最大值的情况，那么更新 rightindex，最后的 rightindex 右边的必然大于这个最大值;
        从右往左找的是最小值，如果出现大于这个值的情况，那么更新 leftindex，最后的 leftindex 左边的必然小于这个最小值;
        */
        
        int m = 0;
        int n = array.length - 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if(max <= array[i]){
                max = array[i];
            }else{
                m = i;
            }
        }

        for(int i = array.length - 1; i >= 0; i--){
            if(min >= array[i]){
                min = array[i];
            }else{
                n = i;
            }
        }
         
         return m > n ? new int[]{n, m} : new int[]{-1, -1};
    }
}
```

**先排序后比较**

```java
class Solution {
    public int[] subSort(int[] array) {
      int[] clone = array.clone();
      int[] res = new int[]{-1, -1};
      Arrays.sort(array);
      for(int i = 0; i < array.length; i++){
          if(array[i] != clone[i]){
              // 第一次判断
              if(res[0] == -1){
                  res[0] = i;
              }
              res[1] = i;
          }
      }
      return res;
    }
}
```



