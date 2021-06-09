# 题目要求

原题链接：[33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

给你一个整数数组 nums ，和一个整数 target 。

该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。

请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

**示例 1**：

```
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
```


**示例 2**：

```
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
```


**示例 3**：

```
输入：nums = [1], target = 0
输出：-1
```

**提示**：

- 1 <= nums.length <= 5000
- -$10^4$<= nums[i] <= $10^4$
- nums 中的每个值都 独一无二
- nums 肯定会在某个点上旋转
- $-10^4$ <= target <= $10^4$

# 解题过程

**二分法**

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 先找到旋转点
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){ // 如果nums[mid] < nums[right]，则说明mid的右侧是有序的
             
                if(nums[mid] < target && target <= nums[right]){ // 如果此时tartget在右侧的有序范围内，则此时的left需要改成mid + 1
                    left = mid + 1;
                }else{ // 如果此时tartget不在右侧的有序范围内，则此时的right需要改成mid-1
                    right = mid - 1;
                }
            }else{ // 如果nums[mid] > nums[right], 此时说明mid的左侧是有序的
                if(nums[left] <= target && target < nums[mid]){ // 如果此时tartget在左侧的有序范围内，则此时的right需要改成mid - 1
                    right = mid - 1;
                }else{ // 如果此时tartget不在左侧的有序范围内，则此时的left需要改成mid +1
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
```



