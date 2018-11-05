package com.hp.Dome27.udp.tz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileService {


    public static void main(String[] args) throws IOException {
        //
        DatagramSocket socket = new DatagramSocket(10000);
        FileOutputStream fos = new FileOutputStream("E:\\aa\\hm.zip");

        byte[] over = "over".getBytes();

        byte[] buf = new byte[1024 * 50];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        while (true) {
            System.out.println("接受数据");

            socket.receive(packet);  // 接受数据

            byte[] data = packet.getData();
            int offset = packet.getOffset();
            int length = packet.getLength();

            if (length == over.length) {
                System.out.println("跳出循环");
                String str = new String(data, offset, length);
                System.out.println("str=" + str);
                if (str.equals("over")) {
                    break;
                }
            }
            fos.write(data, offset, length);
        }

        socket.close();
        fos.close();


    }

}
