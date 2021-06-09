@[TOC](目录😎)

***

# 题目要求

**原题链接**：[605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)

假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

**示例 1**:

```
输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
```


**示例 2**:

```
输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
```


**注意**:

1. 数组内已种好的花不会违反种植规则。
2. 输入的数组长度范围为 [1, 20000]。
3. n 是非负整数，且不会超过输入数组的大小。

***

# 解题过程

<font color=green size=4>一次遍历</font>

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 记录花坛中可种植的数量
        int count = 0;
        // 记录花坛中地块的下标
        int index = 0;
        // 特殊情况判断
        if(n == 0) return true;
        while(index < flowerbed.length){
            // 如果当前的地块为1，则index+2，因为下一个地块也不能种花了
            if(flowerbed[index] == 1){
                index += 2;
            }else{// 此时地块为0
                // 此时可以种花需要满足两个条件：
                // 1. 当前地块为最后一个地块
                // 2. 下一个地块也是0
                if(index == flowerbed.length - 1 || flowerbed[index + 1] == 0){
                    count++;
                    if(count == n) return true;
                    index += 2;
                }else{ // 如果不满足上面的if条件，则说明下一个地块也为1，此时index+3
                    index += 3;
                }
            }
        }
        return false;
    }
}
```

