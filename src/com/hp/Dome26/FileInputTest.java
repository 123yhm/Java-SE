package com.hp.Dome26;

import java.io.*;

/**
 * 2、将唐诗
 * 《鹿柴》
 * 作者：王维
 * 空山不见人，但闻人语响。
 * 返影入深林，复照青苔上。
 * 输出到文本文件中
 */
public class FileInputTest {
    public static void main(String[] args) throws IOException {
        String str = "《鹿柴》\r\n" +
                "  作者：王维\r\n" +
                "  空山不见人，但闻人语响。\r\n" +
                "  返影入深林，复照青苔上。\r\n" +
                "  输出到文本文件中";
        File file = new File("E:\\我的小可爱\\yhm.txt");
        TestFile(file, str);
    }

    /**
     * 字符方式存储
     * @param file
     * @param str
     * @throws IOException
     */
    public static void TestFile(File file, String str) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.flush();
        if (fileWriter != null) {
            fileWriter.close();
        }
    }

    /**
     * 字节方式存入
     * @param file
     * @param str
     * @throws IOException
     */
    public static void  testFileInputStrean(File file, String str) throws IOException {
       FileOutputStream fileOutputStream=new FileOutputStream(file);

       fileOutputStream.write(str.getBytes());
    }
}
