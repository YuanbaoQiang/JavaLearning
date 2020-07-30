/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 14:09
 **/

package com.yuanbaoqiang.exer2;

public class AcountTest {
    public static void main(String[] args) {
        Account acc = new Account(1510310118,20000,0.045);
        acc.withdraw(30000);
        acc.withdraw(2500);
        acc.deposit(3000);

        System.out.println("月利率为：" + (acc.getMonthlyInterest() * 100) + "%");
    }

}
