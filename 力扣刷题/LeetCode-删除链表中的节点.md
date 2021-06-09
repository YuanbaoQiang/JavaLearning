---
title: LeetCode-删除链表中的节点
date: 2020-08-21 15:04:00
tags:
- Algorithm
- 单链表
- 指针
category: LeetCode
---

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821151143.png)

<!--more-->

# 题目要求

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

> 输入: head = [4,5,1,9], val = 5
> 输出: [4,1,9]
> 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.



> 输入: head = [4,5,1,9], val = 1
> 输出: [4,5,9]
> 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.



题目来源：[剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

# 解题过程

单链表中删除一个节点，无非就是让待删除的节点的<font color = orange size =5>前一个节点指向目标节点的后一个节点</font>。遍历单链表是要注意记录目标节点的前一个节点即可。在这点上单指针和双指针达到的效果是一致的。

## 单指针

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur;
        for(cur = head; cur.next != null;cur = cur.next){
            //cur指针指向head，如果待删除的节点为head节点，则头节点往后移，并返回head
            if(cur.val == val){
                head = cur.next;
                return head;
            }

            //cur指针后移，如果遇到符合条件的节点，
            // 则将cur的next指向待删除节点的后一个节点
            if(cur.next.val == val){
                cur.next = cur.next.next;
                return head;
            }
            
        }
        return head;
    }
}
```

## 双指针

![image-20200821155905642](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821160445.png)



```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // head为null，返回null
        if(head == null) return null;
        // head为要删除的节点，返回head.next
        if(head.val == val) return head.next;

        // 定义两个指针 cur 和 pre
        // cur --> 当前节点
        // pre --> 当前节点的前一个节点
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null){
            pre = cur; // 将cur节点赋值给pre节点
            cur = cur.next; // cur节点后移
            if(cur.val == val){ // cur节点的值为所要删除的节点值
                pre.next = cur.next;
                return head;
            }
        }
        return head;
    }
    
}
```

