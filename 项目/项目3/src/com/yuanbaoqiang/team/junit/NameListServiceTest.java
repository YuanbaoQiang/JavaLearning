/**
 * <h3>项目3</h3>
 * <p>对NameListService的测试</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 16:03
 **/

package com.yuanbaoqiang.team.junit;

import com.yuanbaoqiang.team.domain.Employee;
import com.yuanbaoqiang.team.service.NameListService;
import org.junit.Test;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        id = 101;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}