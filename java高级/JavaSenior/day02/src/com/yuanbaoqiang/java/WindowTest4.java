/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-13 16:03
 **/

package com.yuanbaoqiang.java;

/*
* 使用同步方法处理继承Thread类的方式中的线程安全问题
*
*
* 关于同步方法的总结：
* 1. 同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
* 2. 非静态的同步方法，同步监视器为：this
*     静态的同步方法，同步监视器为：当前类本身
*
*
* */


public class WindowTest4 {
    public static void main(String[] args) { // 同步监视器：Windows4.class
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("window-1");
        t2.setName("window-2");
        t3.setName("window-3");

        t1.start();
        t2.start();
        t3.start();
    }


}

class Window4 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为: " + ticket);
            ticket--;
        }
    }



}