@[TOC](目录)

***

# 题目要求

**原题链接**：[448. 找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)


给定一个范围在 1 ≤ a[i] ≤ *n* ( *n* = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, *n*] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为*O(n)*的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

**示例:**

```
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```

***

# 解题过程

<font color=green size=4>数组内部原地做标记</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$

> 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
> [4,3,2,-7,8,2,3,1] 
>
> [4,3,-2,-7,8,2,3,1]
> [4,-3,-2,-7,8,2,3,1]
> [4,-3,-2,-7,8,2,-3,1]
> [4,-3,-2,-7,8,2,-3,-1]
> [4,-3,-2,-7,8,2,-3,-1]
> [4,-3,-2,-7,8,2,-3,-1]
> [-4,-3,-2,-7,8,2,-3,-1]

![](/home/yuanbaoqiang/Nutstore Files/Nutstore/我的博客/力扣刷题/LeetCode-448-找到所有数组中消失的数字_md_files/image_20210204000806.png?v=1&type=image&token=V1:l6eJx2eCcAXxO_H31_iYsieh7xgPTDQZzHMnQCSJLvc)
```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex] > 0) nums[newIndex] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}
```

<font color=green size=4>创建一个额外空间</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(n)$

![](/home/yuanbaoqiang/Nutstore Files/Nutstore/我的博客/力扣刷题/LeetCode-448-找到所有数组中消失的数字_md_files/image_20210204001001.png?v=1&type=image&token=V1:-mox8YRI3yM2MnmgQ7DOkNUAJYenLXzbfMt-JYRhXfY)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        // 创建一个计数数组，下标为原数组元素
        int[] arr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += 1;
        }
        // 计数数组中元素为空的下标，即为消失的数字
        for(int i = 1; i < nums.length + 1; i++){
            if(arr[i] == 0) list.add(i);
        }
        return list;
    }
}
```

