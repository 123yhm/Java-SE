package com.hp.Dome27.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

/**
 * 客户端
 *
 * 传送文件
 *
 * 1.需要文件地址
 * 2.
 *
 *
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\aa\\mysql-5.7.21-winx64.zip");
        String fileName="你好";
        String ip="192.168.1.106";
        int port=1;
        testClient(file,fileName,ip,port);
    }
    public static void testClient(File file,String fileName,String ip,int port) throws IOException{
        Socket client=new Socket(ip,port);
        if(!file.exists()&&!file.isFile()){
            System.out.println("该文件不存在");
            return;
        }
        FileInputStream fis=new FileInputStream(file);
        OutputStream os=client.getOutputStream();
        byte[] bytes=new byte[1024*50];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        client.shutdownOutput();

        client.close();
        os.close();
        fis.close();


    }
}
