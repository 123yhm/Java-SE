package com.hp.Dome26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args)throws IOException {
        File file1=new File("F:\\01"+File.separator+"01.txt");
        File file2=new File("F:\\01"+File.separator+"012.txt");
        FileInputStream fr=new FileInputStream(file1);
        FileOutputStream fw=new FileOutputStream(file2);
        byte[] by=new byte[1024];
        int  len=0;
        while((len=fr.read(by))!=-1){
            System.out.print(len+"\t");
            fw.write(by,0,len);
            fw.flush();
        }
        fw.close();
        fr.close();
    }
}
