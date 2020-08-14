/**
 * <h3>项目3</h3>
 * <p>负责将Data中的数据封装的到Employee[]数组中，同时提供相关操作Employee[]的方法</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:36
 **/

package com.yuanbaoqiang.team.service;


import com.yuanbaoqiang.team.domain.*;

import static com.yuanbaoqiang.team.service.Data.*;

public class NameListService {
    private Employee[] employees;

    // 给employees及数组元素进行初始化
    public NameListService(){
/*      1. 根据项目提供的Data类构建相应大小的employees数组
        2. 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
        3. 将对象存于数组中*/
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            // 获取Employee的4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch(type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }

    }


    /*
     * @description: 获取指定index位置上的员工的设备
     * @author: YuanbaoQiang
     * @date: 2020/8/7 15:16
     * @param
     * @return: com.yuanbaoqiang.team.domain.Equipment
     */
    public Equipment creatEquipment(int index){
        int kye = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        switch(kye){
            case PC: // 21
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case NOTEBOOK: // 22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName,price);
            case PRINTER: // 23
                String type = EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);

        }
        return null;
    }


    /*
     * @description: 获取当前所有的员工
     * @author: YuanbaoQiang
     * @date: 2020/8/7 15:49
     * @param
     * @return: com.yuanbaoqiang.team.domain.Employee[]
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /*
     * @description: 获取指定ID的员工对象
     * @author: YuanbaoQiang
     * @date: 2020/8/7 15:49
     * @param id
     * @return: com.yuanbaoqiang.team.domain.Employee
     */
    public Employee getEmployee(int id) throws Exception{
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }

}
