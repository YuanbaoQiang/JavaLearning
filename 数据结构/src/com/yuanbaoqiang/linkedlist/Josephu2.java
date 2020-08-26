/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-25 20:32
 **/

package com.yuanbaoqiang.linkedlist;


public class Josephu2 {
    public static void main(String[] args) {
        SLL sll = new SLL(8);
        sll.construct();
        int deal = sll.deal(3);
        System.out.println(deal);
    }
}


class SLL {
    int n; // 最大节点数量

    // 创建头节点，val为1
    Node first = new Node(0);


    /*
     * @description: 创建长度为n的环形链表
     * @author: YuanbaoQiang
     * @date: 2020/8/25 20:41
     * @param n 节点数量
     * @return:
     */
    public SLL(int n) {
        this.n = n;
    }


    /*
     * @description: 构建单向环形链
     * @author: YuanbaoQiang
     * @date: 2020/8/25 20:56
     * @param
     * @return: void
     */
    public void construct(){
        Node cur = first;
        for(int i = 1; i <= n; i++){
            Node node = new Node(i);
            add(node);
            cur = node;
        }
        cur.next = first;
    }


    /*
     * @description: 添加节点
     * @author: YuanbaoQiang
     * @date: 2020/8/25 10:33
     * @param node
     * @return: void
     */
    public void add(Node node){
        Node cur = first;
        while(true){
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        cur.next = node;
    }



    /*
     * @description: 遍历数组
     * @author: YuanbaoQiang
     * @date: 2020/8/25 20:37
     * @param
     * @return: void
     */
    public void list(){
        Node cur = first;
        while(true){
            if(cur.next == first){
                break;
            }
            System.out.printf("节点 %d\n",cur.val);
            cur = cur.next;
        }
    }


    /*
     * @description: 处理约瑟夫问题
     * @author: YuanbaoQiang
     * @date: 2020/8/25 21:03
     * @param
     * @return: void
     */
    public int deal(int m){
        // 定义两个指针 helper 和 cur
        Node cur = first;
        Node helper = cur;

        // helper 定位在 cur的前一个位置
        for(int i = 0; i < n - 1; i++){
            helper = helper.next;
        }


        while(true){
            if(helper == cur){
                break;
            }

            // cur 和 helper同时后移 m-1次
            // cur到达目标位置
            for(int i = 0; i < m - 1; i++){
                helper = helper.next;
                cur = cur.next;
            }

            helper.next = cur.next;
            cur = cur.next;
        }
        return cur.val;
    }

}


// 定义节点
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


