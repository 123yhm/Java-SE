package com.hp.chatroom.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.hp.chatroom.common.ClientIntefacePort;

/**
 * 客户端主类
 * @author Administrator
 *
 */
public class Client {
	/**
	 * 客户端属性
	 * 
	 */
	private String clientIp;
	private int clientPort=ClientIntefacePort.PORT;
	private Socket clientSocket;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	

	public Client(String clientIp) {
		super();
		this.clientIp=clientIp;
		this.clientPort = ClientIntefacePort.PORT;
	}


	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public int getClientPort() {
		return clientPort;
	}

	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
/**
 * 连接服務器
 * @throws IOException 
 * @throws UnknownHostException 
 */
	public void connectServer() throws UnknownHostException, IOException{
		if(clientSocket==null){
			clientSocket=new Socket(clientIp,clientPort);
		}
		//当连接到服务器时调用客户端的输入动作和接收服务器信息
		inputClient();
		outputServerClient();
	}
	//客户端可以退出服务器
	public void exit(){
		System.out.println("退出服务器");
	}
	
	/**
	 * 客服端输入动作
	 */
	public void inputClient(){
		if(clientSocket.isConnected()){//监听客户端的连接状态
		try {//开启客户端的输入消息线程
			new Thread(new ClientInput(this)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	/**
	 * 客服端接收服务端聊天室的消息动作
	 */
	public void outputServerClient(){
		if(clientSocket.isConnected()){//监听客户端的连接状态
			System.out.println("成功进入聊天室");
			try {//开启客户端的接受消息线程
				new Thread(new AcceptServerMessage(clientSocket.getInputStream())).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
}
