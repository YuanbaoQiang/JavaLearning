/**
 * <h3>JavaSenior</h3>
 * <p>
 *
 *    实现TCP的网络编程
 *  * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 *  * 并关闭相应的连接。
 *
 *
 * </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 13:44
 **/

package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {

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

        // 关闭数据的输出
        socket.shutdownOutput();

        // 5. 接收来自于服务端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[1024];
        int len1;
        while((len1 = is.read(buffer1)) != -1){
            baos.write(buffer1,0,len1);
        }

        System.out.println(baos.toString());

        // 6.
        baos.close();
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
        FileOutputStream fos = new FileOutputStream(new File("02.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 5.
        byte[] buffer = new  byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        System.out.println("图片传输完成！");

        // 6. 服务器端给予反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我已经收到，非常漂亮".getBytes());


        // 7.
        os.close();
        bos.close();
        is.close();
        socket.close();
        ss.close();

    }
}
