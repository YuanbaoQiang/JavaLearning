/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-13 17:18
 **/

package com.yuanbaoqiang.java1;

// 使用同步机制将单例模式中的懒汉式改写成线程安全的

public class BankTest {

}

class Bank{
    private static Bank instance = null;
    public static Bank getInstance(){
        // 方式一：效率稍差
/*        synchronized (Bank.class) {
            if(instance == null){
                instance = new Bank();
            }
            return instance;
        }*/
        //方式二：效率稍高
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;

    }
}
