# 题目要求

**原题链接**：[738. 单调递增的数字](https://leetcode-cn.com/problems/monotone-increasing-digits/)

给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

**示例 1:**

```
输入: N = 10
输出: 9
```

**示例 2:**

```
输入: N = 1234
输出: 1234
```

**示例 3:**

```
输入: N = 332
输出: 299
```

**说明:** `N` 是在 `[0, 10^9]` 范围内的一个整数。

# 解题过程

参考：[Java O(logN) 不需要转字符串，不需要栈，超过100%](https://leetcode-cn.com/problems/monotone-increasing-digits/solution/java-ologn-bu-xu-yao-zhuan-zi-fu-chuan-b-b7lk/)

对于一个数字<font color=red>7</font><font color=blue>6</font><font color=gree>8</font><font color=orange>6</font>，判断低位数字是否比前一个高位数字大，如果大于等于，则继续下一次循环，如果小于，则借位，高位后的位数全部替换为9。

<font color=gree>8</font> > <font color=orange>6</font> --> <font color=gree>7</font><font color=orange>9</font> (<font color=red>7</font><font color=blue>6</font><font color=gree>7</font><font color=orange>9</font>)

<font color=red>7</font> > <font color=blue>6</font> --> <font color=red>6</font><font color=blue>9</font><font color=gree>9</font><font color=orange>9</font>

```java
class Solution {
    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        int seed = 1;
        while(N > 0){
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if(high > num){
                // 从high + 1的位置到最末位，都变成9
                res = seed*10 - 1;
                // 最高位到high的数字 - 1
                N -= 1;
            }else{
                res = num * seed  + res;
            }
            seed *= 10;
        }
        return res;
    }
}
```

