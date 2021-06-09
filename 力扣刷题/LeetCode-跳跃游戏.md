# 题目要求

**原题链接**：[55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

**示例 1**:

```
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
```

**示例 2**:

```
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```



# 解题过程

<font color=green size=4>贪心</font>

记录每次可以到达的最大的下标，如果该最大下标大于或等于最后一个元素的下标在，则满足条件。

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 最大可以跳跃到的最大下标
        int longest_jump = 0;
        // 每次遍历都截止到固定的位置
        for(int i = 0; i <= longest_jump; i++){
            // 记录每次可以达到的最大的跳跃下标
            longest_jump = Math.max(longest_jump, i + nums[i]);
            // 如果该下标大于等于 n-1，即最后一个元素，则可以到达最后一个位置
            if(longest_jump >= n - 1) return true;
        }
        return false;
    }
}
```