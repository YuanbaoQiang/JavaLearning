package com.yuanbaoqiang.exer;
/*
* �Ӽ��̶���ѧ���ɼ��� �ҳ���߷ֲ����ѧ���ɼ��ȼ���
* �ɼ� >= ��߷� -10 10 10 10 10 �ȼ�Ϊ ��A�� ��A�� ��A�� ��A��
* �ɼ� >= ��߷� -20 20 20 20 �ȼ�Ϊ ��B��
* �ɼ� >= ��߷� -30 30 30 30 �ȼ�Ϊ ��C�� ��C�� ��C�� ��C��
* ���� �ȼ� Ϊ��D��
*
*
* */


import java.util.Scanner;

public class ArrayStudentScore {
    public static void main(String[] args){
        // 1. ʹ��scanner��ȡѧ������
        Scanner scanner = new Scanner(System.in);
        System.out.print("������ѧ��������");
        int number = scanner.nextInt();

        // 2.�������飬�洢ѧ���ĳɼ�����̬��ʼ��
        int[] score = new int[number];

        // 3. �������е�Ԫ�ظ�ֵ
        System.out.println("������"+number+"��ѧ���ĳɼ���");
        int maxScore = 0;
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
            // 4. ��ȡ������Ԫ�ص����ֵ����߷�
            maxScore = score[i]>maxScore ? score[i]:maxScore;
        }
/*        // 4. ��ȡ������Ԫ�ص����ֵ����߷�
        int maxScore = score[1];
        for (int i = 1; i < score.length; i++) {
            maxScore = score[i]>maxScore ? score[i]:maxScore;
        }*/

        // 5. ����ÿ��ѧ������߷ֵĲ�ֵ���õ�ÿ��ѧ���ĵȼ���������ȼ��ͳɼ�
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
