@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/) | [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

**示例 1：**

```
输入：[3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：[2,2,2,0,1]
输出：0
```

***

# 解题过程

<font color=green size=4>二分</font>

可参考：[面试题11. 旋转数组的最小数字（二分法，清晰图解）](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/)

该题旨在求解部分排序数组的最小值，虽然二分一般用于传统有序数组，但是只要是可以缩小问题规模，实施减治的都可以用二分。

```java
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            // [3,4,5,1,2]
            if(numbers[mid] > numbers[right]){
                // 此时最小值一定在右半区间
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){ // [5,6,1,2,3,4,5]
                // 此时最小值一定在左半区间
                right = mid;
            }else{ // 此时不确定具体的区间，缩小右区间即可
                right--;
            }
        }
        return numbers[left];
    }
}
```

