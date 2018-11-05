package com.hp.Dome26.Dome;

import java.io.*;

/**
 * 6、使用RandomAccessFile 将
 * 《登鹳雀楼》 作者：王之涣
 * 白日依山尽，黄河入海流。
 * 欲穷千里目，更上一层楼。
 * 写入到文件中
 */
public class AddContentTest {
    public static void main(String[] args) throws IOException {
        String str="\r\n《登鹳雀楼》 \r\n"+"作者：王之涣\r\n" +
                " 白日依山尽，黄河入海流。\r\n" +
                " 欲穷千里目，更上一层楼。";
        File file=new File("E:\\wcy.txt");
       // testContent(str,file);//第一种读写方式
        testInputFile(str,file);//第二种读写方式
    }
    public static void  testContent( String str,File file) throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        //RandomAccessFile:此类的实例支持对随机访问文件的读取和写入
        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        raf.write(str.getBytes());
        raf.close();
    }
    public static void testInputFile(String str,File file)throws  IOException{
        if (!file.exists()&&!file.isFile()){
            return;
        }
        FileWriter fw=new FileWriter(file,true);
        //BufferedWriter:将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
       BufferedWriter bfw=new BufferedWriter(fw);
       bfw.write(str);
       bfw.flush();
       bfw.close();
    }
}
