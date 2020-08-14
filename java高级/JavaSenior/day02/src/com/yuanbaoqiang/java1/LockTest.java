/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * 解决线程安全问题的方式三：Lock锁 --> JDK 5.0
 * 面试题一：synchronized 和 lock的异同点
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后自动的释放同步监视器
 *      lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 *
 * 2. 优先使用顺序
 * lock --> 同步代码块 -->（已经进入了方法体，分配了相应资源）--> 同步方法（在方法体之外）
 *
 *
 * 面试题：如何解决线程安全问题？有几种方式
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-13 18:50
 **/

package com.yuanbaoqiang.java1;


import java.util.concurrent.locks.ReentrantLock;

class Window implements Runnable{
    private int ticket = 100;
    // 1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            try {
                // 2. 调用锁定方法：lock方法
                lock.lock();

                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ": 售票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                // 3. 调用解锁方法；unlock()
                lock.unlock();
            }
        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
