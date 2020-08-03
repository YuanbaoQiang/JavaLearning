/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 08:30
 **/

package com.yuanbaoqiang.exer1;

public class Manager extends Employee{
    private double bonus; // 奖金

    public Manager(double bonus){
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus){
        super(name,id,salary);
        this.bonus = bonus;

    }


    @Override
    public void work() {
        System.out.println("管理员工，提高公司运行的效率");
    }
}
