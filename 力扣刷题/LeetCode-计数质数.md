---
title: LeetCode-计数质数
date: 2020-12-03 21:46:40
tags:
---

# 题目要求

**原题链接**：[204. 计数质数](https://leetcode-cn.com/problems/count-primes/)

统计所有小于非负整数 *`n`* 的质数的数量。

```
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
```

**示例 2**：

**示例 1**：

```
输入：n = 0
输出：0
```


**示例 3**：

```
输入：n = 1
输出：0
```

# 解题过程

**暴力（超时）**

```java
class Solution {
    public int countPrimes(int n) {
        int count = 0;
         for(int i = 2; i < n; i++){
             boolean flag = true;
             for(int j = 2; j < i; j++){
                 if(i % j == 0){
                     flag = false;
                     break;
                 }
             }
             if(flag) count++;
         }
         return count;
    }
}
```

**暴力改进（还是超时）**

```java
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrimes(int number){
        int max = (int) Math.sqrt(number);
        for(int i = 2; i <= max; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
```

**厄拉多塞筛法**

先创建一个长度为n的数组，然后将当前遍历到的元素的所有倍数都进行标记（这些数肯定不是质数），然后直接根据这些元素所对应的状态（true 或 false），判断是否是质数。

可以参考：[计数质数（暴力法及优化、筛法及优化与思路详解）](https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-bao-li-fa-ji-you-hua-shai-fa-ji-you/)

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201203215515.gif)

```java
class Solution {
    public int countPrimes(int n) {
        // 创建一个数组，初始都是false
        boolean[] helper = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!helper[i]){
                count++;
                // 需要将 i 的所有倍数进行填充为true
                // 起始为 i + i，每次都加i
                for(int j = 2*i; j < n; j += i){
                    helper[j] = true;
                }
            }
        }
        return count;
    }
}
```

