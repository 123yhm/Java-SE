package com.hp.Dome27.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客服接消息：
 *1.创建对象      -----》写一个监听的端口号（与客户端端口相同）
 * 2.获取客户端的Socket对象
 * 3.获取客户端发送来的数据   ---》输入流
 *向顾客回消息：
 * 1.回复客户端    -->获取当前客户端的输出流
 *2.从键盘输入，转换成字节
 */
public class SocketService {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(1);
        Socket client = socket.accept();
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        while (true) {
            byte[] buf = new byte[1024];
            InputStream inputStream = client.getInputStream();
            int read = inputStream.read(buf);
            if (read < 0) {
                System.out.println("顾客退出聊天");
                break;
            }
            String var = new String(buf, 0, read);
            if (var.equals("over")) {
                System.out.println("顾客退出聊天");
                break;
            }
            System.out.println("顾客:" + var);
            String s = br.readLine();
            if (s.equals("over")) {
                break;
            }
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(s.getBytes());
            outputStream.flush();
        }
        socket.close();
    }


}
