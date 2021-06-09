# 题目要求

**原题链接**：[316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/)

给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

**注意**：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

**示例 1**：

```
输入：s = "bcabc"
输出："abc"
```


**示例 2**：

```
输入：s = "cbacdcbc"
输出："acdb"
```


**提示**：

- 1 <= s.length <= $10^4$
- s 由小写英文字母组成

# 解题过程

可以参考：[一看就会，就差手把手教你写了](https://leetcode-cn.com/problems/remove-duplicate-letters/solution/yi-kan-jiu-hui-jiu-chai-shou-ba-shou-jia-miqw/)

维护一个单调栈，满足以下的条件，就可以将栈顶元素去掉。

1. 栈不为空
2. 栈顶元素 相对于 当前遍历的元素 要靠后一些
3. 栈顶元素  在之后的遍历中还会遇到

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        // 记录字符串中每个字母的个数
        int[] count = new int[26];
        // 记录字符串中字母是否在栈中出现过
        boolean[] exists = new boolean[26];
        // 遍历 记录每个字母出现的次数
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // 如果当前元素在栈结构中没有出现过
            if(!exists[ch - 'a']){
                // 栈不为空  &&   栈顶的元素相对靠后  && 栈顶元素在之后的遍历中还会出现
                while(!deque.isEmpty() && deque.getLast() > ch && count[deque.getLast() - 'a'] > 0){
                    // 将栈顶的元素在栈中的出现状态更新为false（即将被remove）
                    exists[deque.getLast() - 'a'] = false;
                    // 去除尾端元素deque.removeLast();
                    deque.removeLast();
                }
                deque.add(ch);
                exists[ch - 'a'] = true;
            }
            count[ch - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : deque){
            sb.append(ch);
        }
        return sb.toString();
    }
}
```

