/**
 * <h3>JavaSenior</h3>
 * <p></p>
 * <p>
 * 处理流之一：缓冲流的使用
 * <p>
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2. 作用：提高流的读取和写入的速度
 *
 * 3. 处理流，就是“套娃”在已有的流的基础上。
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-22 10:07
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.io.*;

public class BufferedTest {

    @Test
    public void BufferedStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File("wallhaven-oxrq99.jpg");
            File destFile = new File("wallhaven1.jpg");
            // 2. 造流
            // 2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取和写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            // 要求：先关闭外层的流，再关闭内层的流

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭可以省略
/*            fos.close();
            fis.close();*/
        }

    }


    public void copyFileWithBuffered(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            // 2. 造流
            // 2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取和写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            // 要求：先关闭外层的流，再关闭内层的流

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭可以省略
/*            fos.close();
            fis.close();*/
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\YuanbaoQiang\\Desktop\\test\\课件笔记源码资料.zip";
        String destPath = "C:\\Users\\YuanbaoQiang\\Desktop\\test\\dest2.zip";
        copyFileWithBuffered(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start)); // 8211 --> 1836
    }

    /*
    * 使用BufferedReader和BufferedWriter实现文本文件的复制
    *
    * */

    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 造文件、造流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello4.txt")));

            // 读写操作
            // 方式一：使用char[] 数组
/*            char[] cbuf = new char[1024];
            int len;
            while((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }*/

            // 方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                // 方法一：
                //bw.write(data + "\n");// data中不包含换行符
                // 方法二：
                bw.write(data); // data中不包含换行符
                bw.newLine(); // 提供换行的操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(br != null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }

}
