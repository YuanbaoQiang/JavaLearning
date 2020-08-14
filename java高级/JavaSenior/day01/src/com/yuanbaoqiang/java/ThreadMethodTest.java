/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-11 19:10
 **/

package com.yuanbaoqiang.java;

/*
* 测试Thread中的常用方法：
* 1. start()：启动当前线程：调用当前线程的run()
* 2. run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明再此方法中
* 3. currentThread()：静态方法，返回执行当前代码的线程
* 4. getName()：获取当前线程的名字
* 5. setName()：设置当前线程的名字
* 6. yield()：释放当前cpu的执行权
* 7. join()：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
* 8. stop()：已过时。当执行
* 9. sleep()：让当前线程 睡眠 指定的millitimeg毫秒，在指定millitime毫秒内，当前线程是阻塞状态
* 10. isAlive()：
*
*
*
* 线程的优先级:
* 1.
* MAX_PRIORITY: 10
* MIN_PRIORITY: 1
* NORM_PRIORITY: 5 --> 默认的优先级
* 2. 如何获取和设置当前线程的优先级
* getPriority()
* setPriority()
*
*
* */
public class ThreadMethodTest {
}
