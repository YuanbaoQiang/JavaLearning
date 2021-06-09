@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

**示例 1**:

```
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

**说明**：

- 用返回一个整数列表来代替打印
- n 为正整数

***

# 解题过程

**不考虑大数**

<font color=green size=4>直接创建$10^n - 1$容量的数组</font> | 时间复杂度：$O(10^n)$ | 空间复杂度：$O(10^n)$

> $10^n - 1$很容易会超出 int32 整型的取值范围，超出取值范围的数字无法正常存储。但由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。



![image-20210208131343508](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208131343508.png)



```java
class Solution {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            res[i] = i + 1;
        }
        return res;
    }
}
```

***

**考虑大数的情况（需要掌握）**

<font color=green size=4>字符串模拟</font> | 时间复杂度：$O(10^n)$ | 空间复杂度：$O(10^n)$

> 1. 对于n个位，初始化长度为n的字符串，全部为0
> 2. 对字符串模拟加1操作，需要考虑是否进位

```java
class Solution {
    public int[] printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            sb.append('0');
        }

        while(!increment(sb)){
            // 去除左边的0
            int index = 0;
            while(index < sb.length() && sb.charAt(index) == '0'){
                index++;
            }
            int value = Integer.parseInt(sb.toString().substring(index));
            list.add(value);
        }

        int[] res = new int[list.size()];

        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }

        return res;
    }


    public boolean increment(StringBuilder sb){
        boolean isOverflow = false;
        for(int i = sb.length() - 1; i >= 0; i--){
            char ch = (char) (sb.charAt(i) + 1);
            // 如果发生了进位
            if(ch > '9'){
                sb.replace(i, i + 1, "0");
                // 如果此时已经是最高位了，说明发生了进位溢出
                if(i == 0){
                    isOverflow = true;
                }
            }else{ // 如果没有发生进位
                sb.replace(i, i + 1, String.valueOf(ch));
                break;
            }
        }
        return isOverflow;
    }
}
```

<font color=green size=4>回溯-全排列</font> | 时间复杂度：$O(10^n)$ | 空间复杂度：$O(10^n)$ 

> 全排列，还算是基本的递归回溯过程，可以参考我的博客记录：
>
> [三张图简单理解回溯算法](https://blog.csdn.net/qyb19970829/article/details/113665450)
>
> [回溯算法-层次化理解回溯过程](https://blog.csdn.net/qyb19970829/article/details/113727380)

```java
class Solution {
    List<Integer> list = new LinkedList<>();
    public int[] printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, sb, 0);
        list.remove(0);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    // 递归、回溯题请你画图！！！！把树画出来，接下来就是很简单的操作！
    // 1. n为递归树的最大深度
    // 2. sb为缓存变量，需要传递
    // 3. depth为0，递归调用的起点，每次递归都需要深度 + 1
    public void dfs(int n, StringBuilder sb, int depth){
        // 如果深搜达到了最大的深度，则为递归的出口条件
        if(depth == n){
            int value = Integer.parseInt(sb.toString());
            list.add(value);
            return;
        }

        for(int i = 0; i < 10; i++){
            sb.append(i);
            dfs(n, sb, depth + 1);
            // 这个操作是递归结束的时候，需要完成的遗留下来的操作，目的是返回上一层的树节点的同时，可以恢复该节点下的状态！
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

