/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 20:46
 **/

package com.yuanbaoqiang.exer4;

public class Bank {
    private Customer[] customers; // 可以存放多个客户的数组
    private int numberOfCustomers; // 记录客户的个数

    public Bank(){
        customers = new Customer[10];
    }

    // 添加客户
    public void addCustomer(String f, String l){
        Customer cust = new Customer(f,l);
        customers[numberOfCustomers] = cust;
        numberOfCustomers++;
    }

    // 获取客户的个数
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    // 获取指定位置上的客户
    public Customer getCustomer(int index){
        if(index >= 0 && index < numberOfCustomers){
            return customers[index];
        }
        return null;
    }


}
