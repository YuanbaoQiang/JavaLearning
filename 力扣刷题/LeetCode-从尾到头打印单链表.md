---
title: LeetCode-从尾到头打印单链表
date: 2020-08-21 20:51:31
tags:
- Algorithm
- 单链表
- 指针
- 栈
category: LeetCode
---

# 题目要求

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

>  输入：head = [1,3,2]
> 输出：[2,3,1]

原题链接：[剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

<!--more-->

# 解题过程

解题过程和反转链表基本一致，可参考反转图解：[LeetCode-反转单链表（头插法、双指针、辅助栈）](https://blog.csdn.net/qyb19970829/article/details/108155596)

自己再写点方法，将链表数据存入数组输出即可。

```java
class Solution {
    public int[] reversePrint(ListNode head) {
        int[] arr = new int[size(head)];
        
        // 链表为空
        if(head == null) return arr;
        // 链只有一个节点
        if(head.next == null){
            return listToArray(arr,head);
        }

        // 以下操作就是反转单链表的操作
        // 可采用递归、双指针、辅助栈
        // 以下采用栈辅助方法
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();
        ListNode tmp = newHead;

        while(!stack.isEmpty()){
            ListNode cur = stack.pop();
            tmp.next = cur;
            tmp = cur;
        }

        tmp.next = null;
        
        // 将反转之后的newHead，作为形参，调用listToArray方法
        return listToArray(arr,newHead); 


    }

    // 将ListNode转成数组
    public int[] listToArray(int[] arr, ListNode head){
        for(int i = 0; i < arr.length; i++){
            arr[i] = head.val;
            head = head.next;
        }
        return arr;
    }

    // 获取ListNode的节点数
    public int size(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

}
```

