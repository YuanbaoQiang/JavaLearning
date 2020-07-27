/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 20:17
 **/

package com.yuanbaoqiang.exer3;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(){

    }

    public Customer(String f, String l){
        this.firstName = f;
        this.lastName = l;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
