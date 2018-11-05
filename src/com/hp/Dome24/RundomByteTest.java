package com.hp.Dome24;

import java.io.*;

/**
 * 随机访问文件中的内容
 */
public class RundomByteTest {
    String str="阳浩明";
    File file=new File("E:\\我的小可爱\\hm.txt");
    RandomAccessFile randomAccessFile=null;
    FileInputStream fileInputStream=null;
    FileOutputStream fileOutputStream=null;
    {
        try {
            randomAccessFile = new RandomAccessFile("file","rws");
            Byte[] bytes=new Byte[1024];
            int len=0;
            while ((len=fileInputStream.read())!=-1){
            //    fileOutputStream.write(bytes,0,len);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
