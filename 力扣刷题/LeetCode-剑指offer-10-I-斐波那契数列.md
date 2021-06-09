

@[TOC](目录)

***

# 题目要求

**原题链接**：

写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项（即 `F(N)`）。斐波那契数列的定义如下：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：1
```

**示例 2：**

```
输入：n = 5
输出：5
```



**提示：**

- `0 <= n <= 100`

***

# 解题过程

<font color=red size=4>未优化的递归</font> | 时间复杂度：$O(2^n)$ | 空间复杂度： $O(n)$| <font color=red>**不推荐**</font>

> 指数级别的时间复杂度，显然是不行的，所以需要优化！时间复杂度参考：[斐波那契数列的三种算法以及复杂度](https://blog.csdn.net/MallowFlower/article/details/78858553)

![image-20210205225128780](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205225128780.png)

```java
class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        return (fib(n - 1) + fib(n - 2));
    }
}
```

![img](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/20171212083453809)

![剑指offer-10-斐波那契数列01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-10-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%9701.jpeg)



<font color=green size=4>优化后的递归（记忆化递归/搜索）</font> |  时间复杂度：$O(n)$ | 空间复杂度： $O(n)$| <font color=green>**推荐**</font>

> 根据递归的顺序，可以将计算过的值保存，方便下次递归调用的时候检查，如果该值计算过，则直接剪枝返回。

![image-20210205222852677](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205222852677.png)



![剑指offer-10-斐波那契数列02](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-10-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%9702.jpeg)



```java
class Solution {
    int mod = 1000000007;
    int first = 0;
    int second = 0;
    int res = 0;
    public int fib(int n) {
        return recur(n, new HashMap<Integer, Integer>());
    }

    public int recur(int n, Map<Integer, Integer> map){
        if(n < 2) return n;
        // map中存在n，说明这个值已经计算过了
        if(map.containsKey(n)) return map.get(n);
        // 计算并且添加 n - 1节点的值
        first = recur(n - 1, map) % mod;
        map.put(n - 1, first);
        // 计算并且添加 n - 2节点的值
        second = recur(n - 2, map) % mod;
        map.put(n - 2, second);
        // 计算并且添加 n 节点的值
        res = (first + second) % mod;
        map.put(n, res);
        // 返回结果
        return res;
    }
}
```

除了用Map，也可以用数组来存存储计算过的值 | 时间复杂度：$O(n)$ | 空间复杂度：$O(n)$

![image-20210205223554630](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205223554630.png)

```java
class Solution {
    int mod = 1000000007;
    int first = 0;
    int second = 0;
    int res = 0;
    int[] arr = new int[101];
    
    public int fib(int n){
        if(n < 2) return n;
        if(arr[n] != 0) return arr[n];
        first = fib(n - 1) % mod;
        arr[n - 1] = first;
        second = fib(n - 2) % mod;
        arr[n - 2] = second;
        res = (first + second) % mod;
        arr[n] = res;
        return res;
    }
}
```



<font color=green size=4>优化后的递归（尾递归）</font> |  时间复杂度：$O(n)$ | 空间复杂度： $O(1)$| <font color=green>**推荐**</font>

> 之所以尾递归的方式要比传统递归的方式时间复杂度更低呢？
>
> 不同于传统的递归方式，尾递归在调用方法的时候，就将数据作为形参进行了缓存累加，作为下一次调用的输入，大大节省了开销。而**传统的递归产生的栈的层次像二叉树一样，以指数级增长**，但是现在栈的层次却像是数组，变成线性增长了，有点dp的味道。



![image-20210206000308116](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210206000308116.png)

![剑指offer-10-斐波那契数列04](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-10-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%9704.jpeg)





```java
class Solution {
    int mod = 1000000007;
    public int fib(int n) {
        return fib(n, 1, 1);
    }

    public int fib(int n, int first, int second){
        if(n < 2) return n == 0 ? 0 :first;
        return fib(n - 1, second % mod, (first + second) % mod);
    }
}
```





<font color=green size=4>未优化的动态规划</font> | 时间复杂度：$O(n)$ | 空间复杂度 ：$O(n)$ | <font color=green>**推荐**</font>

![image-20210205224742489](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205224742489.png)

```java
class Solution {
    int mod = 1000000007;
    public int fib(int n){
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            if(i < 2){
                dp[i] = i;
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
```

<font color=green size=4>优化的动态规划（空间压缩）</font> | 时间复杂度：$O(n)$| 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210205224620007](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205224620007.png)



```java
class Solution {
    int mod = 1000000007;
    public int fib(int n){
        int a = 0;
        int b = 1;
        int sum = 1;
        for(int i = 0; i < n; i++){
            sum = (a + b) % mod;
            a = b;
            b = sum;
        }
        return a;
    }
}
```

