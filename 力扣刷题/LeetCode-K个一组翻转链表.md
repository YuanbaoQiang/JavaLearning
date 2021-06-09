@[TOC](目录)

***

# 题目要求

**原题链接**：[25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

**说明：**

- 你的算法只能使用常数的额外空间。
- **你不能只是单纯的改变节点内部的值**，而是需要实际进行节点交换。

***

# 解题过程

<font color=green size=4>递归</font>

```java
class Solution {
    ListNode cur = null;
    ListNode temp = null;
    // 哨兵节点
    ListNode dummyNode = new ListNode(0);
    // 哨兵节点的指针
    ListNode curDummyNode = dummyNode;
    // 定义每次翻转后的链表头结点
    ListNode reverseHead = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果传入进来的头部节点为空，则返回结果dummyNode.next
        if(head == null) return dummyNode.next;
        // cur为传入进来的head的指针
        cur = head;
        // 链表指针 移动k-1次
        for(int i = 0; i < k - 1; i++){;
            cur = cur.next;
            // 如果 cur == null，则此时是最后一个分段
            if(cur == null){
                curDummyNode.next = head;
                // 此时需要传入到递归函数中的头结点就是cur
                return reverseKGroup(cur, k);
            }
        }
        // 保存下一次循环的头结点
        temp = cur.next;
        // 防止链表成环
        cur.next = null;
        // 经过反转后，reverHead为头结点，而原本的head节点为 现在reverHead链表的尾节点
        reverseHead = reverse(head);
        // 利用哨兵节点指针  指向  反转后 链表的头部
        curDummyNode.next = reverseHead;
        // 更新哨兵节点的位置
        curDummyNode = head;
        // 递归，此时存入保存的temp头结点
        return reverseKGroup(temp, k);
    }

    // 链表反转
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
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

