@[TOC](目录)

***

# 题目要求

**原题链接**：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

**示例**：

```
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```

**提示**：

1. 1 <= nums.length <= 50000
2. 1 <= nums[i] <= 10000

***

# 解题过程

<font color=green size=4>首位双指针（快排思想）</font> | 时间复杂度： $O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 动图来自：[【题解】：首尾双指针，快慢双指针](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/)
>
> 快速排序思想见：[十大排序算法—这一篇远远不够](https://blog.csdn.net/qyb19970829/article/details/112971465)
>
> 基本实现就是通过，首位两个指针，判断左右奇偶性，只要确定目标就是把奇数把左边换，偶数往右边换即可！

![image-20210210121544080](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210210121544080.png)

![](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/f25bd8d3c3fd5d30969be2954685a21f67e254a6487c6d9d27edf6589a0fca55.gif)

```java
class Solution {
    public int[] exchange(int[] nums) {
        // 快速排序
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left < right && nums[right] % 2 == 0) right--;
            while(left < right && nums[left] % 2 != 0) left++;
            if(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }
}
```

<font color=green size=4>快慢双指针</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 动图来自：[【题解】：首尾双指针，快慢双指针](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/)

![image-20210210120054378](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210210120054378.png)

![](https://pic.leetcode-cn.com/f607c90cfd7578d65a24a6aa513297900b681cfb72563168532765b636fd0c55.gif)

```java
class Solution {
    public int[] exchange(int[] nums) {
        int slow = 0;
        int fast = 0;
        // slow确保slow指针及之前的数字都是奇数
        // fast指针用来寻找前方的奇数
        // 如果前方所有的奇数都被换到了左侧，即slow指针处，则整个数组必然是 左侧为奇数，右侧为偶数
        while(fast < nums.length){
            if(nums[fast] % 2 != 0){
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

