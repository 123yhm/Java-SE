package com.hp.Dome27.tcp.tcp1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

/**
 * 服务器
 */
public class ServerTest implements Runnable{
    static ServerSocket server = null;
    static Socket accept = null;
    static String[] strname = {"小明", "小芳", "小彪", "小健", "小灿", "小城", "张三", "李四", "王五"};
    static  ArrayList<Socket> list = new ArrayList<Socket>();
    public ServerTest() {// 构造方法
        try {
            server = new ServerSocket(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ServerTest serverTest=new ServerTest();
        int count = 0;//人数
        System.out.println("=================服务端===================");
        while (true) {
            try {
                accept = server.accept();
              //  System.out.println(accept);
               // System.out.println("123");
                count++;
                System.out.println("第" + count + "个用户以上线");
                list.add(accept);
              //  System.out.println("456");
            } catch (IOException e) {
                e.printStackTrace();
            }

            Thread read = new Thread(serverTest);
            read.start();
            inputMessage input=new inputMessage(accept.getOutputStream());
            Thread inputThred=new Thread(input);
            inputThred.start();

            receiveMessages receive=new receiveMessages(accept.getInputStream());
            Thread receiveThred=new Thread(receive);
            receiveThred.start();
         //   new Thread(new ServerTest.testRun(accept.getOutputStream())).start();
          //  new Thread(new ServerTest.testRunServer(accept.getInputStream())).start();
        }

    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(accept
                    .getInputStream()));
            while (true) {
                String jieshou = in.readLine();
                System.out.println( jieshou);
                for (int i = 0; i < list.size(); i++) {
                    Socket accept=list.get(i);
                    PrintWriter out = new PrintWriter(accept.getOutputStream());
                    if (accept!=this.accept) {
                        out.println(jieshou);
                    }else{
                        out.println("(你)"+jieshou);
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
}


    /**
     * 监听每个ip
     */
    static class testMonitor implements Runnable {
        @Override
        public void run() {

        }

    }

    /**
     * 转发消息
     */
    static class testTransmit implements Runnable {
        @Override
        public void run() {

        }
    }

    /**
     * 键盘输入信息
     */
    static class inputMessage implements Runnable {
        OutputStream outputStream;
        BufferedReader bufferedReader;

        public inputMessage(OutputStream outputStream) {
            this.outputStream = outputStream;
            InputStream is = System.in;
            InputStreamReader isr = new InputStreamReader(is);
            bufferedReader = new BufferedReader(isr);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String string = bufferedReader.readLine();
                    outputStream.write(string.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 接受信息
     */
    static class receiveMessages implements Runnable {

        InputStream inputStream;

        public receiveMessages(InputStream inputStream) throws IOException {
            this.inputStream = inputStream;

        }

        @Override
        public void run() {

            try {
                byte[] byf = new byte[1024];
                int read = 0;
                while (true) {

                    read = inputStream.read(byf);
                    String str = new String(byf, 0, read);
                    System.out.println(strname[new Random().nextInt(strname.length)] + "你好:" + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
