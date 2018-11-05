package com.hp.Dome24;

import java.io.*;

/**
 * SequenceInputStream 文件切割 & 文件合并
 * 1.给定文件路劲
 * 查找后缀、去掉后缀
 * SequenceInputStream 文件切割 & 文件合并
 * while读取
 * 判断文件大小是否满足条件、满足条件，关闭流、重开
 * 新创建文件进行读取
 */
public class Down {
    public static void main(String[] args) throws IOException {
        //1.写一个文件地址
        File file = new File("E:\\hm\\cn_sql_server_2008_r2_enterprise_x86_x64_ia64_dvd_522233.iso");
        if (!file.exists()) {
            System.out.println("无法找到该文件");
            return;
        }
        int substring = file.getPath().lastIndexOf(".");
        //返回的是文件目录从0-.--
        String substring1 = file.getPath().substring(0, substring);
        File filedir = new File(substring1);
        filedir.mkdirs();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;

        byte[] buffer = new byte[1024 * 1024];
        int count = 0;// 统计读取了多少字节

        int nameIndex = 1;//文件名称

        int index = 0;//接受读取返回的值
        while ((index = fis.read(buffer))>=0) {
            if (count % 100 == 0) {//不为零就继续写入
            if(fos!=null){
                fos.close();
                fos=null;
            }
            if (fos == null) {
                File f = new File(filedir, nameIndex + ".par");
                fos = new FileOutputStream(f);
            }
            nameIndex++;//文件读取完毕时，文件名再次加一
        }
        fos.write(buffer, 0, index);
            count++;
    }
        fos.flush();
        fis.close();
        fos.close();

    }


}
