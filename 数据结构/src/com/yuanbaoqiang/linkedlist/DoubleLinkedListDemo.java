/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 21:27
 **/

package com.yuanbaoqiang.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "及时雨");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表的对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况：");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况：");
        doubleLinkedList.list();

        // 按照序号加入
        doubleLinkedList.addByOrder(hero2);
        System.out.println("按序号大小加入后的链表情况：");
        doubleLinkedList.list();

    }
}

// 创建一个双向链表的类
class DoubleLinkedList {
    // 先初始化一个头节点，头节点不动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    /*
     * @description: 遍历双向链表的方法
     * @author: YuanbaoQiang
     * @date: 2020/8/23 21:42
     * @param
     * @return: void
     */
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("this is empty");
            return;
        }

        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    /*
     * @description: 添加一个节点到双向链表的最后
     * @author: YuanbaoQiang
     * @date: 2020/8/23 21:40
     * @param heroNode
     * @return: void
     */
    public void add(HeroNode2 heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
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
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    /*
     * @description: 修改一个节点的内容，和单向链表方法一样
     * @author: YuanbaoQiang
     * @date: 2020/8/23 21:41
     * @param newHeroNode
     * @return: void
     */
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 先定义一个辅助变量
        HeroNode2 temp = head.next;
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


    /*
     * @description: 删除节点
     * @author: YuanbaoQiang
     * @date: 2020/8/23 21:45
     * @param no
     * @return: void
     */
    public void del(int no) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp; // 定义辅助节点
        boolean flag = false;
        for (temp = head.next; temp != null; temp = temp.next) {
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
            // temp.next = temp.next.next; 单向链表的删除方式
            temp.pre.next = temp.next;
            // 如果是最后一个节点就不需要执行下一句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.next;
            }
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }


    }



    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为是单链表，因此我们找的temp 是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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

/*        if(temp.no < heroNode.no){
            add(heroNode);
            return;
        }*/

        // 判断flag
        if (flag) { // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        }else{

            if(temp.next != null){

                // 插入到链表中，temp的后面
                heroNode.next = temp.next;
                temp.next.pre = heroNode;

                temp.next = heroNode;
                heroNode.pre = temp;
            }else{
                heroNode.pre = temp;
                temp.next = heroNode;
                heroNode.next = null;
            }

        }

    }



}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点，默认为null
    public HeroNode2 pre; // 指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    // 为了显示方便

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
