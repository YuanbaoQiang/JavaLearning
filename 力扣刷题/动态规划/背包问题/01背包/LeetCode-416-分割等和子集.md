# 题目要求

**原题链接**：[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

**示例 1**：

```
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
```

**示例 2**：

```
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
```

**提示**：

+ $1 <= nums.length <= 200$
+ $1 <= nums[i] <= 100$

---



# 解题过程

## 代码1

**可参考**：

+ [动态规划（转换为 0-1 背包问题）](https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/)

> 建议自己表格，模拟动规的过程

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        // 将这个数组的分割成两个等和的子集
        int sum = 0;

        for(int num : nums){
            sum += num;
        }
        
        // 如果是奇数的话，返回false
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;

        // 创建二维数组，行：物品索引（选择的数字） 列：容量（目标和）
        boolean[][] dp = new boolean[len][target + 1];

        // 当i = 0时，此时数组里可供选择的只有一个元素
        // 只有当nums[0] <= target的时候，dp[0][nums[0]]才为true
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        // 填后面的几行
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= target; j++){
                // 先将之前的状态记录下来，后期再修改
                dp[i][j] = dp[i - 1][j];

                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[len - 1][target];

    }
}
```

