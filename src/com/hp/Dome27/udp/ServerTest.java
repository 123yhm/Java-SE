package com.hp.Dome27.udp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 服务端
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\aa\\yy.zip");
        int port=1;
        fileDownTest(file,port);
    }
    public static void fileDownTest(File file,int port) throws IOException {
        ServerSocket server=new ServerSocket(port);
        Socket client=server.accept();
       // FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(file);
        InputStream is = client.getInputStream();
        byte[] buf=new byte[1024*50];
        int len=0;
        while((len=is.read(buf))!=-1){
            fos.write(buf,0,len);
            fos.flush();
        }
        client.shutdownOutput();
        is.close();
        server.close();
    }
}
