package com.hp.Dome27.udp.tz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端：
 * 				注意事项：
 * 						启动有先后，先启动服务器，再启动客户端
 * 						启动之后，客户端与服务器平级，谁发送数据都可以
 * 
 * @author Administrator
 *
 */
public class NetClient {
	public static void main(String[] args) throws  IOException {
		//【1】创建一个Socket对象        --》服务器的IP，服务器监听的端口
		Socket client  = new Socket("localhost", 6666);
		//【2】准备向服务器发送数据      ---》获取输出流
		OutputStream os=client.getOutputStream();     //使用Socket的输出流
		String str="你好呀";
		os.write(str.getBytes());   //将字符串转成byte类型的数组
		//【3】发送完毕
		client.shutdownOutput();   
		
					//接收来自服务器的回复
					InputStream is = client.getInputStream();
					byte [] buf = new byte[1024];
					int len = is.read(buf);   
					System.out.println("服务器回复说："+new String(buf,0,len));
					//关闭
					is.close();
					
					
		//【4】关流
		os.close();
		client.close();
	}
}
