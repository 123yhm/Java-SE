package com.hp.Dome26;

import java.io.*;

/**
 * 3、复制文件
 */
public class CopyFileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\我的小可爱\\yhm.txt");
        File file2 = new File("E:\\我的小可爱\\hm.txt");
        copyFileTest(file, file2);
    }

    public static void copyFileTest(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        if (!file2.exists()) {
            file2.createNewFile();

        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        //byte[] ty = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read()) != -1) {
            fileOutputStream.write(len);
        }
        fileOutputStream.flush();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
