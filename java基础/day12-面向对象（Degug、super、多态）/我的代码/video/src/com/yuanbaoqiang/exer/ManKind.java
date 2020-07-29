package com.yuanbaoqiang.exer;
/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 12:42
 **/


public class ManKind {
    private int sex; // 性别
    private int salary; // 薪资

    public void manOrWoman(){
        if(sex == 1){
            System.out.println("man");
        }else if(sex == 0){
            System.out.println("woman");
        }
    }

    public void employeed(){
/*        if(salary == 0){
            System.out.println("no job");
        }else{
            System.out.println("job");
        }*/

        String info = salary == 0 ? "no job" : "job";
        System.out.println(info);

    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ManKind() {
    }

    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }
}
