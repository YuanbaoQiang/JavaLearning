/**
 * <h3>我的代码</h3>
 * <p>自己手写一遍</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-24 08:59
 **/

/*
 * 定义类Student,包含三个属性：学号number（int），年级state（int），成绩score（int）
 * 创建20个学生对象，学号1到20，年级和成绩都由随机数确定。
 * 问题一：打印出3年纪（state值为3）的学生信息
 * 问题二：使用冒泡顺序按照学生成绩排序，并遍历所有学生信息
 *
 * 提示
 * 1. 生成随机数，Math.random()。返回值类型为double;
 * 2. 四舍五入取整：Math.round(double d)，返回类型为long
 *
 * */


package com.yuanbaoqiang.exer;

public class StudentAgain {
    public static void main(String[] args){

        // 创建20个学生信息
        Student1[] s1 = new Student1[20];


        for (int i = 0; i < s1.length; i++) {

            // 创建对象
            s1[i] = new Student1();

            // 分配学生编号
            s1[i].number = i + 1;

            // 分配年级
            // [1,6]
            s1[i].state = (int)(Math.random() * (6 - 1 + 1) + 1);

            // 分配成绩
            // [0,100]
            s1[i].score = (int)(Math.random() * (100 - 0 + 1) + 0);

        }

        StudentAgain sa = new StudentAgain();

        // 遍历学生
        sa.Print(s1);
        System.out.println("===========================================");

        // 问题一：打印出3年纪（state值为3）的学生信息
        sa.searchState(s1,3);
        System.out.println("===========================================");

        // 问题二：使用冒泡顺序按照学生成绩排序，并遍历所有学生信息
        sa.sort(s1);
        sa.Print(s1);

    }

    /**
     * @description: 遍历学生信息
     * @author: YuanbaoQiang
     * @date: 2020/7/24 9:23
     * @param s1 学生数组
     * @return: void
     */
    public void Print(Student1[] s1){
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i].info());
        }
    }

    /**
     * @description: 打印指定年级学生的信息
     * @author: YuanbaoQiang
     * @date: 2020/7/24 9:51
     * @param s1 学生数组
     * @param state 需要筛选的年级
     * @return: void
     */
    public void searchState(Student1[] s1, int state){
        for (int i = 0; i < s1.length; i++) {
            if(s1[i].state == 3){
                System.out.println(s1[i].info());
            }
        }
    }

    /**
     * @description: 冒泡排序学生成绩（从小到大）
     * @author: YuanbaoQiang
     * @date: 2020/7/24 9:58
     * @param s1 需要排序的学生数组
     * @return: void
     */
    public void sort(Student1[] s1){
        for (int i = 0; i < s1.length - 1; i++) {
            for (int j = 0; j < s1.length - 1 -i; j++) {
                if(s1[j+1].score < s1[j].score){
                    Student1 temp;
                    temp = s1[j];
                    s1[j] = s1[j+1];
                    s1[j+1] = temp;
                }
            }
        }
    }

}

class Student1{
    int number, state, score; // 编号，年级，分数

    public String info(){
        return "编号为 " + number + " 的学生" + ",年级为 " + state + ",分数为 " + score;
    }
}
