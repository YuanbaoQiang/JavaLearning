@[TOC](目录😘)

***

# 题目要求

**原题链接**：[136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

**说明**：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

**示例 1:**

```
输入: [2,2,1]
输出: 1
```

**示例 2:**

```
输入: [4,1,2,1,2]
输出: 4
```

# 解题过程

<font color=green size=4>异或运算</font>

参考：[官方题解](https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/)

对于这道题，可使用异或运算 $\oplus$。异或运算有以下三个性质：

1. 任何数和 00 做异或运算，结果仍然是原来的数，即 $a \oplus 0$=a。
2. 任何数和其自身做异或运算，结果是 00，即 $a \oplus a$=0。
3. 异或运算满足交换律和结合律，即 $a \oplus b \oplus a$=$b \oplus a \oplus a$=$b \oplus (a \oplus a)$=$b \oplus0$=b。

```java
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num :nums){
            single ^= num;
        }
        return single;
    }
}
```

<font color=green size=4>排序</font>

```java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1 || nums[0] != nums[1]) return nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[nums.length - 1];
    }
}
```

