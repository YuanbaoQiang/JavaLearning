---
title: LeetCode-下一个排列
date: 2020-11-10 20:22:13
tags:
---

# 题目要求

**原题链接**：[31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/)

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。

```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```



# 解题过程

**参考**：[下一个排列算法详解：思路+推导+步骤，看不懂算我输！](https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 从后往前遍历
        for(int i = len - 1; i > 0; i--){
            // 遇到第一个较小的数 a
            if(nums[i] > nums[i - 1]){
                // 从已经遍历的序列中 倒序寻找一个比当前的小数 a 大一点的数b
                for(int j = len - 1; j > i - 1; j--){
                    if(nums[j] > nums[i - 1]){
                        // 交换小数a和大数b
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                // 将[i,end]从升序变为降序
                Arrays.sort(nums, i, len);
                // 此时已经获得了下一个排列，返回即可
                return;
            }
        }
        // 说明此时的排列为递减序列，直接sort
        Arrays.sort(nums);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

