/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-24 19:36
 **/

package com.yuanbaoqiang.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        // 测试一把看看构建的环形链表和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25); // 加入5个节点小孩
        circleSingleLinkedList.showBoy();

        // 测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);



    }
}



// 创建一个环形的单向链表
class CircleSingleLinkedList{
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    /*
     * @description: 添加小孩节点，构建成一个环形的链表
     * @author: YuanbaoQiang
     * @date: 2020/8/24 20:17
     * @param nums
     * @return: void
     */
    public void addBoy(int nums){
        // nums做一个数据校验
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }

        // 使用for循环来创建我们的环形链表
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        for(int i = 1; i <= nums; i++){
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if(i == 1){
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first; // 让curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /*
     * @description: 遍历当前链表
     * @author: YuanbaoQiang
     * @date: 2020/8/24 20:17
     * @param
     * @return: void
     */
    public void showBoy(){
        // 判断链表是否为空
        if(first == null){
            System.out.println("This is empty");
            return;
        }
        // 链表只有一个节点
        if(first.getNext() == first){
            System.out.printf("小孩的编号 %d \n",first.getNo());
            return;
        }
        //
        Boy curBoy = first;

        while(true){
            System.out.printf("小孩的编号 %d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();// curBoy后移
        }
        return;
    }


    /*
     * @description: 根据用户的输入，计算小孩出圈的一个顺序
     * @author: YuanbaoQiang
     * @date: 2020/8/24 20:29
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初由多少小孩在圈
     * @return: void
     */
    public void countBoy(int startNo, int countNum, int nums){
        // 先对数据进行校验
        if(first == null || startNo < 0 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        // 创建辅助指针，帮助小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针（变量）helper，实现应该指向环形链表的最后这个节点
        while(helper.getNext() != first){
            helper = helper.getNext();
        }

        // 小孩报数前，先让first和helper移动k-1次
        for(int i = 0; i < startNo - 1; i ++){
            first = first.getNext();
            helper = helper.getNext();
        }

        // 当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        // 这里是一个循环操作，直到圈中只有一个节点
        while(true){
            if(helper == first){
                break;
            }

            // 让first 和 helper指针同时移动countNum-1次，然后出圈
            for(int i = 0; i < countNum - 1; i++){
                first = first.getNext();
                helper = helper.getNext();
            }

            // 这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            // 这时将first指向的小孩出圈

            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为%d\n",helper.getNo());

    }


}



// 创建一个Boy类，表示一个节点
class Boy{
    private int no; // 编号
    private Boy next; // 指向下一个节点，默认为null


    public Boy(int no){
        this.no = no;
    }

    public void setNo(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
