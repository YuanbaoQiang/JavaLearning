@[TOC](目录)

# 题目要求

**原题链接：**

给你链表的头结点 `head` ，请将其按 **升序** 排列并返回 **排序后的链表** 。

**进阶：**

- 你可以在 `O(n log n)` 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

**示例 1：**

![](https://i.loli.net/2021/01/24/zgJ34VuetFwncY6.jpg)

```
输入：head = [4,2,1,3]
输出：[1,2,3,4]
```

**示例 2：**

![](https://i.loli.net/2021/01/24/O58iFUpfgKvwNHG.jpg)

```
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
```

**示例 3：**

```
输入：head = []
输出：[]
```



**提示：**

- 链表中节点的数目在范围 `[0, 5 * 10^4]` 内
- `-10^5 <= Node.val <= 10^5`



***

# 解题过程

<font color=green size=4>归并排序</font>

![反转链表](https://i.loli.net/2021/01/24/CF4PeRfY7kyEnpL.jpg)

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // 使用快慢指针寻找链表中点
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表拆分为二
        ListNode head1 = sortList(slow.next);
        slow.next = null;
        ListNode head2 = sortList(head);

        return merge(head1, head2);
    }

    // 将两个有序链表进行合并
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(0);
        ListNode curDummyNode = dummyNode;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                curDummyNode.next = head1;
                head1 = head1.next;
            }else{
                curDummyNode.next = head2;
                head2 = head2.next;
            }
            curDummyNode = curDummyNode.next;
        }

        while(head1 != null){
            curDummyNode.next = head1;
            head1 = head1.next;
            curDummyNode = curDummyNode.next;
        }

        while(head2 != null){
            curDummyNode.next = head2;
            head2 = head2.next;
            curDummyNode = curDummyNode.next;
        }
        return dummyNode.next;
    }
}
```

