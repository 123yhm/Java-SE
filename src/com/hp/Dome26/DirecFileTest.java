package com.hp.Dome26;

import com.hp.test3.Test;

import java.io.File;

/**
 * 3、任意目录，列出目录中指定类型的所有文件
 */
public class DirecFileTest {
    public static void main(String[] args) {
        File file=new File("E:\\我的小可爱");
        TestFile(file);
    }
    public static void TestFile(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f:files) {
                TestFile(f);
            }
        }

        if(file.isFile()){
            if (file.getName().lastIndexOf(".java")!=-1){
                System.out.println("Java文件为----："+file.getPath());
            }
        }
    }
}
