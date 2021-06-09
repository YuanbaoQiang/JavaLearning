@[TOC](目录)

***

# 题目要求

**原题链接**：[6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)

将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

**示例 1**：

```
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```

**示例 2**：

```
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例 3**：

```
输入：s = "A", numRows = 1
输出："A"
```


提示：

- 1 <= s.length <= 1000
- s 由英文字母（小写和大写）、',' 和 '.' 组成
- 1 <= numRows <= 1000

***

# 解题过程

可参考：[Z 字形变换（清晰图解）](https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/)

给定`numRows`层，则每一层`list.add(new StringBuilder())`

遍历给定的字符串`s`，将对应的字符添加到对应层中的`StringBuilder`中，其中采用`flag`字段，控制Z形变换（到边界处需要切换方向）~

```java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) list.add(new StringBuilder());
        char[] chArr = s.toCharArray();
        int flag = -1;
        int i = 0;
        for(Character ch : chArr){
            list.get(i).append(ch);
            if(i == 0 || i == numRows - 1) flag *= -1;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            res.append(sb.toString());
        }        
        return res.toString();
    }
}
```

