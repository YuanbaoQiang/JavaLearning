---
title: LeetCode-两数相加
date: 2020-11-29 21:39:53
tags:
---

# 题目要求

**原题链接**：[2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

# 解题过程

将两个链表当作相同长度的链表处理，遇到null值，补0

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        // while循环条件：两个链表不同时为null
        while(!(cur1 == null && cur2 == null)){
            // 如果有节点为null，则补0
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            int sum = x + y + carry;

            // 注意 此时进位数的计算要在下面那个赋值操作的前面
            carry = sum / 10;
            sum = sum % 10;
            
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }
        // 如果运算到最后发现还有进位数，说明上一次的操作和是大于10的，存在一个进位1
        // 此时无法进入到循环进行操作，需要特殊形况处理
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
```

