---
title: LeetCode-反转单链表（头插法、双指针、辅助栈）
date: 2020-08-21 16:09:01
tags:
- Algorithm
- 单链表
- 指针
- 栈
category: LeetCode
---



![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821200147.png)

<!--more-->

# 题目要求

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

> 输入: 1->2->3->4->5->NULL
> 输出: 5->4->3->2->1->NULL

原题链接：[剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

# 解题思路

废话不多说，直接画图肝就行，遇到这种题，画个三四个节点，敲着代码，脑海里有个图解过程就会好很多。题刷多了，图画多了做题就会有感觉了~~对于指针的运用目前还不熟，但感觉如果是双指针的话，无非一个后移，然后另外一个追上这个指针，反复循环。

后期在做总结，指针部分也可参考[LeetCode-删除链表中的节点（单双、指针实现）](https://blog.csdn.net/qyb19970829/article/details/108149341)。

> ps：ppt画图真的好累😫



## 辅助栈



![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821194937.png)



```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        
        // 将head的节点全部压入栈
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();// 定义一个newHead
        ListNode tmp = newHead; // 定义一个tmp指针

        while(!stack.isEmpty()){
            ListNode cur = stack.pop(); // 定义cur指针指向出栈的节点
            tmp.next = cur;//将tmp指向cur
            tmp = cur;//tmp指针后移
        }
        // tmp.next = null;
        return newHead;
    }

}
```



## 双指针

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821165500.png)

```java
class Solution {
	public ListNode reverseList(ListNode head) {
		//申请节点，pre和 cur，pre指向null
		ListNode pre = null;
		ListNode cur = head;
		ListNode tmp = null;
		while(cur!=null) {
			tmp = cur.next;//记录当前节点的下一个节点
			cur.next = pre;//然后将当前节点指向pre
			pre = cur;//pre节点后移一位
			cur = tmp;//cur节点后移一位
		}
		return pre;
	}
}
```



## 头插法

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200821163423.png)

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dum = new ListNode(0);

        // head为空或者只有head这一个节点，直接返回
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next; // next 指向cur的后一个节点
            cur.next = dum.next; // cur指向dum2的next位置
            dum.next = cur; // dum2 指向cur节点
            cur = next; // 节点后移
        }

        return dum.next;
    }

}
```

