/**
 * <h3>我的代码</h3>
 * <p>CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，供CustomerView调用 </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 08:23
 **/

package com.yuanbaoqiang.service;

import com.yuanbaoqiang.bean.Customer;

public class CustomerList {
    Customer[] customers; // 用来保存客户对象的数组
    private int total; // 记录已保存客户对象的数量

    /**********************构造器************************/
    public CustomerList(int toatalCustomers){
        customers = new Customer[toatalCustomers];
    }

    /**********************方法************************/

    /**
     * @description: 添加客户
     * @author: YuanbaoQiang
     * @date: 2020/7/29 9:12
     * @param customer
     * @return: boolean：true-添加完毕；false-添加失败
     */
    public boolean addCustomer(Customer customer){
        customers[total++] = customer;
        return true;
    }

    /**
     * @description: 替换客户
     * @author: YuanbaoQiang
     * @date: 2020/7/29 9:36
     * @param index
     * @param cust
     * @return: boolean：true-替换成功；false-替换失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total){
            return false;
        }else{
            customers[index] = cust;
            return true;
        }
    }

    /**
     * @description: 删除客户
     * @author: YuanbaoQiang
     * @date: 2020/7/29 9:46
     * @param index 
     * @return: boolean：true-删除成功；false-删除失败
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }

        for(int i = index; i < total-1; i++){
            customers[i] = customers[i+1];
        }
            customers[--total] = null;
            return true;
    }

    /**
     * @description: 返回客户数组
     * @author: YuanbaoQiang
     * @date: 2020/7/29 9:56
     * @param  
     * @return: com.yuanbaoqiang.bean.Customer[]
     */
    public Customer[] getAllCustomers(){
        Customer[] cust = new Customer[total];
        for(int i = 0; i < total; i++){
            cust[i] = customers[i];
        }
        return cust;
    }

    /**
     * @description: 返回参数index指定索引位置的客户对象记录
     * @author: YuanbaoQiang
     * @date: 2020/7/29 10:05
     * @param index 
     * @return: com.yuanbaoqiang.bean.Customer
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * @description: 返回数组元素个数
     * @author: YuanbaoQiang
     * @date: 2020/7/29 10:04
     * @param
     * @return: int
     */
    public int getTotal(){
        return total;
    }

}
