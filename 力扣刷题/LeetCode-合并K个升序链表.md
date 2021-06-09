@[TOC](目录)

***

# 题目要求

**原题链接**：[23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

**示例 1：**

```
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
```


**示例 2**：

```
输入：lists = []
输出：[]
```


**示例 3**：

```
输入：lists = [[]]
输出：[]
```

**提示**：

- k == lists.length
- 0 <= k <= 10^4
- 0 <= lists[i].length <= 500
- -10^4 <= `lists[i][j]` <= 10^4
- lists[i] 按 升序 排列
- lists[i].length 的总和不超过 10^4

***

# 解题过程

<font color=green size=4>归并</font> 

> 时间复杂度$O(n \times logk)$，k为链表的个数，n为链表中节点个数

![归并](https://i.loli.net/2021/01/26/aZeC7OWvlsTiXDn.jpg)

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }


    public static ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode list1 = merge(lists, left, mid);
        ListNode list2 = merge(lists, mid + 1, right);
        return merge(list1, list2);
    }

    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return dummyNode.next;
    }
}
```

<font color=green size=4>暴力迭代</font> 

> 时间复杂度$O(n \times k)$，k为链表的个数，n为链表中节点个数

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(ListNode list : lists){
            res = merge(res, list);
        }
        return res;  
    }

    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            
        }

        cur.next = cur1 == null ? cur2 : cur1;

        return dummyNode.next;
    }
}
```

