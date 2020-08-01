/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-01 07:44
 **/

package com.yuanbaoqiang.exer4;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        // 1. 实例化Scanner，用于从键盘获取学生成绩
        Scanner scan = new Scanner(System.in);

        // 2. 创建Vector对象：Vector v = new Vector(); 相当于原来的数组
        Vector v = new Vector();

        // 3. for(;;)或while(true)方式
        int maxScore = 0;
        for(;;){
            System.out.print("请输入学生成绩（当输入负数代表结束）：");
            int score = scan.nextInt();
            // 3.2 当输入负数时，跳出循环
            if(score < 0){
                break;
            }
            if(score > 100){
                System.out.println("输入的数据非法！请重新输入：");
            }
            // 3.1 给Vector中添加数据 v.addElement(Object obj)
            // jdk5.0 之前
            /*Integer inScore = new Integer(score);
            v.addElement(inScore); // 多态*/


            // jdk5.0 之后
            v.addElement(score); // 自动装箱
            // 4. 获取学生最大值
            if(maxScore < score){
                maxScore = score;
            }
        }
        // 5. 遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级。
        char level;
        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            // jdk5.0 之前
/*            Integer inScore = (Integer)obj;
            int score = inScore.intValue();*/

            // jdk5.0 之后
            int score = (int)obj;

            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 30){
                level = 'B';
            }else{
                level = 'D';
            }
            System.out.println("student-" + i + " score is " + score + ", level is " + level);


        }
    }
}
