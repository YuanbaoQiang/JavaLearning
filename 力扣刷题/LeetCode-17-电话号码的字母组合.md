@[TOC](目录)

***

# 题目要求

**原题链接**：[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

**示例 1**：

```
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
```


**示例 2**：

```
输入：digits = ""
输出：[]
```


**示例 3**：

```
输入：digits = "2"
输出：["a","b","c"]
```

**提示**：

```
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
```



# 解题过程

<font color=green size=4>标准回溯</font> | 时间复杂度： $O(3^M \times 4^N)$| 空间复杂度： $O(3^M \times 4^N)$

> M为三个字母所占的号码数
>
> N为四个字母所占的号码数

![image-20210212131618642](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210212131618642.png)



![LeetCode-17-电话号码的字母组合01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/LeetCode-17-%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%8801.jpeg)

```java
class Solution {
    List<String> res = new LinkedList<>();
    // 号码与字母的映射表
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    public void dfs(String digits, StringBuilder sb, int depth){
        if(depth == digits.length()){
            res.add(sb.toString());
            return;
        }
        // 找到对应的电话号码
        int number = digits.charAt(depth) - '0';
        // 找到对应号码的字符串
        String str = letter_map[number];

        for(int i = 0; i < str.length(); i++){
            // 操作
            sb.append(str.charAt(i));
            // 深搜
            dfs(digits, sb, depth + 1);
            // 删除最后一次的操作，返回上一层递归的状态
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

