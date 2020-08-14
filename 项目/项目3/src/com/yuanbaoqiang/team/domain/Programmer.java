/**
 * <h3>项目3</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:09
 **/

package com.yuanbaoqiang.team.domain;


import com.yuanbaoqiang.team.service.Status;

public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private  Equipment equipment;

    public Programmer(){

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t程序员\t" + status + "\t\t\t\t\t\t" + equipment.getDescription();
    }
}
