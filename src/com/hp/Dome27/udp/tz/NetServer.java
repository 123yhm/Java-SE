package com.hp.Dome27.udp.tz;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器：
 * 	
 * @author Administrator
 *
 */
public class NetServer {
		public static void main(String[] args) throws IOException {
			//【1】创建对象      -----》写一个监听的端口号（与客户端端口相同）
			ServerSocket server = new ServerSocket(6666);
			//【2】获取客户端的Socket对象
			Socket client=server.accept();     //用于获取客户端的对象，如果一直没有客户端与之链接的话，处于阻塞状态（没资格）有客户端来链接的时候进入就绪状态，等待cpu的调度
			//【3】获取客户端发送来的数据   ---》输入流
			InputStream is = client.getInputStream();
			byte [] buf = new byte[1024];
			int len =is.read(buf);
			String str = new String(buf, 0, len);
			client.shutdownInput();//接收完毕
			//【4】输出客户端发来的信息
			System.out.println("收到：客户端的IP为+"+client.getInetAddress()+"发送的消息为：+"+str);
						
							//回复客户端    -->获取当前客户端的输出流，目的是回复数据
							OutputStream os = client.getOutputStream();
							//回复  字节
							os.write("大家好才是真的好--- 广州好迪".getBytes());     
							client.shutdownOutput();
							//关闭
							os.close();
						
			//【5】关闭
			is.close();
			client.close();
			server.close();   //可选	
		}
}
