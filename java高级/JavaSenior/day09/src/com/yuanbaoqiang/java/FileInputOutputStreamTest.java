/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-22 08:50
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.io.*;

/*
* 测试FileInputStream和FileOutputStream的使用
*
* 结论：
* 1. 对于文本文件（.txt,.doc,.c,.cpp），使用字符流处理
* 2. 对于非文本文件（.jpg,.mp3,.avi,.ppt,.doc），使用字节流处理
* 3.
*
*
* */

public class FileInputOutputStreamTest {

    // 使用字节流FileInputStream处理文本文件，可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;

        try {
            // 1. 创建File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            // 2. 创建输入流的对象
            fis = new FileInputStream(file);

            // 3. 数据的读入操作
            byte[] buffer = new byte[5];
            int len; // 记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭输入流和输出流资源
            if(fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    *
    * 实现对图片的复制操作
    *
    * */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. 创建File类
            File srcFile = new File("wallhaven-oxrq99.jpg");
            File destFile = new File("wallhaven.jpg");

            // 2. 创建输入流和输出流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3. 数据的读入和写出
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if( fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null){

                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
     * @description: 完成指定路径文件的复制
     * @author: YuanbaoQiang
     * @date: 2020/8/22 9:40
     * @param srcPath 源文件路径
     * @param destPath 目标文件路径
     * @return: void
     */
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. 创建File类
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2. 创建输入流和输出流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3. 数据的读入和写出
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if( fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null){

                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\YuanbaoQiang\\Desktop\\test\\课件笔记源码资料.zip";
        String destPath = "C:\\Users\\YuanbaoQiang\\Desktop\\test\\dest.zip";

/*        String srcPath = "hello.txt";
        String destPath = "hello3.txt";*/

        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start)); // 8211
    }
}
