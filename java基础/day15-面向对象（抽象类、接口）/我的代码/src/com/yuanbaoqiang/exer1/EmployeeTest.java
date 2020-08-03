/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 08:39
 **/

package com.yuanbaoqiang.exer1;

public class EmployeeTest {
    public static void main(String[] args) {

        // Manager manager = new Manager("库克",1001,5000,50000);
        // 多态
        Employee manager = new Manager("库克",1001,5000,50000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
