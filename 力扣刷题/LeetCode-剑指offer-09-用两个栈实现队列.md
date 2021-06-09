@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

**示例 1**：

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2**：

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```


**提示**：

- 1 <= values <= 10000
- 最多会对 appendTail、deleteHead 进行 10000 次调用

***

# 解题过程

<font color=green size=4>按照题目要求使用两个栈</font> | 时间复杂度：$O(n)$ | 空间复杂度： $O(n)$ 

> **注意**：Java中的栈模拟一般用Deque，因为Satck继承于Vector类，而Vector是线程安全的，会影响性能，所以优先使用线程不安全的Deque类。

![image-20210205215655072](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210205215655072.png)

```java
class CQueue {
    // 1. 一开始两个栈都是空的
    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();

    public CQueue() {

    }
    // 2. 每次在末尾添加元素，都直接往stack1里压
    public void appendTail(int value) {
        stack1.push(value);
    }
    // 3. 弹出头部元素的时候，每次优先从stack2中开始弹出
    // （while循环的操作就是默认stack2中的栈顶元素就是队列的头部元素了，因为将stack1中的元素逆序存放在stack2中）
    public int deleteHead() {
        // stack2不为空，则一直从stack2弹出
        if(!stack2.isEmpty()) return stack2.pop();
        // 当stack2完全为空的时候，才可以将元素从stack1弹出再压入stack2
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        // 如果此时stack2还未空的话，说明stack1和stack2都没有元素了，即队里中没有元素
        if(stack2.isEmpty()) return -1;
        // 否则弹出stack2的栈顶元素
        else return stack2.pop();
    }
}
```

