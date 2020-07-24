package com.yuanbaoqiang.exer;

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

public class StudentTest {
    public static void main(String[] args){
        // 声明Student类型的数组
        Student[] s1 = new Student[20];
        for (int i = 0; i < s1.length; i++) {
            // 给数组元素赋值
            s1[i] = new Student();
            // 给Student的属性赋值
            s1[i].number = (i + 1);
            // 年级 【1，6】
            s1[i].state = (int)(Math.random() * (6 - 1 + 1) + 1);

            // 年级 【0，100】
            s1[i].score = (int)(Math.random() * (100 - 0 + 1) + 0);
        }

        // 遍历学生数组
        for(int i = 0; i < s1.length; i++){
           /*System.out.println(s1[i].number + "," + s1[i].state + "," + s1[i].score);*/
            System.out.println(s1[i].info());
        }

        System.out.println("=====================================");

        // 问题一：打印出三年级学生(state值为3)的学生信息
        for(int i = 0; i < s1.length; i++){
            if(s1[i].state == 3){
                System.out.println(s1[i].info());
            }
        }

        System.out.println("=====================================");

        // 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        for(int i = 0; i < s1.length - 1; i++){
            for(int j = 0; j < s1.length - 1 - i; j++){
                if(s1[j+1].score < s1[j].score){
                    Student temp = s1[j];
                    s1[j] = s1[j+1];
                    s1[j+1] = temp;
                }
            }

        }

        // 遍历学生数组
        for(int i = 0; i < s1.length; i++){
            /*System.out.println(s1[i].number + "," + s1[i].state + "," + s1[i].score);*/
            System.out.println(s1[i].info());
        }





    }
}

class Student{
    int number; // 学号
    int state; // 年级
    int score; // 成绩

    public String info(){

        return "学号为：" + number + "，年级为：" + state + "，成绩为：" + score;
    }



}
