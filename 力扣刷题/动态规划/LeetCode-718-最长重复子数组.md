# 题目要求

**原题链接**：[718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/)

给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。



**示例**：

```
输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。
```

**提示**：

+ `1 <= len(A), len(B) <= 1000``
+ ``0 <= A[i], B[i] < 100`

---

# 解题过程

## 代码1

```java
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp[i][j]表示nums1的前i个元素和nums2中的前j个元素组成的最长公共子数组的长度
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}
```

