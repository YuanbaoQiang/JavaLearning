/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 19:44
 **/

package com.yuanbaoqiang.exer2;

public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy = new Boy("罗密欧",21);
        boy.shout();

        Girl girl = new Girl("朱丽叶",18); // ctrl + p
        girl.marry(boy);

        Girl girl1 = new Girl("祝英台",19);
        int compare = girl.compare(girl1);
        if(compare > 0){
            System.out.println(girl.getName() + "大");
        }else if(compare < 1){
            System.out.println(girl.getName() + "小");
        }else{
            System.out.println("一样大");
        }
    }
}
