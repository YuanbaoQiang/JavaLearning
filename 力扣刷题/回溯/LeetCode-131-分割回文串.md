# 题目要求

**原题链接**：[131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)

给你一个字符串 `s`，请你将 `s` 分割成一些子串，使每个子串都是 **回文串** 。返回 `s` 所有可能的分割方案。

**回文串** 是正着读和反着读都一样的字符串。

**示例 1**：

```
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
```

**示例 2**：

```
输入：s = "a"
输出：[["a"]]
```

**提示**：

+ $1 <= s.length <= 16$
+ s 仅由小写英文字母组成

----



# 代码

## 代码1

![image-20210613080536738](https://raw.githubusercontent.com/YuanbaoQiang/PicGoBed/master/img/image-20210613080536738.png)

**参考**：

+ [回溯算法、优化（使用动态规划预处理数组）](https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/)

```java
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        char[] chArr = s.toCharArray();
        List<List<String>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs(chArr, 0, len, stack, res);
        return res;
    }

    public void dfs(char[] chArr, int index, int len, Deque<String> path, List<List<String>> res){
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < len; i++){
            // 首先判断当前截取的子串是不是回文串
            if(!check(chArr, index, i)){
                continue;
            }
            path.addLast(new String(chArr, index, i + 1 - index));
            dfs(chArr, i + 1, len, path, res);
            path.removeLast();
        }
    }

    // 用于检查字符串是否是回文串
    public boolean check(char[] chArr, int left, int right){
        while(left < right){
            if(chArr[left] != chArr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

