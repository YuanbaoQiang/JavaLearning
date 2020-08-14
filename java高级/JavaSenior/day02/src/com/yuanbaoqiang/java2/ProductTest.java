/**
 * <h3>JavaSenior</h3>
 * <p>线程通信的应用：经典例题：生产者/消费者问题</p>
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何来解决线程的安全问题？同步机制，有三种方法
 * 4. 是否涉及到线程的通信？是
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-13 21:20
 **/

package com.yuanbaoqiang.java2;

// 店员
class Clerk{

    private int productNumber = 0;

    // 生产产品
    public synchronized void produceProduct() {
        if(productNumber < 20){
            productNumber++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productNumber + "个产品");
            notify();
        }else{
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费产品
    public synchronized void consumeProduct() {
        if(productNumber > 0){
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productNumber + "个产品");
            productNumber--;
            notify();
        }else{
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Productor extends Thread{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始生产产品......");

        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            clerk.produceProduct();
        }
    }
}

// 消费者
class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {

        System.out.println(getName() + "：开始生产产品......");

        while(true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            clerk.consumeProduct();
        }





    }
}



public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        p1.setName("生产者1");

        Customer c1 = new Customer(clerk);
        c1.setName("消费者1");

        Customer c2 = new Customer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
