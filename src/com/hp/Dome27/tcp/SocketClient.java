package com.hp.Dome27.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 顾客发消息
 * 1.创建一个Socket对象        --》服务器的IP，服务器监听的端口
 *2.从键盘准备向服务器发送数据      ---》获取输出流
 * 3.关闭套接字
 * 接受服务端的消息
 * 1.接收来自服务器的回复
 * 2.转换成字符串进行输出
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        // 构建客户端 socket
        Socket client = new Socket(inetAddress, 1);
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        while (true) {
            // 得到用户输入的一个数据
            String s = br.readLine();
            if (s.equals("over")) {
                break;
            }
            // 向服务端写数据
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(s.getBytes());
            client.shutdownOutput();
            outputStream.flush();
            // 获取服务端的数据
            byte[] buf = new byte[1024];
            InputStream inputStream = client.getInputStream();
            int read = inputStream.read(buf);
            if (read<0) {
                System.out.println("服务退出了聊天");
                break;
            }
            String str = new String(buf, 0, read);
            if (str.equals(" ")) {
                System.out.println("服务退出了聊天");
                break;
            }
            System.out.println("客服："+str);
        }
        // 释放资源
        client.close();
    }


}
