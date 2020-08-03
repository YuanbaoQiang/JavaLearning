/**
 * <h3>我的代码</h3>
 * <p>模板方法的设计模式</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 09:15
 **/

package com.yuanbaoqiang.java;

public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}


abstract class  Template{

    // 计算某段代码所需花费的时间
    public void spendTime(){
        long start = System.currentTimeMillis();
        code(); // 不确定的易变的部分
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));

    }

    public abstract void code();

}

class SubTemplate extends Template{
    @Override
    public void code() {
        for(int i = 2; i<= 1000; i++){
            boolean isFlag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }

    }
}