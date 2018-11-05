package com.hp.Dome24;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 需求把多个文件依次拼接到一个文件里
 * 1.给定装文件的目录
 * 2.判断目录和文件是否存在
 * 3.用一个List<>集合，拼接文件名称、遍历目录中需要读取的文件、
 * 4.开始读取输入流和输出流再次利用List集合装入
 * 5.新建一个文件，把读取的对象读取到新文件中
 */
public class MergeFile {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\hm\\cn_sql_server_2008_r2_enterprise_x86_x64_ia64_dvd_522233");
        if (!file.isDirectory() && !file.exists()) {
            System.out.println("改目录无法找到");
            return;
        }
        int namefile = 1;
        List<File> list = new ArrayList<>();
        while (true) {
            String name = namefile + ".par";
            File file1 = new File(file, name);
            if (file1.exists()) {
                list.add(file1);
                namefile++;
            } else {
                break;
            }
        }
        List<InputStream> inputlist = new ArrayList<>();
        for (File f : list) {
            FileInputStream fileInputStream = new FileInputStream(f);
            inputlist.add(fileInputStream);
        }
        Enumeration<InputStream> enumeration = Collections.enumeration(inputlist);
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        File fi = new File(file, "myhm.iso");
        FileOutputStream fileOutputStream = new FileOutputStream(fi);

        byte[] buffer = new byte[1024 * 1024];
        int len = 0;
        while ((len = sis.read(buffer)) >= 0) {
            fileOutputStream.write(buffer, 0, len);
        }
        fileOutputStream.flush();

            fileOutputStream.close();


            sis.close();


    }


}
