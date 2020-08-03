/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 12:11
 **/

package com.yuanbaoqiang.exer2;

/*
*
*
* */

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {


/*        // 方式一
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当前的月份：");
        int month = scanner.nextInt();*/

        // 方式二

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);// 获取当前的月份


        Employee[] emps = new Employee[2];

        emps[0] = new SalariedEmployee("马森",1002, new MyDate(1992,2,28),10000);
        emps[1] = new HourlyEmployee("强元宝",2001, new MyDate(1997,8,29),60,240);

        for(int i = 0; i < emps.length; i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资为：" + salary);

            if(month+1 == emps[i].getBirthday().getMonth()){
                System.out.println("生日快乐！奖励一百元");
            }

        }

    }
}
