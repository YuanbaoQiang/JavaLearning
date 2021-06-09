# 题目要求

**原题链接**：[290. 单词规律](https://leetcode-cn.com/problems/word-pattern/)

给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

**示例1**:

```
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
```


**示例 2**:

```
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
```


**示例 3**:

```
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
```


**示例 4**:

```
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
```



# 解题过程

**哈希表**

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] chArr = pattern.toCharArray();
        Map<Character,String> map = new HashMap<>();
        String[] sArr = s.split(" ");
        if(chArr .length != sArr.length) return false;
        for(int i = 0; i < chArr.length; i++){
            // key存在的情况
            if(map.containsKey(chArr[i])){
                if(!map.get(chArr[i]).equals(sArr[i])) return false;
            }else{
                // 此时key不存在
                // 如果两个value的值相同，则false
                if(map.containsValue(sArr[i])) return false;
                map.put(chArr[i], sArr[i]);
            }
        }
        return true;                          
    }
}
```

