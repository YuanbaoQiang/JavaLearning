/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-22 13:10
 **/

package com.yuanbaoqiang.exer;

import java.io.*;

public class Test {
    @org.junit.Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 创建文件及流
            bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\YuanbaoQiang\\Desktop\\test\\课件笔记源码资料.zip")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\YuanbaoQiang\\Desktop\\test\\课件笔记源码资料02.zip")));
            // 数据的读取和写出
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
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
        }
    }

    // 图片的加密
    @org.junit.Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            // FileInputStream fis = new FileInputStream(new File("wallhaven-oxrq99.jpg"));
            fis = new FileInputStream("wallhaven-oxrq99.jpg");
            fos = new FileOutputStream("wallhaven-secret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // 字节数据进行修改
                // 错误的
    /*            for (byte b : buffer){
                    b = (byte) b ^ 5;
                }*/

                // 正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 图片的解密
    @org.junit.Test
    public void test3() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            // FileInputStream fis = new FileInputStream(new File("wallhaven-oxrq99.jpg"));
            fis = new FileInputStream("wallhaven-secret.jpg");
            fos = new FileOutputStream("wallhaven-unsecret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // 字节数据进行修改
                // 错误的
    /*            for (byte b : buffer){
                    b = (byte) b ^ 5;
                }*/

                // 正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
