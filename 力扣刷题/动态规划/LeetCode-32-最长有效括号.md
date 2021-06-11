# 题目要求

**原题链接**：[32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)

给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

**示例 1**：

```
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
```

**示例 2**：

```
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
```

**示例 3**：

```
输入：s = ""
输出：0
```

**提示**：

+ 0 <= `s.length` <= $3 * 10^4$
+ `s[i]` 为 `'('` 或 `')'`

---



# 代码

```java
class Solution {
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 1; i < len; i++){
            // ( ( ) ) ( )
            // 0 0 2 4 0 6
            if(s.charAt(i) == ')'){
                
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }
}
```

