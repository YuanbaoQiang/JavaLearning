/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-01 12:05
 **/

package com.yuanbaoqiang.exer;

public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account();
        Account acct2 = new Account("qwerty",2000);
        Account.setInterestRate(0.012);
        Account.setMinMoney(100);
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct1.getInterestRate());
        System.out.println(acct1.getMinMoney());
    }
}
