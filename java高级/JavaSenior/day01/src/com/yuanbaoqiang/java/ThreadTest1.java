/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-11 20:51
 **/

package com.yuanbaoqiang.java;

/*
* 创建多线程的方式二：实现Runnable接口
* 1. 创建一个实现了Runnable接口的类
* 2. 实现类去实现Runnable中的抽象方法：run()
* 3. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
* 4. 通过Thread类的对象调用start()
*
*
*
* 比较创建线程的方式的两种方式。
* 开发中：优先选择：实现Runnable接口的方式
* 原因： 1. 实现的方式没有类的单继承性的局限性
*        2. 更适合来处理多个线程有共享数据的情况
*
* 联系：
*
*
*
* */

// 1. 创建一个实现了Runnable接口的类
class MThread implements Runnable{
    // 2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        // 3. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        MThread mThread = new MThread();
        // 4. 通过Thread类的对象调用start()  启动线程  调用当前线程的run()
        Thread t1 = new Thread(mThread);
    }
}
