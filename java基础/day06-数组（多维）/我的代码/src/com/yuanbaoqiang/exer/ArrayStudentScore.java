package com.yuanbaoqiang.exer;
/*
* 从键盘读入学生成绩， 找出最高分并输出学生成绩等级。
* 成绩 >= 最高分 -10 10 10 10 10 等级为 ’A’ ’A’ ’A’ ’A’
* 成绩 >= 最高分 -20 20 20 20 等级为 ’B’
* 成绩 >= 最高分 -30 30 30 30 等级为 ’C’ ’C’ ’C’ ’C’
* 其余 等级 为’D’
*
*
* */


import java.util.Scanner;

public class ArrayStudentScore {
    public static void main(String[] args){
        // 1. 使用scanner读取学生个数
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生人数：");
        int number = scanner.nextInt();

        // 2.创建数组，存储学生的成绩，动态初始化
        int[] score = new int[number];

        // 3. 给数组中的元素赋值
        System.out.println("请输入"+number+"个学生的成绩：");
        int maxScore = 0;
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
            // 4. 获取数组中元素的最大值：最高分
            maxScore = score[i]>maxScore ? score[i]:maxScore;
        }
/*        // 4. 获取数组中元素的最大值：最高分
        int maxScore = score[1];
        for (int i = 1; i < score.length; i++) {
            maxScore = score[i]>maxScore ? score[i]:maxScore;
        }*/

        // 5. 根据每个学生与最高分的差值，得到每个学生的等级，并输出等级和成绩
        char level;
        for (int i = 0; i < score.length; i++) {
            int delta = maxScore - score[i];
            if(delta <=10){
                level = 'A';
            }else if(delta <= 20){
                level = 'B';
            }else if(delta <=30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("Studenr\t" + i + "\tscore is\t" + score[i] + "\t,grade is\t" + level);

        }

    }
}
