/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 12:58
 **/

package com.yuanbaoqiang.exer;

public class KidsTest {
    public static void main(String[] args) {
        Kids someKid = new Kids(12);
        someKid.printAge();
        someKid.setSalary(0);
        someKid.setSex(1);

        someKid.employeed();
        someKid.manOrWoman();
    }
}
