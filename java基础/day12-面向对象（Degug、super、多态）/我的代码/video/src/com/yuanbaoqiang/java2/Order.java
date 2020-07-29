/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 16:36
 **/

package com.yuanbaoqiang.java2;

public class Order {

    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodPrivate(){
        orderDefault = 1;
        orderPrivate = 1;
        orderProtected = 1;
         orderPublic = 1;
    }

    void methodDefault(){

    }

    protected  void methodProtected(){

    }

    public void methodPublic(){

    }

}
