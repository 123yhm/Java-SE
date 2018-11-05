package com.hp.Dome27.udp.tz;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FileClient {


    public static void main(String[] args) throws IOException, InterruptedException {

        // 准备DatagramSocket
        DatagramSocket socket = new DatagramSocket();

        //  文件输入流
        FileInputStream fis = new FileInputStream("E:\\aa\\mysql-5.7.21-winx64.zip");
        byte[] buf = new byte[1024 * 50]; // 读取50K的数据
        int readlen = 0;
        while ((readlen = fis.read(buf)) >= 0) {

            // 准备的文件数据包
            DatagramPacket packet = new DatagramPacket(buf, readlen);
            packet.setAddress(InetAddress.getByName("192.168.1.106"));
            packet.setPort(10000);

            // 发送数据
            socket.send(packet);

            // 防止发送数据太快，服务端处理不过来
           Thread.sleep(20);

        }

        // 准备结束的数据包
        byte[] over = "over".getBytes();
        DatagramPacket packet = new DatagramPacket(over, over.length);
        packet.setAddress(InetAddress.getByName("192.168.1.106"));
        packet.setPort(10000);
        socket.send(packet);


        // 释放资源
        socket.close();
        fis.close();


    }

}
