/**
 * <h3>我的代码</h3>
 * <p>理解“万事万物皆为对象”</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-25 17:53
 **/

/*
理解“万事万物皆为对象”
1. 在Java语言范畴中，我们都将功能结构等封装到类中，通过类的实例化，来调用具体的功能结构
    > Scanner, String等
    > 文件：File
    > 网络地址：URL
2. 涉及到Java语言与前端Html、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象。

二、内存解析的说明
1. 引用类型的变量，只可能存储两类值：null  或  地址值（含变量的类型）

三、匿名对象的使用
1. 理解：我们创建的对象，没有显示的赋给一个变量名。即为匿名对象
2. 特征：匿名对象只能调用一次
3. 使用：如下

 */


package com.yuanbaoqiang.java;

public class InstanceTest {
    public static void main(String[] args){
       Phone p = new Phone();
       // p = null;
       System.out.println(p); // 地址值

        p.playGame();;
        p.sendeMail();

        // 匿名对象
/*        new Phone().sendeMail();
        new Phone().playGame();*/

        new Phone().price = 1999;
        new Phone().getPrice();

        // *******************************************
        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());

    }
}

class PhoneMall{
    public void show(Phone phone){
        phone.sendeMail();
        phone.playGame();
    }
}

class Phone{
    double price; // 价格

    public void sendeMail(){
        System.out.println("发送邮件");
    }

    public void playGame(){
        System.out.println("玩游戏");
    }

    public void getPrice(){
        System.out.println("手机的价格为：" + price);
    }
}
