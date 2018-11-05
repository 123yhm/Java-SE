package com.hp.chatroom.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装服务端返回出来的聊天室的消息
 * 
 * @author Administrator
 *
 */
public class AcceptServerMessage implements Runnable {
	private InputStream inputStream;

	public AcceptServerMessage(InputStream inputStream){
		this.inputStream=inputStream;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		byte[] buf = new byte[1024];
		while (true) {// 无限接受消息
			try {
				int read = inputStream.read(buf);// 读取到缓存
				String str = new String(buf, 0, read);
				System.out.println(str);// 输出到控制台
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("用户显示出现异常");
				break; // 出现异常，跳出循环
			}
		}

	}

}
