/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-25 10:21
 **/

package com.yuanbaoqiang.stack;


import java.util.Scanner;

public class SingleLinkedListStackDemo {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList(5);
        Node dum = sll.dum;
        boolean flag = true;

        String key = "";
        Scanner scanner = new Scanner(System.in);

        while(flag){
            System.out.println("show: 显示链表");
            System.out.println("push: 加入节点");
            System.out.println("pop: 弹出链表节点");
            System.out.println("exit: 退出循环");
            System.out.print("请输入你的选项: ");
            key = scanner.next();
            switch (key){
                case "show":
                    sll.list();
                    break;
                case "push":
                    System.out.print("请输入一个节点值: ");
                    int value = scanner.nextInt();
                    Node node = new Node(value);
                    sll.push(node);
                    break;
                case "pop":
                    sll.pop(dum);
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
        System.out.println("程序已结束~");
    }
}



class SingleLinkedList{
    int maxSize; // 最大节点数量

    /*
     * @description: 单链表构造器
     * @author: YuanbaoQiang
     * @date: 2020/8/25 11:59
     * @param maxSize 定义该链表的最大节点数（不包含伪头）
     * @return:
     */
    public SingleLinkedList(int maxSize){
        this.maxSize = maxSize;
    }

    // 创建伪头，val为0
    Node dum = new Node(0);

    /*
     * @description: 添加节点
     * @author: YuanbaoQiang
     * @date: 2020/8/25 10:33
     * @param node
     * @return: void
     */
    public void push(Node node){
        if(isFull()){
            System.out.println("链表已满~");
            return;
        }
        Node cur = dum;
        while(true){
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        cur.next = node;
    }



    /*
     * @description: pop出链表节点
     * @author: YuanbaoQiang
     * @date: 2020/8/25 12:05
     * @param node
     * @return: void
     */
    public void pop(Node node){
        if(isEmpty()){
            System.out.println("链表为空~");
        }
        Node cur = dum;
        for(int i = 0; i < size(dum) - 1; i++){
            cur = cur.next;
        }
        if(cur.next != null){
            Node temp = cur.next; // 记录pop出的节点
            cur.next = null; // 倒数第二个节点指向null
            System.out.printf("弹出：节点 %d \n",temp.val);
        }
    }



    /*
     * @description: 判断链表是否已满
     * @author: YuanbaoQiang
     * @date: 2020/8/25 11:46
     * @param
     * @return: boolean
     */
    public boolean isFull(){
        return size(dum) == maxSize;

    }

    /*
     * @description: 判断链表是否为空
     * @author: YuanbaoQiang
     * @date: 2020/8/25 11:47
     * @param
     * @return: boolean
     */
    public boolean isEmpty(){
        return size(dum) == 0;
    }

    /*
     * @description: 遍历链表
     * @author: YuanbaoQiang
     * @date: 2020/8/25 10:38
     * @param
     * @return: void
     */
    public void list(){
        if(isEmpty()){
            System.out.println("此时链表为空~");
        }
        Node cur = dum.next;
        while(true){
            if(cur == null){
                break;
            }
            System.out.printf("节点 %d\n",cur.val);
            cur = cur.next;
        }
    }

    /*
     * @description: 计算链表长度（不包含伪头）
     * @author: YuanbaoQiang
     * @date: 2020/8/25 10:53
     * @param node
     * @return: int
     */
    public int size(Node node){
        int count = 0;
        Node cur = dum.next;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

}


class Node{

    Node next;
    int val;


    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
