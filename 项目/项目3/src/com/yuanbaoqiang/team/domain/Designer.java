/**
 * <h3>项目3</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:29
 **/

package com.yuanbaoqiang.team.domain;

public class Designer extends  Programmer{
    private double bonus; // 奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()  + " \t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
}
