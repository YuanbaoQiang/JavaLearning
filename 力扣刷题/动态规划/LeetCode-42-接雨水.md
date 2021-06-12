# LeetCode-42-接雨水

# 题目要求

**原题链接**：[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)，同[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)类似

给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png)

```
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
```


示例 2：

```
输入：height = [4,2,0,3,2,5]
输出：9
```


提示：

+ $n == height.length$
+ $0 <= n <= 3 * 10^4$
+ $0 <= height[i] <= 105$



# 代码

## 代码1-单调递减栈

**参考**：[【接雨水】单调递减栈，简洁代码，动图模拟](https://leetcode-cn.com/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/)

```java
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int cur = stack.peek();
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[cur];
                res += (right - left - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }
}
```

