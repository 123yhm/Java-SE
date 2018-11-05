package com.hp.chatroom.server;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.hp.chatroom.common.InputPublic;
/**
 * 服务端输入 动作类
 * @author Administrator
 *
 */
public class ServerInput implements InputPublic, Runnable {

    private BufferedReader br = null;
    private ServerInputListener inputListener;

    public ServerInputListener getInputListener() {
        return inputListener;
    }

    public void setInputListener(ServerInputListener inputListener) {
        this.inputListener = inputListener;
    }

    public ServerInput() {
        InputStream is = System.in;//服务端输入
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);//读入缓存
    }

    public void startServerInput() {
        new Thread(this).start();
    }

    @Override
    public void input() {//读取一行
        try {
            while (true) {
                String s = br.readLine();
                if (this.inputListener != null) {
                    this.inputListener.serverInput(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        this.input();//开启线程调用input接口执行服务端消息的读取
    }

    public interface ServerInputListener {//一个服务端的输入内部接口
        void serverInput(String msg);
    }

}
