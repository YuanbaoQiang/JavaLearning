

@[TOC](目录🙊) 

***



# 题目要求

**原题链接**：[66. 加一](https://leetcode-cn.com/problems/plus-one/) 
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。

**示例 1**：

```
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
```


**示例 2**：

```
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
```


**示例 3**：

```
输入：digits = [0]
输出：[1]
```

**提示**：

- 1 <= digits.length <= 100
- 0 <= digits[i] <= 9

# 解题过程

```java
class Solution {
    public int[] plusOne(int[] digits) {
        // 因为最低位加1，可以默认初始的进位为1
        int carry = 1;
        for(int i = digits.length - 1; i > -1; i--){
            // 总和为sum
            int sum = digits[i] + carry;
            // 本位
            digits[i] = sum % 10;
            // 进位
            carry = sum / 10;
        }
        if(carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }else{
            return digits;
        }
    }
}
```

