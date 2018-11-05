package com.hp.tz;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *Io流练习
 */
public class TestStream {
    public static void main(String[] args)throws IOException  {
        System.out.println("请输入一行字存入文本：");
        FileOutputStream fos=new FileOutputStream("E:\\wcy.txt");
        //OutputStreamWriter 是字符流通向字节流的桥梁：
        Writer w=new OutputStreamWriter(fos,"utf-8");
        Reader r=new InputStreamReader(System.in,"utf-8");
        BufferedWriter bw=new BufferedWriter(w);
        BufferedReader br=new BufferedReader(r);
        int len=0;
        String string = br.readLine();
        while(string!=null){
            if(string.equals("q")){
                break;
            }
            bw.write(string);
            string=br.readLine();
            bw.flush();
        }

        br.close();
        bw.close();
        r.close();
        w.close();
    }
    @Test
    public  void testStream(){//字符流
        PrintWriter pw=new PrintWriter(System.out);
        pw.print("你好\n");
        pw.print("早上好\n");
        pw.close();
    }
    @Test
    public void testUrl() throws IOException {//URL：统一资源定位符/获取网络资源
        URL urlname=new URL("https://www.baidu.com");
        InputStream is=urlname.openStream();
        Reader r=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(r);
        String len=" ";
        while ((len=br.readLine())!=null){
            System.out.println(len);
        }

    }
}
