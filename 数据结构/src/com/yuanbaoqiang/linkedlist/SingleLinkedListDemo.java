/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-18 21:08
 **/

package com.yuanbaoqiang.linkedlist;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "及时雨");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");




        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
/*        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);*/

        // 按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);



        // 测试一下单链表的反转
        System.out.println("原来链表的情况!!!");
        singleLinkedList.list();
        System.out.println();

        System.out.println("方式一：反转链表的情况!!!");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        System.out.println("方式二：反转链表的情况!!!");
        reversePrint(singleLinkedList.getHead());
/*        singleLinkedList.list();*/
        System.out.println();








        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.list();
        // 显示一把
        System.out.println("修改后的链表情况~~~");
        singleLinkedList.update(newHeroNode);


        System.out.println();
        // 删除一个节点
        singleLinkedList.singleDelete(1);

        // 显示一把
        singleLinkedList.list();




        // 测试 求单链表中有效节点的个数
        System.out.printf("\n单链表中有效节点的个数为%d", getLength(singleLinkedList.getHead()));
        System.out.println();

        // 测试是否得到了倒数第k个节点
        HeroNode res = findLastNode(singleLinkedList.getHead(), 3);
        System.out.println("res = " + res);


    }

    // 方式一
    // 将单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转
        if(head.next == null || head.next.next == null){
            return;
        }

        // 定义一个辅助的指针（变量），遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; // 指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        // 遍历原来的链表，并从头遍历原来的链表
        // 每遍历一个节点就将其取出，并放在链表reverHead的最前端
        while(cur != null){
            next = cur.next; // 先暂时保存当前节点的下一个节点，因为后面需要
            cur.next = reverseHead.next;// 将cur的下一个节点指向新链表的最前端
            reverseHead.next = cur; // 将cur连接到新的链表上
            cur = next;
        }

        // 将head.next指向reverseHead.next，实现单链表的反转

        head.next = reverseHead.next;


    }


    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return; // 空链表，不能打印
        }

        // 创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 将链表的所有节点压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        // 将栈中的节点进行打印，pop出栈
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }









    // 思路
    // 1. 编写一个方法，接收head节点，同时接收一个index
    // 2. index表示倒数第index个节点
    // 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    // 4. 得到size后，我们从链表的第一个开始遍历（size - index）
    // 5. 否则返回空

    public static HeroNode findLastNode(HeroNode head, int index){
        // 如果链表为空，返回null
        if(head.next == null){
            return null;
        }

        // 第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);
        // 第二次 size位置，就是我们倒数第k个节点
        // 先做一个数据的校验
        if(index <= 0 || index > size){
            return null;
        }

        // 定义一个辅助变量,for循环定位到倒数index
        HeroNode cur = head.next; // 3  // 3 - 1
        for(int i = 0; i < size-index; i++){
            cur = cur.next;
        }
        return cur;
    }




    /*
     * @description: 获取单链表的节点的个数（如果是带头节点的链表，需求不统计头节点）
     * @author: YuanbaoQiang
     * @date: 2020/8/19 21:19
     * @param head 链表的头节点
     * @return: int 有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }

        int count = 0;
        HeroNode temp;
        for(temp = head.next; temp != null; temp = temp.next){
            count++;
        }
        return count;
    }





}


// 定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    // 先初始化一个头节点，头节点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    // 返回头节点

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    // 添加节点到单向链表
    // 思路，当不考虑编号顺序时
    // 1。 找到当前链表的最后节点
    // 2。 将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            //
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，则将temp后移
            temp = temp.next;

        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;

    }

    // 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    // （如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为是单链表，因此我们找的temp 是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // 标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) { // 说明temp已经在链表的最后
                break; //
            }

            if (temp.next.no > heroNode.no) { // 位置找到
                break;
            } else if (temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已经存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移，遍历当前的链表
        }

        // 判断flag
        if (flag) { // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            // 插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }


    // 修改节点的信息，根据no编号来修改，即no编号不能改
    // 说明
    // 1. 根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }

            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flg判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHeroNode.no);
        }
    }


    // 删除节点
    // 思路
    // 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    // 2. 说明我们在比较时，时temp.next.no和需要删除的no比较

    public void singleDelete(int no) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp; // 定义辅助节点
        boolean flag = false;
        for (temp = head; temp.next != null; temp = temp.next) {
     /*       if(head.no == no){
                head = temp.next;
                break;
            }*/

            if (temp.next.no == no) { // temp和heroNode相同
                flag = true; // 找到待删除节点的前一个节点temp
                break;
            }
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }


    }


    // 显示链表[遍历]
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("this is empty");
            return;
        }

        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }

            // 输出节点的信息
            System.out.println(temp);

            // 将temp next后移
            temp = temp.next;

        }
    }

}


// 定义一个HeroNode，每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    // 为了显示方便
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
