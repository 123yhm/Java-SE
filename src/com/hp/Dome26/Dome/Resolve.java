package com.hp.Dome26.Dome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件分解储存
 */
public class Resolve {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\hm\\cn_sql_server_2008_r2_enterprise_x86_x64_ia64_dvd_522233.iso");
        splitTest(file);
    }
    public static void splitTest(File file)throws IOException{
        if (!file.exists()&&!file.isFile()) {
            System.out.println("无法找到此文件");
            return;
        }
        int i = file.getPath().lastIndexOf(".");
        String substring = file.getPath().substring(0, i);
        File newfile=new File(substring);
        newfile.mkdirs();


        FileInputStream fileInputStream=new FileInputStream(file);
        FileOutputStream fileOutputStream=null;
        byte[] bytet=new byte[1024*1024];
        int len=0;
        int num=0;
        int nameFile=1;
        while((len=fileInputStream.read(bytet))>=0){
            if(num%100==0){
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                    fileOutputStream=null;//要必须为空
                }
                if (fileOutputStream==null){
                    File filename=new File(newfile,nameFile+".par");
                    fileOutputStream=new FileOutputStream(filename);
                }
                nameFile++;
            }
            fileOutputStream.write(bytet,0,len);
            num++;
        }
        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
