/**
 * <h3>项目2-客户信息管理软件</h3>
 * <p>为Customer对象的管理模块，内部用数组管理-组Customer对象，并提供相应的添加、修改、删除和遍历方法，供CustomerView调用</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-28 11:48
 **/

package com.yuanbaoqiang.p2.service;

import com.yuanbaoqiang.p2.bean.Customer;

public class CustomerList {
    private Customer[] customers; // 用来保存客户对象的数组
    private int total; // 记录已保存客户对象的数量

    /**
     * @description: 用来初始化Customers数组的构造器
     * @author: YuanbaoQiang
     * @date: 2020/7/28 12:42
     * @param totalCustomer ： 指定数组的长度
     * @return:
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * @description: 将指定的客户添加到数组中
     * @author: YuanbaoQiang
     * @date: 2020/7/28 12:47
     * @param customer
     * @return: boolean：true-添加成功，false-添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
/*        customers[total] = customer;
        total++;*/
        // 或
        customers[total++] = customer;
        return true;
    }

    /**
     * @description: 修改指定索引位置上的客户信息
     * @author: YuanbaoQiang
     * @date: 2020/7/28 12:51
     * @param index
     * @param cust
     * @return: boolean：true-修改成功，false-修改失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * @description: 删除指定索引位置上的客户
     * @author: YuanbaoQiang
     * @date: 2020/7/28 13:00
     * @param index
     * @return: boolean：true-删除成功，false-删除失败
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index; i < total - 1; i++){
            customers[i] = customers[i+1];
        }

        // 最后有数据䣌元素需要置空
/*        customers[total - 1] = null;
        total--;*/
        // 或
        customers[--total] = null;
        return true;
    }

    /**
     * @description:获取所有客户的信息
     * @author: YuanbaoQiang
     * @date: 2020/7/28 13:09
     * @param
     * @return: com.yuanbaoqiang.p2.bean.Customer[]
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }


    /**
     * @description: 获取指定索引位置上的客户
     * @author: YuanbaoQiang
     * @date: 2020/7/28 13:13
     * @param index
     * @return: com.yuanbaoqiang.p2.bean.Customer 如果找到元素则返回，没找到，则返回null
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * @description: 获取存储的客户的数量
     * @author: YuanbaoQiang
     * @date: 2020/7/28 13:14
     * @param
     * @return: int
     */
    public int getTotal(){
        return total;
    }

}
