---
title: LeetCode-三数之和
date: 2020-12-05 20:29:32
tags:
---

# 题目要求

**原题链接**：[15. 三数之和](https://leetcode-cn.com/problems/3sum/)

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

**示例：**

```
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

# 解题过程

**双指针**

先排序，下标，i，left，right对应的就是列表中的元素。

注意：需要用while进行跳过重复的元素

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        // 特殊判断
        if(nums == null || len < 3) return resList;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            // 如果此时nums[i]已经大于0，则没有遍历的必要了
            if(nums[i] > 0) break;
            // 已经确定了三个数分别时nums[i]  nums[left]  nums[right]
            // 所以nums[i]只需要保留一个即可，重复的直接跳过
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 同nums[i] 去重
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }
            }
        }
        return resList;
    }
}
```

