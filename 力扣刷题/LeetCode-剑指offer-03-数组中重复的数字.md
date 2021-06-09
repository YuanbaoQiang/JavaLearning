@[TOC](目录)
***
# 原题链接
**原题链接**： [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**输入：**

    [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3

**限制：**`2 <= n <= 100000`

# 解题过程
<font color=green size=4>问题转化：消失的数字</font> -----> [LeetCode-448-找到所有数组中消失的数字](https://blog.csdn.net/qyb19970829/article/details/113622568)

时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![](LeetCode-%E5%89%91%E6%8C%87offer-03-%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97_md_files/image_20210203234640.png?v=1&type=image&token=V1:G2yX1R9bEEwBlB_YMddeADlk2xcdgR8PD1czdA5183A)

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 消失的数字
        // 1. 元素整体加1，将这个问题完全转换成“消失的数字”问题
        for(int i = 0; i < nums.length; i++) ++nums[i];
        // 2. 给数组元素做标记
        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex] > 0){
                nums[newIndex] *= -1;
            }
        }
        // 3. 遍历数组，如果大于0，则返回（注意要将第一步加上的1减去）
        for(int num : nums){
            if(num > 0) return num - 1;
        }
        return -1;
    }
}
```

或者也可以写成下方的形式，区别在于，<font color=blue>上方的结果是在最后一个for循环的中途返回的，而下方的方式需要判断完整个数组之后，再返回0，因为数组中必然有重复的数字，**如果没有正数的话啊，说明重复的一定是0**！</font>之所以性能上会稍微差一些，是因为for循环中的过多的判断操作。

![image-20210204122311689](https://i.loli.net/2021/02/04/osPQCGVfhFJi4q3.png)

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]);
            if(nums[newIndex] > 0) nums[newIndex] *= -1;
        }
        for(int num : nums){
            if(num > 0) return num;
        }
        // 如果没有找到正数，则重复的必然是0
        return 0;
    }
}
```

<font color=green size=4>利用Set的不重复特性</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(n)$ | <font color=green>**推荐**</font>

![](LeetCode-%E5%89%91%E6%8C%87offer-03-%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97_md_files/image_20210203235511.png?v=1&type=image&token=V1:O_HBF6vTdKzU3vneDwEzoBfgOiIUsDG8Sj5C0BinAgY)

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 利用Set的元素不重复特性
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            // 如果无法加入该元素，则说明集合中存在重复的元素，直接返回即可
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }
}
```

<font color=green size=4>先排序，后遍历</font> | 时间复杂度：$O(nlogn)$ | 空间复杂度：$O(logn)$ | <font color=red>**不推荐**</font>

![](LeetCode-%E5%89%91%E6%8C%87offer-03-%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97_md_files/image_20210203235814.png?v=1&type=image&token=V1:TxlBXza_HtXzIbZizOu11eZri-a2ewCXllAuX_J6qVA)

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            // 返回重复值
            if(nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }
}
```

