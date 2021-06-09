@[TOC](目录)

***


# 原题链接

**原题链接**：[84. 柱状图中最大的矩形](84. 柱状图中最大的矩形)

给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够

勾勒出来的矩形的最大面积。

![](https://i.loli.net/2020/12/26/79JE6zP8ONc1rZj.png)

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

![](https://i.loli.net/2020/12/26/VFgNp2X5OLlGnux.png)

图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

示例:

```
输入: [2,1,5,6,2,3]
输出: 10
```



# 解题过程

<font color=green size=5>单调栈</font>

参考：[详解单调栈，🤷‍♀️必须秒懂！](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-jie-dan-diao-zhan-bi-xu-miao-dong-by-sweetie/)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 前后补0
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < tmp.length; i++){
            //  此时tmp[i] 为 第一个比栈顶元素小的元素
            //  该栈的元素 始终保持单调递增的状态，这也就是为什么在数组的前后都需要补0
            // 否则会始终无法进入while循环，出现无法pop()的情况
            // 当遍历到tmp[i]元素，并且发现栈顶的元素比它大，说明此时tmp[i]是栈顶元素的
            // 右边的第一个比它小的数字，所以栈顶的右边界就已经确定了
            // 由于有单调栈的特性，栈顶元素的左边界在当初push进去的时候就已经确定了
            // 所以此时可以计算面积了
            // 例如：加入栈底到栈顶依次有元素0,5,6,7,8,9,10 ,此时要加入一个1
            // 就会把栈就会一直pop 最后剩下0，此时的0对应的位置就是1的左边界
            // 等到下一次 push进去一个0.5，出现了第一个比1小的数字，则对于1来说，0.5就
            // 就是其右边界，而栈底元素0就是0.5的左边界
            while(!stack.isEmpty() && tmp[i] < tmp[stack.peek()]){
                int h = tmp[stack.pop()];
                res = Math.max(res, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return res;
    }
}
```

<font color=green size=5>暴力</font>

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            // 以heights[i]为中心元素，向两边遍历
            int left = i;
            int right = i;
            while(right < heights.length - 1 && heights[right + 1] >= heights[i]){   
                right++;
            }

            while(left > 0 && heights[left - 1] >= heights[i]){
                left--;
            }

            res = Math.max(res, heights[i] * (right - left +1));
        }
        return res;
    }
}
```