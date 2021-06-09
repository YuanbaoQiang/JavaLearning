@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/) | [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL 
```

**限制：**

```
0 <= 节点个数 <= 5000
```

***

# 原题链接

这道题也算是面试常客啦，算是经典题吧！也需要掌握多种解法哦~

头插法、双指针、辅助栈的解法可以参考我先前的博客记录：[LeetCode-反转单链表（头插法、双指针、辅助栈）](https://blog.csdn.net/qyb19970829/article/details/108155596?ops_request_misc=%25257B%252522request%25255Fid%252522%25253A%252522161283700916780261929311%252522%25252C%252522scm%252522%25253A%25252220140713.130102334.pc%25255Fblog.%252522%25257D&request_id=161283700916780261929311&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v1~rank_blog_v1-1-108155596.pc_v1_rank_blog_v1&utm_term=%25E5%25A4%25B4%25E6%258F%2592%25E6%25B3%2595)，有详细记录。

<font color=green size=4>递归/回溯</font> | 时间复杂度：$O(n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210209102301902](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210209102301902.png)

```
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reverseNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }
}
```

