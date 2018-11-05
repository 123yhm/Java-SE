package com.hp.Dome26.Dome;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 合并文件
 */
public class MergeFile{
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\hm\\cn_sql_server_2008_r2_enterprise_x86_x64_ia64_dvd_522233");
        merge(file);
    }
    public static void merge( File file) throws IOException{
        if(!file.isDirectory()&&!file.exists()){
            System.out.println("目录不存在");
            return;
        }

        int filename=1;
        List<File> list=new ArrayList<>();
        while(true){
            String name=filename+".par";
            File file2=new File(file,name);
            if(file2.exists()){
                list.add(file2);
                filename++;
            }else{
                break;
            }
        }

        List listarr=new ArrayList();
        for (File f:list) {
            FileInputStream fileInputStream1=new FileInputStream(f);
            listarr.add(fileInputStream1);
        }
        //迭代
        Enumeration<InputStream> enumeration=Collections.enumeration(listarr);
        SequenceInputStream sequenceInputStream=new SequenceInputStream(enumeration);
        File filenew=new File(file,"hm.iso");
        FileOutputStream fileOutputStream=new FileOutputStream(filenew);
        byte[] bytes=new byte[1024*1024];
        int len=0;
        while ((len=sequenceInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.flush();
        sequenceInputStream.close();
        fileOutputStream.close();

    }
}
