/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 *
 * 对象流的使用
 *
 * 1. ObjectInputStream 和 ObjectOutputStream
 * 2. 作用：用于存储和读取基本数据类型或者对象的处理流
 * 3. 要想一个java对象是可序列化的，需要满足相应的要求。见Person类
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 07:21
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {
    /*
    * 序列化：将内存中的java对象保存到磁盘中挥着通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();// 刷新操作

            oos.writeObject(new Person("Yuanabao",23));
            oos.flush();// 刷新操作


            oos.writeObject(new Person("AAA",23,new Account(1000)));
            oos.flush();// 刷新操作

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    * 反序列化：将磁盘文件中的对象还原为内存的一个java对象
    * 使用ObjectInputStream
    * */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();
            System.out.println(str);
            System.out.println(person1);
            System.out.println(person2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
