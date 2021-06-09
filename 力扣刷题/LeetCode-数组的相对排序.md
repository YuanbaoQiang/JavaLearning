---
title: LeetCode-数组的相对排序
date: 2020-11-14 18:55:30
tags:
---

# 题目要求

**原题链接**：[1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)

给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

**示例：**

```
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
```

**提示：**

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

# 解题过程

```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] res = new int[arr1.length];
        int max = 0;

        // 对arr1中的元素进行计数
        for(int i = 0; i < arr1.length; i++){
            bucket[arr1[i]]++;
        }

        // 处理arr2中的元素
        int index = 0;
        for(int i = 0; i < arr2.length; i++){
            while(bucket[arr2[i]] > 0){
                res[index++] = arr2[i];
                bucket[arr2[i]]--;
            }
        }

        // 此时已经有了排序，因为bucket数组中的元素
        // 按照从小到大的顺序进行遍历，则先取出来的就是 较小的数
        for(int i = 0; i < bucket.length; i++){
            while(bucket[i] > 0){
                res[index++] = i;
                bucket[i]--;
            }
        }
        return res;
    }
}
```

我之前的垃圾解法也顺便记录一下：

```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[arr1.length];
        int[] helper = new int[1001];
        // 遍历arr1获取每个元素在数组中出现的次数
        for(int num : arr1){
            // 利用map进行计数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历arr2，按照arr2的顺序进行排序arr1
        int k = 0;
        int m = 0;
        for(int i = 0; i < arr2.length; i++){
            int count = map.get(arr2[i]);
            for(int j = 0; j < map.get(arr2[i]); j++){
                res[k] = arr2[i];
                k++;
                count--;
            }
            map.put(arr2[i],count);
        }
        
        
        // 遍历map获取，不重复的数字，将其填充在helper数组中
        int end = 0;
        for(Integer key : map.keySet()){
            int aaa = map.get(key);
            end += aaa;
            while(aaa > 0){
                helper[m] = key;
                m++;
                aaa--;
            }
        }

        // 将不重合的数排序，放在res后面
        Arrays.sort(helper, 0, end);
        for(int i = 0; i < end; i++){
            res[k] = helper[i];
            k++;
        }

        return res;
    }
}
```

