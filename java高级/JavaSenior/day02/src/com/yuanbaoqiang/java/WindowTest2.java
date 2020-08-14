/**
 * <h3>JavaSenior</h3>
 * <p>创建三个窗口卖票，总票数为100张</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-11 20:25
 **/

package com.yuanbaoqiang.java;

/*
* 使用同步代码块来Thread类的线程安全问题
* 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
*
*
* */


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("window-1");
        t2.setName("window-2");
        t3.setName("window-3");

        t1.start();
        t2.start();
        t3.start();
    }


}

class Window2 extends Thread{

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            // 正确的
            synchronized (Window2.class){
            // synchronized(obj){
            // 错误的
            // synchronized(this){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号为: " + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
