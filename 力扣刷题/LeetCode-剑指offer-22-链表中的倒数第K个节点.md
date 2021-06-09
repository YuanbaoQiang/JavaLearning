@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 2 个节点是值为 4 的节点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```

***

# 解题过程

<font color=green size=4>双指针</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 寻找倒数第k个节点，不需要知道原本的链表长度。
>
> 只需要定义两个指针，first和second，first比second先走k步，然后两者一起走即可~first走到尽头的时候，first和second始终相差k，所以second为倒数第k个节点。



![image-20210209100232667](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210209100232667.png)

```java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = new ListNode();
        ListNode second = new ListNode();
        first = head;
        second = head;
        // 先让第一个指针往前走k步
        for(int i = 0; i < k; i++){
            first = first.next;
        }

        // 两个指针一起运动
        while(first != null){
            first = first.next;
            second = second.next;
        }

        // 返回second节点即可
        return second;
    }
}
```

