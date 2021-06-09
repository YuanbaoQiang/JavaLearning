@[TOC](目录)

***

# 题目要求

**原题链接**：[86. 分隔链表](https://leetcode-cn.com/problems/partition-list/)

给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

**示例：**

```
输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
```

***

# 解题过程

<font color=green size=4>哨兵节点</font>

```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 存放小于3的节点
        ListNode dummyNode1 = new ListNode(0);
        // 存放大于等于3的节点
        ListNode dummyNode2 = new ListNode(0);
        ListNode cur1 = dummyNode1;
        ListNode cur2 = dummyNode2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                cur1.next = cur;
                cur1 = cur1.next;
                
            }else{
                cur2.next = cur;
                cur2 = cur2.next;
            }
            // 注意每次都需要将Head链表中的cur的next指向为null
            // 否则会出现环形链表的错误
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
        }
        cur1.next = dummyNode2.next;
        return dummyNode1.next;
    }
}
```

