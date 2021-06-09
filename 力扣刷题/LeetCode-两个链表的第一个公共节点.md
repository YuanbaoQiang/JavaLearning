---
title: LeetCode-两个链表的第一个公共节点（简单易懂双指针）
date: 2020-08-22 07:18:37
tags:
- Algorithm
- 单链表
- 指针
category: LeetCode
---



![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200822073052.png)



<!--more-->

# 题目要求

输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200822073435.png)

[c1,c2,c3]即为所得，无交集则返回null。



原题链接：[剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

# 解题过程

排除特殊情况：比如有一个节点为空，两个长度不同的链表要想有公共节点，则公共节点及以后的长度都是一样的。那很容易想到的就是让这两个节点在长度相同的情况下进行同时遍历比较，<font color = orange size = 5>把多出的部分砍掉</font>，因为没有可比性🤓。如果对于A、B两个单链表，A比B多两个节点，则只需要将`headB`和`headA.next.next`同时开始比较即可。

## 双指针

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lenA = size(headA); // headA的长度
        int lenB = size(headB); // headB的长度
        int delta = lenA - lenB; // 两个单链表的长度差

        ListNode curA = headA; // 指针A
        ListNode curB = headB; // 指针B

        return res(delta,curA,curB);

    }


    // 方法一：
    // 计算链表长度
    public int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    // 方法二：
    // 对于长度相同的情况
    // 双指针判断，节点是否相同，相同则return
    public ListNode isEqual(ListNode nodeA, ListNode nodeB){
        while(nodeA != null){
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
            
    }

    // 方法三：
    // 校位操作
    // 将较长的链表长度，调整至与短链表相同
    public ListNode modify(int delta, ListNode node){
        for(int i = 0; i < Math.abs(delta); i++){
            node = node.next; // 后移|delta|个节点
        }
        return node;
    }

    // 方法四：
    // 输出结果
    public ListNode res(int delta, ListNode nodeA, ListNode nodeB){
        if(delta < 0){ // 此时headB长，调用modify方法
            ListNode modifyCurB = modify(delta,nodeB);
            return isEqual(nodeA,modifyCurB);
        }else{// 此时headA长，调用modify方法
            ListNode modifyCurA = modify(delta,nodeA);
            return isEqual(modifyCurA,nodeB);
        }
    }

}
```

