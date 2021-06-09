---
title: LeetCode-独一无二的数
date: 2020-10-28 21:48:33
tags:
---

# 题目要求

**原题链接**：[1207. 独一无二的出现次数](https://leetcode-cn.com/problems/unique-number-of-occurrences/)

给你一个整数数组 `arr`，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 `true`；否则返回 `false`。

**示例 1：**

```
输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
```

**示例 2：**

```
输入：arr = [1,2]
输出：false
```

**示例 3：**

```
输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
输出：true
```

# 解题过程

**Map+Set**

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // 用于存放每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        // 新建set集合（通过set可以存放重复值的特性，来进行判断）
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()){
            set.add(x.getValue());
        }
        return map.size() == set.size();
    }
}
```

**排序+遍历**

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int lastCount = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int count = 1;
            while(arr[i] == arr[i+1]){
                count++;
                i++;
                if(i == arr.length - 1){
                    break;
                }
            }
            if(list.contains(count)){
                return false;
            }
            list.add(count);
            lastCount = count;
        }
        // 判断最后一个数字和倒数第二个数是否相同
        if(arr[arr.length - 1] == arr[arr.length - 2]){
            return true;
        }else{
            return !list.contains(1);
        }
    }
}
```

