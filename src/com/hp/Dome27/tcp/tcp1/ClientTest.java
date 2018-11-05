package com.hp.Dome27.tcp.tcp1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
     //   ClientNameEntity cne=new ClientNameEntity("小明","192.168.1.102");
        System.out.println("==============客户端=================");
        Socket socket=new Socket("localhost",1);
        System.out.println("进入房间成功");
        System.out.println("请输入：");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        new Thread(new testRun(outputStream)).start();
        new Thread(new testRunServer(inputStream)).start();
    }

    /**
     * 键盘输入信息
     */
    static class  testRun implements  Runnable{
        OutputStream outputStream;
        BufferedReader bufferedReader;

        public testRun(OutputStream outputStream) {
            this.outputStream = outputStream;
            InputStream is=System.in;
            InputStreamReader isr=new InputStreamReader(is);
            bufferedReader=new BufferedReader(isr);
        }

        @Override
        public void run() {
            try {
                while(true){
                    String string = bufferedReader.readLine();
                    outputStream.write(string.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

            }
        }
    }

    /**
     * 接受信息
     */
    static class  testRunServer implements  Runnable{
        InputStream inputStream;
        public testRunServer( InputStream inputStream) throws IOException {
            this.inputStream = inputStream;
        }
        @Override
        public void run() {
            try {
                byte[] byf=new byte[1024];
                int read = 0;
               while(true){
                   read = inputStream.read(byf);
                   String str=new String(byf,0,read);
                   System.out.println("客服--："+str);
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
