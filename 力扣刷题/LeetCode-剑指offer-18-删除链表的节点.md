@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

**示例 1**:

```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```


**示例 2**:

```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

**说明**：

- 题目保证链表中节点的值互不相同
- 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点

***

# 解题过程

<font color=green size=4>简单操作</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210208215111893](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208215111893.png)

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        else if(head.val == val) return head.next;
        ListNode cur = head;
        while(cur != null){
            if(cur.next.val == val){
                break;
            }
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
```

<font color=green size=4>递归操作</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 注意递归的返回值。
>
> 此时`head.next = deleteNode(head.next, val);`是一个正向的过程。

![image-20210208221308497](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210208221308497.png)

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return head.next;
        head.next = deleteNode(head.next, val);
        return head;
    }
}
```

