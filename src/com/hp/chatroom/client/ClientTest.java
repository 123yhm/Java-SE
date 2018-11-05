package com.hp.chatroom.client;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * 客户端测试类
 *
 * @author Administrator
 */
public class ClientTest {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Client client = new Client("localhost");//给出Ip
        client.connectServer();//开始连接服务

    }
}
