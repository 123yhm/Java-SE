package com.hp.Dome26;

import java.io.File;

/**
 * 1、任意目录，列出文件及目录
 */
public class FileTest {
    public static void main(String[] args) {
        File file=new File("E:\\我的小可爱");
        Test(file);
    }
    public static void  Test(File file){
        if (file.isFile()){
            System.out.println("文件---"+file.getPath());
            return;
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f:files) {
                System.out.println("目录-"+f.getPath());
                Test(f);
            }

        }
    }
}
