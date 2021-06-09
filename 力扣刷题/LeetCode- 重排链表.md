#### [143. 重排链表](https://leetcode-cn.com/problems/reorder-list/)

给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

**示例 1:**

```
给定链表 1->2->3->4, 重新排列为 1->4->2->3.
```

**示例 2:**

```
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
```

**代码**

```java
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        // 1. 寻找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 断开中点，反转后半段链表
        ListNode head2 = null;
        ListNode next = slow.next;
        slow.next = null;
        slow = next;
        while(slow != null){
            next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        // 3. 将head和head2进行拼接
        ListNode curr = head;
        ListNode curr2 = head2;
        while(curr != null && curr2 != null){
            next = curr.next;
            curr.next = curr2;
            curr2 = curr2.next;
            curr.next.next = next;
            curr = next;
        }
    }
}
```