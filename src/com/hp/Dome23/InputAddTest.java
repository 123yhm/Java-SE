package com.hp.Dome23;

import java.io.File;
import java.util.Scanner;

/**
 * 输入一个目录，打印其目录中的所有文件
 */
public class InputAddTest {
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        String next = sca.next();
        File file = new File(next);
        test(file);
    }

    public static void test(File file) {

        if (file.isFile()) {
            System.out.println("文件-----"+file.getPath());
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
               // System.out.println("目录"+f.getPath());
                test(f);
            }
        }
    }
}
