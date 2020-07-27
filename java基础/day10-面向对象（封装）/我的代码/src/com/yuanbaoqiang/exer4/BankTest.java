/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 21:24
 **/

package com.yuanbaoqiang.exer4;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Yuanbao","Qiang");

        bank.getCustomer(0).setAccount(new Account(2000000));
        bank.getCustomer(0).getAccount().withdraw(500);
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户：" + bank.getCustomer(0).getFirstName() + "的账户余额为：" +
                balance);

        System.out.println("************************************");
        bank.addCustomer("万里","杨");
        System.out.println("银行客户的个数为：" + bank.getNumberOfCustomers());

    }
}
