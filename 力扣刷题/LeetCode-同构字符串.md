@[TOC](目录😲)

***

# 题目要求

**原题链接**：[205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/) 

给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以被替换得到 t ，那么这两个字

符串是同构的。所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射

到同一个字符上，但字符可以映射自己本身。

**示例 1**:

```
输入: s = "egg", t = "add"
输出: true
```

**示例 2**:

```
输入: s = "foo", t = "bar"
输出: false
```

**示例 3**:

```
输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
```

# 解题过程

<font color=green size=5>哈希表</font>

添加键值对之前需要做两次判断：

1. 存在该键时，判断是值是否重复
2. 不存在该键时，判断是否已经有相应的值了

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            // 存在键的时候 需要判断所对应的值 和 t.charAt(i)是否相同
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }else{
                // 不存在键的时候 在添加键值对之前，需要判断该值是否已经被占用了
                if(map.containsValue(t.charAt(i))) return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
```

