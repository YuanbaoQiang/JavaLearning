/**
 * <h3>JavaSenior</h3>
 * <p>创建三个窗口卖票，总票数为100张</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-11 20:25
 **/

package com.yuanbaoqiang.java;

public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("window-1");
        t2.setName("window-2");
        t3.setName("window-3");

        t1.start();
        t2.start();
        t3.start();
    }


}

class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName() + ": 卖票，票号为: " + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
