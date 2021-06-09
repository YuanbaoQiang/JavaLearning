---
title: LeetCode-奇偶链表
date: 2020-11-13 16:49:27
tags:
---

# 题目要求

**原题链接**：[328. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)

给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

**示例 1:**

```
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
```

**示例 2:**

```
输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
```

**说明:**

- 应当保持奇数节点和偶数节点的相对顺序。
- 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。



# 解题过程

**debug利器**：灵魂画手 + ppt

![](C:\Users\YuanbaoQiang\AppData\Roaming\Typora\typora-user-images\image-20201113165332120.png)

![image-20201113165243736](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20201113165243.png)

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 特殊条件判断
        if(head == null || head.next == null) return head;
        ListNode oddNode  = head;
        ListNode evenNode = head.next;
        ListNode dummyNode1 = new ListNode(0);
        dummyNode1.next = oddNode;
        ListNode dummyNode2 = new ListNode(0);
        dummyNode2.next = evenNode;

        while(evenNode != null){
            oddNode.next = evenNode.next;
            // 如果是节点数为偶数时需要判断一下！并且偶数节点next要置为null
            if(oddNode.next == null){
                evenNode.next = null;
                break;
            }
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = dummyNode2.next;
        return dummyNode1.next;
    }
}
```

