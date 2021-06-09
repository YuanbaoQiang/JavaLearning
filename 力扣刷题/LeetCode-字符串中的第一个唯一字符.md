@[TOC](目录🦁)

***

# 题目要求

**原题链接**：[387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

**示例：**

```
s = "leetcode"
返回 0

s = "loveleetcode"
返回 2
```

**提示：**你可以假定该字符串只包含小写字母。

# 解题过程

<font color=green size=5>两次遍历</font>

第一次遍历：通过一个数组，记录字符串中每一个字母出现的次数。

第二次遍历：如果当前的字符在计数数组中出现的次数为1，则该字母为所求字母的下标。

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        // 定义一个数组，记录每一个字母出现的次数
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        // 顺序遍历字符串，如果该字符串的个数为1，则直接返回该字符的下标
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
```

