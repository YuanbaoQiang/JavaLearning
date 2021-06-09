@[TOC](目录)

***

# 题目要求

**原题链接**：[面试题 16.17. 连续数列](https://leetcode-cn.com/problems/contiguous-sequence-lcci/)

给定一个整数数组，找出总和最大的连续数列，并返回总和。

**示例：**

```
输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

# 解题过程

<font color=green size=4>动态规划</font>

> 时间复杂度：$O(n)$

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                dp[i] = nums[i];
                continue;
            }
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
```

<font color=green size=4>分治思想</font>

> 时间复杂度：$O(nlogn)$

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return divid(nums, 0, nums.length - 1);
    }

    public static int divid(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = left + (right - left) / 2;
        // 1. 左半边的最大和
        int maxLeftSum = divid(nums, left, mid);
        // 2. 右半边的最大和
        int maxRigthSum = divid(nums, mid + 1, right);
        // 3. 中间部分的最大和
        // 左边的最大和
        // left --------- mid
        int leftSum = 0;
        int maxSubLeftSum = Integer.MIN_VALUE;
        for(int i = mid;i >= left; i--){
            leftSum += nums[i];
            maxSubLeftSum = Math.max(maxSubLeftSum, leftSum);
        }
        // 右边的最大和
        // mid --------- mid
        int rightSum = 0;
        int maxSubRightSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= right; i++){
            rightSum += nums[i];
            maxSubRightSum = Math.max(maxSubRightSum, rightSum);
        }
        return Math.max(maxSubLeftSum + maxSubRightSum, Math.max(maxLeftSum, maxRigthSum));
    }
}
```

<font color=green size=4>暴力求解</font>

> 时间复杂度：$O(n^2)$

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
```

