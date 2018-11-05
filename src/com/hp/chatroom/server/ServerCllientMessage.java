package com.hp.chatroom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端与服务端的信息发送与监听接受
 * 
 * @author Administrator
 *
 */
public class ServerCllientMessage implements Runnable{
	private String rundomnickname; // 用户的随机昵称
	private Socket clientsocket; // 服务端得到的用户Socket

	private UserMessageListener msgListener;// 客户端消息监听
	private UserExceptionListener exceptionListener;// 客户端消息异常

	public Socket getClientsocket() {
		return clientsocket;
	}

	public void setClientsocket(Socket clientsocket) {
		this.clientsocket = clientsocket;
	}

	public ServerCllientMessage() {

	}

	public ServerCllientMessage(String rundomnickname, Socket clientsocket) {//初始化客户端名和和客户端名称
			this.rundomnickname=rundomnickname;
			this.clientsocket=clientsocket;
			InetAddress inetAddress=clientsocket.getInetAddress();//得到客户端的ip并给他一个 名字打印输出在服务端
			System.out.println(inetAddress.getHostAddress()+"|"+rundomnickname);
	}

	public String getRundomnickname() {
		return rundomnickname;
	}

	public void setRundomnickname(String rundomnickname) {
		this.rundomnickname = rundomnickname;
	}
	

	public UserMessageListener getMsgListener() {
		return msgListener;
	}

	public void setMsgListener(UserMessageListener msgListener) {
		this.msgListener = msgListener;
	}

	public UserExceptionListener getExceptionListener() {
		return exceptionListener;
	}

	public void setExceptionListener(UserExceptionListener exceptionListener) {
		this.exceptionListener = exceptionListener;
	}


    

	
/**
 * 向客户端发送消息
 */
	public void  sendClientMessage(String msg){
		try {
			OutputStream outputStream = clientsocket.getOutputStream();
			outputStream.write(msg.getBytes());
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  if (exceptionListener != null) {
				  exceptionListener.userException(this.rundomnickname);
	            }
		}
		
	}
	@Override
	public void run() {
		
		   try {
	            byte[] buf = new byte[1024];
	            while (true) {
	                if (clientsocket.isConnected() && !clientsocket.isInputShutdown()) {
	                    InputStream inputStream = clientsocket.getInputStream();
	                    int read = inputStream.read(buf);
	                    // 得到用户输入的信息，并将用户的信息转发给其他用户
	                    String userMsg = new String(buf, 0, read);
	                    if (this.msgListener != null) {
	                        msgListener.userMessage(this.rundomnickname, userMsg);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            //输入异常
	            if (exceptionListener != null) {
	                exceptionListener.userException(this.rundomnickname);
	            }
	        }
	}
	/**
	 *两个端的输入监听和输入异常监听接口
	 * @author Administrator
	 *
	 */
	public interface UserMessageListener {
        void userMessage(String rundomnickname, String msg);
    }

    public interface UserExceptionListener {
        void userException(String rundomnickname);
    }

}
