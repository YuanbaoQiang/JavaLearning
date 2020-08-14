/**
 * <h3>项目3</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:07
 **/

package com.yuanbaoqiang.team.domain;

public class Employee {
    private int id;
    private String name;
    private  int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getDetails(){
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }



    @Override
    public String toString() {
        return getDetails();
    }
}
