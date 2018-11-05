package com.hp.chatroom.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hp.chatroom.common.ClientIntefacePort;

/**
 * 服务端主类
 * @author Administrator
 *接口：
 * 客户端的输入监听
 * 服务端的输入接口
 * 客户端的输入异常监听
 */
public class Server implements ServerCllientMessage.UserMessageListener,
ServerInput.ServerInputListener, ServerCllientMessage.UserExceptionListener {
	
	private int port=ClientIntefacePort.PORT;//调用端口
	private String subject;//聊天主题名称
	
	private List<ServerCllientMessage> listClients=null;//客户ip集合
	
	private ServerSocket serverSocket=null;//服务监听客户端的端口
	private Nicknames clientNames=null;//昵称集合
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss"); // 聊天的时间格式化工具

	private ServerInput serverInput = null;//服务端输入
	
	 public Server(String subject) throws IOException {
	        this.subject = subject;
	        this.clientNames = new Nicknames();
	        this.serverSocket = new ServerSocket(port);
	        this.listClients = new ArrayList<>();
	        this.serverInput = new ServerInput();
	        this.serverInput.setInputListener(this);
	    }

	    // 开始监听用户的连接
	    public void startListenr() throws IOException {
	        System.out.println(this.subject + " 聊天室开启");
	        this.serverInput.startServerInput(); // 开始记录服务端输入
	        while (true) {
	            // 表示有用户连接上来了
	            Socket accept = serverSocket.accept();
	            ServerCllientMessage serverClient = new ServerCllientMessage(clientNames.randomNickName(), accept);
	            serverClient.setMsgListener(this);
	            serverClient.setExceptionListener(this);
	            listClients.add(serverClient);
	            // 对客户端说欢迎
	            welcomeToClient(serverClient);
	            tellOtherClient(serverClient);
	            // 开始监听客户端的输入信息
	            new Thread(serverClient).start();
	        }
	    }

	    // 告诉其他用户谁进入了聊天室
	    private synchronized void tellOtherClient(ServerCllientMessage client) {
	        String msg = client.getRundomnickname() + "进入了聊天室\n";
	        serverInput(msg);
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < listClients.size(); i++) {
	            if (i >= listClients.size() - 1) {
	                sb.append(listClients.get(i).getRundomnickname());
	            } else {
	                sb.append(listClients.get(i).getRundomnickname() + "，");
	            }
	        }
	        sb.append("在聊天室里，共有" + listClients.size() + "人在线");
	        serverInput(sb.toString());
	    }

	    // 欢迎用户进入聊天室、客户端得到一下提示
	    private void welcomeToClient(ServerCllientMessage client) {
	        client.sendClientMessage("欢迎来到" + this.subject + "聊天室，你的昵称是" + client.getRundomnickname() + "\n");
	    }

	    // 向用户发送消息
	    @Override
	    public synchronized void userMessage(String rundomnickname, String msg) {
	        // 这里做转发功能
	        // 昵称 时间
	        // 信息
	        String userMsg = rundomnickname + " " + getDate() + "\n" + msg;//在服务端现实你发送的消息、时间、昵称
	        System.out.println(userMsg);
	        for (ServerCllientMessage client : listClients) {
	            if (client.getClientsocket().isConnected()) {
	                client.sendClientMessage(userMsg);
	            }
	        }
	    }

	    // 获取时间
	    private String getDate() {
	        return sdf.format(new Date());
	    }

	    // 服务端的输入接口
	    @Override
	    public void serverInput(String msg) {
	        this.userMessage("Admin", msg);
	    }

	    // 用户出现异常
	    @Override
	    public synchronized void userException(String rundomnickname) {
	        // 用户读取异常，表示这个用户下线
	        System.out.println("用户异常：" + rundomnickname);
	        // 在list中移除这个用户 先移除用户，在通知其他用户
	        for (ServerCllientMessage client : listClients) {
	            if (client.getRundomnickname().equals(rundomnickname)) {
	            	listClients.remove(client);
	                return;
	            }
	        }
	        // 通知其他用户
	        userMessage(rundomnickname, rundomnickname + "这个用户下线了");
	    }
	
}
