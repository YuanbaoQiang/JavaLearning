@[TOC](目录😶)

***

# 题目要求

**原题链接**：[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

**示例 1**：

```
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值

---------------               -----

[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

**示例 2**：

```
输入：nums = [1], k = 1
输出：[1]
```


**示例 3**：

```
输入：nums = [1,-1], k = 1
输出：[1,-1]
```


**示例 4**：

```
输入：nums = [9,11], k = 2
输出：[11]
```


**示例 5**：

```
输入：nums = [4,-2], k = 2
输出：[4]
```

**提示**：

- 1 <= nums.length <= $10^5$
- $-10^4$ <= nums[i] <= $10^4$
- 1 <= k <= nums.length

***

# 解题过程

<font color=green size=4>单调队列</font>

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //特殊条件判断
        if(nums == null || nums.length < 2) return nums;
        // 定义存放结果集的数组
        int[] res = new int[nums.length - k + 1];
        // 定义一个双向队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            // 依次进双向队列，保持队列头部为最大值
            // 添加内容为数组元素的下标
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            // 添加元素，该元素小于队列尾部元素
            deque.addLast(i);
            // 判断队首的元素是否满足有效
            // 是否字窗口内
            // 当窗口右侧R=i，则窗口左侧L=i-k-1
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            // 当形成窗口时，保存最大值，即队首元素
            if(i + 1 >= k){
                res[i + 1 - k] =  nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
```

