/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 *
 * 一、流的分类：
 * 1. 操作数据单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类                         节点流（或文件流）                                                  缓冲流（处理流的一种）
 * InputStream                      FileInputStream（read(byte[] cbuf)）                             BufferedInputStream
 * OutputStream                     FileOutputStream（write(byte[] buffer,0,len)）                   BufferedOutputStream
 * Reader                           FileReader（read(char[] cbuf)）                                  BufferedReader
 * Writer                           FileWriter（write(char[] cbuf,0,len)）                           BufferedWriter
 *
 *
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-21 10:18
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.io.*;

public class FileReaderWirterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt"); // 相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 =  new File("day09","hello.txt");
        System.out.println(file1.getAbsolutePath());
    }


    /*
    * 将day09下的hello.txt文件的内容读入程序中，并输出到控制台
    *
    *
    * 说明点：
    * 1. read()的理解
    * 2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    * 3. 读入的文件一定存在，否则就会存在FileNotFoundException
    *
    *
    *
    * */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            // 1. 实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");// 相较于当前Module

            // 2. 提供具体的流
            fr = new FileReader(file);

            // 3. 数据的读入
            // read()：返回读入的一个字符，如果达到文件末尾，返回-1
/*        int data = fr.read();
        while(data != -1){
            System.out.print((char) data);
            data = fr.read();
        }*/

            // 方式二：语法上针对方式一的修改
            int data;
            while((data = fr.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流的关闭操作
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    // 对read()操作升级，使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            // 1. File类的实例化
            File file = new File("hello.txt");
            // 2. FileReader流的实例化
            fr = new FileReader(file);
            // 3. 读入的具体操作细节
            // read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                // 方式一
                // 错误的写法
/*                for(int i = 0; i < cbuf.length; i++){
                    System.out.println(cbuf[i]);
                }*/

                // 正确的写法
/*                for(int i = 0; i < len; i++){
                    System.out.print(cbuf[i]);
                }*/

                // 方式二
                // 错误的写法，对应着方式一的错误的写法
/*                String str = new String(cbuf);
                System.out.println(str);*/

                // 争取的写法
                String str = new String(cbuf,0,len);
                System.out.println(str);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                // 4. 资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /*
    * 从内存中写出数据到硬盘的文件里。
    *
    * 说明：
    * 1. 输出操作，对应的File可以不存在。
    * 2.
    * File对应的文件如果不存在，在输出的过程中，会自动创建此文件。
    * File对应的文件如果存在：
    *           如果流使用的构造器是：FileWriter(file,false) / FileWriter(true):对原有文件的覆盖
    *           如果流使用的构造器是：FileWriter(file,true)：不会对原有文件覆盖，而是在原有文件基础上追加内容
    *
    *
    *
    * */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            // 1. 提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            // 2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,true);

            // 3. 写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                // 4. 流资源的关闭
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }


    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File scrFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            // 不能使用字符流来使用图片等字节数据
/*            File scrFile = new File("wallhaven-oxrq99.jpg");
            File destFile = new File("wallhaven.jpg");*/

            //2. 创建输入流和输出流的对象
            fr = new FileReader(scrFile);
            fw = new FileWriter(destFile);

            //3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; //记录每次读入cbuf数组中的数据的字符个数
            while((len = fr.read(cbuf)) != -1){
                // 每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // blog
    @Test
    public void test1(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("hello.txt"));

            byte[] buffer = new byte[4];
            int len;
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(new File("hello.txt"));

            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
