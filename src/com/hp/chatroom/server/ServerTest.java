package com.hp.chatroom.server;

import java.io.IOException;



/**
 * 服务端测试类
 * @author Administrator
 *
 */
public class ServerTest {
	public static void main(String[] args) throws IOException {
		Server server=new Server("王者荣耀");
		server.startListenr();
	}
}
