package com.hp.Dome23;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

/**
 * 删除某个目录（盘）下的所有文件
 */
public class DelFileTest {
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        String str= sca.next();
        File file=new File(str);
        TestDelFile(file);
    }

    //@Test
    public static void TestDelFile(File file) {
        if (file.isFile()) {//删除文件
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                TestDelFile(f);//递归方法
            }
          //  file.delete();//删除目录
        }

    }
}
