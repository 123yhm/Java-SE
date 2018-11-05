package com.hp.chatroom.client;

import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.hp.chatroom.common.InputPublic;

/**
 * 封装客户端的输入动作
 * 
 * @author Administrator
 *
 */
public class ClientInput implements Runnable, InputPublic {
	private Client client;// 调用客户端的socket返回一个输入流
	private OutputStream outputStream = null;// 向服务端发送消息
	private BufferedReader bufferedReader;// 高数读取到缓存中

	public ClientInput(Client client) throws IOException {//类的有残构造函数
		this.outputStream = client.getClientSocket().getOutputStream();
		InputStreamReader inputstreamready = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputstreamready);
	}

	/**
	 * 线程方法
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		input();
	}

	/**
	 * 输入信息方法
	 */

	@Override
	public void input() {
		try {
			while (true) {//多次接受写入消息
				String str = bufferedReader.readLine();
				if (str.equals("hm")) {
					client.exit();//关闭客户端
					break;
				}
				if (outputStream != null) {//输入不为空开始写入
					outputStream.write(str.getBytes());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("接受键盘消息异常");
		}

	}

}
