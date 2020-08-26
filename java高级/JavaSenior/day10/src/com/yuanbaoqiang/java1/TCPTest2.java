/**
 * <h3>JavaSenior</h3>
 * <p>
 *     实现TCP的网络编程
 *     例题2：客户端发送文件给服务端，服务端将文件保存在本地
 *
 * </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 13:26
 **/

package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {

    @Test
    public void client() throws IOException {
        // 1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.2"),9090);
        // 2.
        OutputStream os = socket.getOutputStream();
        // 3.
        FileInputStream fis = new FileInputStream(new File("wallhaven-oxrq99.jpg"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 5.
        bis.close();
        os.close();
        socket.close();

    }

    /*
    * 这里涉及到的异常，应该使用try-catch-finally处理
    * */
    @Test
    public void server() throws IOException {
        // 1.
        ServerSocket ss = new ServerSocket(9090);
        // 2.
        Socket socket = ss.accept();
        // 3.
        InputStream is = socket.getInputStream();
        // 4.
        FileOutputStream fos = new FileOutputStream(new File("01.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 5.
        byte[] buffer = new  byte[20];
        int len;
        while((len = is.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }
        // 6.
        bos.close();
        is.close();
        socket.close();
        ss.close();



    }


}
