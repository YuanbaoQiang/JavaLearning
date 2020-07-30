/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 14:21
 **/

package com.yuanbaoqiang.exer2;

public class CheckAccount extends Account{
    private double overDraft;

    public CheckAccount(int id, double balance, double annualInterestRate,double overDraft){
        super(id, balance, annualInterestRate);
        this.overDraft = overDraft;
    }

    @Override
    public void withdraw(double amount) {
        if(getBalance() >= amount){ // 余额就足够消费
            // 方式一
            // setBalance(getBalance() - amount);
            // 方式二
            super.withdraw(amount);
            System.out.println("您的可透支余额：" + overDraft);

        }else if(overDraft >= (amount -getBalance())){ // 透支额度 + 余额足够消费
            overDraft -= (amount - getBalance());
            setBalance(0);
            System.out.println("您的账户余额：" + getBalance());
            System.out.println("您的可透支余额：" + overDraft);
        }else{
            System.out.println("超出可透支限额！");
        }
    }
}
