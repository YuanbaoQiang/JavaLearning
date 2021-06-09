@[TOC](目录)

***

# 题目要求

**原题链接**：[剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/) | [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

**示例1**：

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```


**限制**：

- 0 <= 链表长度 <= 1000


***

# 解题过程

<font color=green size=4>迭代</font> | 时间复杂度：$O(m+n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

![image-20210209103740762](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210209103740762.png)

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }
}
```

<font color=green size=4>递归</font> | 时间复杂度：$O(m+n)$ | 空间复杂度：$O(1)$ | <font color=green>**推荐**</font>

> 递归过程其实不太好理解，这里通过图示的方法比较直观~

![剑指offer-25-合并两个有序的链表01](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-25-%E5%90%88%E5%B9%B6%E4%B8%A4%E4%B8%AA%E6%9C%89%E5%BA%8F%E7%9A%84%E9%93%BE%E8%A1%A801.jpeg)



![image-20210209105423740](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210209105423740.png)

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

