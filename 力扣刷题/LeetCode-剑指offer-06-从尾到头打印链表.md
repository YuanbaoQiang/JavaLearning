@[TOC](目录)

***

# 原题要求

**原题链接**：[剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1**：

输入：head = [1,3,2]
输出：[2,3,1]

**限制**：

0 <= 链表长度 <= 10000

***

# 解题过程

<font color=green size=4>递归</font> | 时间复杂度：$O(n)$ | 空间复杂度$O(n)$ | <font color=green>**推荐**</font>

> 虽然时间性能不及下方的迭代，但是理解递归的调用过程有助于后续的学习！
>
> PS：递归从下图就可以看出，其实就好像在所有的元素里走了一圈。如果执行操作在递归之前，则在每个正向调用的过程中都执行一遍。但是！如果执行操作在递归之后，就会在最终的递归出口处开始，继续执行没有执行完的操作！有那味道没！哈哈哈 
>
> 详情可以参考：[三张图简单理解回溯算法](https://blog.csdn.net/qyb19970829/article/details/113665450)

![image-20210204205844834](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210204205844834.png)

![剑指offer-06-从头打印链表 (1)](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-06-%E4%BB%8E%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8%20(1).jpeg)



```java
class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        // 正向遍历即可，在list中，元素已经反转
        for(int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
    // 递归的方式
    public void recur(ListNode head){
        if(head == null) return;
        recur(head.next);
        // add操作要在递归函数之后
        // 第一次add操作，就是最后一次递归结束的时候
        list.add(head.val);
    }
}
```



<font color=green size=4>迭代</font> | 时间复杂度：$O(n)$ | 空间复杂度$O(n)$ | <font color=green>**推荐**</font>

![image-20210204211826209](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/image-20210204211826209.png)

```java
class Solution {
    public int[] reversePrint(ListNode head) {
        int count = countNodes(head);
        int[] res = new int[count];
        ListNode cur = head;
        // 逆序给数组赋值即可
        for(int i = count - 1; i >= 0; i--){
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
    // 首先计数，得到节点数量
    public int countNodes(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
```

