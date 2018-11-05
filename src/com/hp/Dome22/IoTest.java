package com.hp.Dome22;

import java.io.*;

/**
 * io测试
 */
public class IoTest {
    /**
     * 创建一个文件
     */
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = null;
        FileReader inputStream = null;
        try {
            fileWriter = new FileWriter("D:yhm.txt");
            inputStream = new FileReader("E:hm.txt");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = (inputStream.read(chars))) !=-1) {
                fileWriter.write(chars, 0, len);
            }
            System.out.println("读写完毕");
        } catch (Exception e) {
            throw new RuntimeException("读写失败");
        } finally {
            if (inputStream != null) {
                fileWriter.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }

//  File file=new File("D:/");
//        File[] files = file.listFiles();
//        for (File f:files) {
//            System.out.println(f);
//        }
//        //判断文件是否存在
//        File file2=new File("D:\\yhm.txt");
//     if (file2.exists()&&file2.length()>=0){
//         System.out.println("文件不存在或者为空");
//     }
        //   TestFile(file);


    }

    public static void TestFile(File file) {
        if (file.isFile()) {
            System.out.println("文件：" + file.getPath());
            return;
        }
        if (file.isDirectory()) {
            System.out.println("目录：" + file.getAbsoluteFile());
            File[] files = file.listFiles();
            for (File f : files) {
                TestFile(f);
            }

        }
    }
}
