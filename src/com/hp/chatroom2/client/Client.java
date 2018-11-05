package com.hp.chatroom2.client;

import com.hp.chatroom2.common.ClientIntefacePort;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端的主类
 * ip
 *port
 * shock
 */
public class Client {
    private String ip;
    private  int port= ClientIntefacePort.PORT;
    private Socket socket;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public  int getPort() {
        return port;
    }

    public  void setPort(int port) {
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public  Client(){
    }
    public Client(String ip){
        super();
        this.ip=ip;
        this.port=ClientIntefacePort.PORT;
    }
    //连接服务
    public void connectServer() throws IOException {
            socket=new Socket(ip,port);

    }

    //客户端输入
    public void clientInput(){

    }

    //客户端接收服务端消息
}
