/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 14:44
 **/

package com.yuanbaoqiang.exer2;

public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount acct = new CheckAccount(1510310118,20000,0.045,5000);
        acct.withdraw(5000);
        System.out.println();
        acct.withdraw(18000);
        System.out.println();
        acct.withdraw(3000);
    }
}
