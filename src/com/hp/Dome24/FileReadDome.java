package com.hp.Dome24;

import java.io.*;
import java.util.*;

/**
 * 1、两个文本文件，里面存着英语单词，每个单词用空格格式，
 * 2、读取这两个文件中的单词，将这两个文件中的单词写到第三个文件中
 * 3、将这两个文件中的单词，交替写到第三个文件中
 */
public class FileReadDome {

    public static void main(String[] args) throws IOException {
        File file = new File("E:/");
        //2、读取这两个文件中的单词，将这两个文件中的单词写到第三个文件中
      //  mergeFileTest(file);
        //3、将这两个文件中的单词，交替写到第三个文件中
        //mergeFileTest2(file);
    }

    public static void mergeFileTest(File file) throws IOException {
        if (!file.isDirectory() && !file.exists()) {
            System.out.println("改目录不存在");
            return;
        }
        int fileprefix = 1;
        List<File> list = new ArrayList<>();
        while (true) {
            String filename = "book" + fileprefix + ".txt";
            File f = new File(file, filename);
            if (!f.exists()) {
                System.out.println("文件已读取完毕");
                break;
            }
            list.add(f);
            fileprefix++;
        }
        List<InputStream> listinputstream = new ArrayList<>();
        for (File f : list) {
            FileInputStream fis = new FileInputStream(f);
            listinputstream.add(fis);
        }
        /**
         * 实现 Enumeration 接口的对象，
         * 它生成一系列元素，一次生成一个。
         * 连续调用 nextElement 方法将返回一系列的连续元素。
         *
         */
        /**
         * static <T> Enumeration<T>
         *  enumeration(Collection<T> c)
         *           返回一个指定 collection 上的枚举。
         */
        Enumeration<InputStream> enumeration = Collections.enumeration(listinputstream);
        //SequenceInputStream它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        //根据路径创建一个新的文件
        File newfile = new File(file, "third.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(newfile);

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = sequenceInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
