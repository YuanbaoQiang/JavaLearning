@[TOC](目录🙁)

***



# 题目要求

**原题链接**：[1046. 最后一块石头的重量](https://leetcode-cn.com/problems/last-stone-weight/)

有一堆石头，每块石头的重量都是正整数。每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

- 如果 x == y，那么两块石头都会被完全粉碎；

- 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。

  最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

# 解题过程

<font color=green size=4>排序</font>

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        int stoneCount = stones.length;
        int lastOneIndex = stoneCount - 1;
        int lastTwoIndex = stoneCount - 2;
        // 先对数组排序
        Arrays.sort(stones);
        while(stoneCount > 1){
            // 如果最后两个石头相同重量，则都粉碎
            if(stones[lastOneIndex] == stones[lastTwoIndex]){
                stones[lastOneIndex] = 0;
                stones[lastTwoIndex] = 0;
                stoneCount -= 2;
            }else{
            // 否则，倒数第二个被粉碎，最后一个为差值
                stones[lastOneIndex] = stones[lastOneIndex] - stones[lastTwoIndex];
                stones[lastTwoIndex] = 0;
                stoneCount -= 1;
            }
            Arrays.sort(stones);
        }
        // stoneCount = 0 说明石头全部被粉碎了
        // stoneCount = 1 说明石头还有一个没被粉碎
        return stoneCount == 0 ? 0 : stones[lastOneIndex];
    }
}
```

