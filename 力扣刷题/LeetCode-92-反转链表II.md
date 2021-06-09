@[TOC](目录)

***

# 题目要求

**原题链接**：[92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转。

**说明:**
1 ≤ *m* ≤ *n* ≤ 链表长度。

**示例:**

```
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
```

***

# 解题过程

链表的题目，脑子里想象一下即可~

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode temp1 = null;
        ListNode temp2 = null;

        for(int i = 0; i < m - 2; i++){
            cur1 = cur1.next;
        }

        for(int i = 0; i < n - 1; i++){
            cur2 = cur2.next;
        }

        if(m == 1){
            temp1 = cur1;
        }else{
            temp1 = cur1.next;
            cur1.next = null;
        }

        temp2 = cur2.next;
        cur2.next = null;
        
        ListNode reverseList = reverse(temp1);
        temp1.next = temp2;

        if(m == 1) return reverseList;

        cur1.next = reverseList;

        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
```

