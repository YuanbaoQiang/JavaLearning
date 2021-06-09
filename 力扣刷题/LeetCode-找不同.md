# 题目要求

**原题链接**：[389. 找不同](https://leetcode-cn.com/problems/find-the-difference/)

给定两个字符串 ***s*** 和 ***t***，它们只包含小写字母。

字符串 ***t\*** 由字符串 ***s\*** 随机重排，然后在随机位置添加一个字母。

请找出在 ***t*** 中被添加的字母。

**示例 1**：

```
输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
```

**示例 2**：

```
输入：s = "", t = "y"
输出："y"
```

**示例 3**：

```
输入：s = "a", t = "aa"
输出："a"
```

**示例 4**：

```
输入：s = "ae", t = "aea"
输出："a"
```

**提示**：

- 0 <= s.length <= 1000
- t.length == s.length + 1
- s 和 t 只包含小写字母

# 解题过程

记录字符串s中没有个字母的个数，遍历b，遇到一样的就字母个数减1。

**用数组维护26个字母的个数**

```java
class Solution {
    public char findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            if(counter[ch - 'a'] == 0) return ch;
            counter[ch - 'a']--;
        }
        return ' ';
    }
}
```

**用哈希表维护**

```java
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char res = ' ';
        for(int i = 0; i < t.length(); i++){
            // 如果此时map中不存在该字母，则直接返回
            if(!map.containsKey(t.charAt(i))) return t.charAt(i);
            // 此时字母存在于map中
            // 如果此时的键对应的值已经为0，说明该字母是后来新添加的
            if(map.get(t.charAt(i)) == 0){
                res = t.charAt(i);
                break;
            }
            // 每次遍历，都需要将对应的值-1
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        return res;
    }
}
```

