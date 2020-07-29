/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 12:49
 **/

package com.yuanbaoqiang.exer;

public class Kids extends ManKind{
    private int yearsOld;

    public Kids() {
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println("I am " + yearsOld + " years old.");
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    @Override
    public void employeed(){
        System.out.println("Kids should study and no job");
    }

}
