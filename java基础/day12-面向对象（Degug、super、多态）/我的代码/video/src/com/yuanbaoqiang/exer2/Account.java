/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-30 13:22
 **/

package com.yuanbaoqiang.exer2;

public class Account {
    private int id; // 账号
    private double balance; // 余额
    private double annualInterestRate; // 年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setAnnualInterestRate(){
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    // 返回月利率
    public double getMonthlyInterest(){
        return annualInterestRate / 12;
    }

    // 取钱
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("余额不足！\n您的账户余额为：" + balance);
            return;
        }
        balance -= amount;
        System.out.println("您的账户余额为：" + balance);

    }

    //存钱
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("您的账户余额为：" + balance);
            return;
        }
    }

}
