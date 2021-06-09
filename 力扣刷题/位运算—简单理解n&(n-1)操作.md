> 博客内容更新至lc题解：[【位运算】简单理解n & (n - 1)操作](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/wei-yun-suan-jian-dan-li-jie-n-n-1cao-zu-uaec/)
>
> 来源于一道简单面试题：[LeetCode-剑指offer-15-二进制中1的个数](https://blog.csdn.net/qyb19970829/article/details/113359653)

# n

随便一个n：

![剑指offer-15-二进制中1的个数01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-15-%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD1%E7%9A%84%E4%B8%AA%E6%95%B001.jpeg)



# n - 1

那么n - 1会发生什么：

对于上面随便给的一个n，减去1，但是低2位都是0，减1必然需要借位，那何时结束呢？答案就是遇到1的时候。如果第一步骤中给的n末尾为1，那么就直接在低位就结束了，**也符合遇到1就停止的规则**！

总结而言，n - 1操作：

1.**无论是借位，还是减1，遇到1就停止**；

2.**从低位到高位，一直到1，每一位都发生了反转**。

![剑指offer-15-二进制中1的个数02](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-15-%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD1%E7%9A%84%E4%B8%AA%E6%95%B002.jpeg)



# n & (n - 1)

通过前两步的简单解释，不难理解最后的&操作，就**将之前发生过反转的位都变成**啦，之后就循环 n - 1， n & (n - 1)操作就可以很很简单的计算出二进制位中1的个数。**每一次操作，都是遇到1就结束，所以每一次操作都对应有一个1**.直到n的所有位都变成了0，说明计算结束。



*![剑指offer-15-二进制中1的个数05](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-15-%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD1%E7%9A%84%E4%B8%AA%E6%95%B005.jpeg)*