package com.hp.Dome24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

将自己的个人信息，转成字节，存入到二进制文件中
 */
public class MyDateBin {
    private String name;
    private String sex;
    private int age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws IOException {
        Scanner sca=new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name=sca.next();
        System.out.println("请输入性别：");
        String sex=sca.next();
        System.out.println("请输入年龄：");
        Integer age=sca.nextInt();
        MyDateBin myDateBin=new MyDateBin();
        myDateBin.setName(name);
        myDateBin.setSex(sex);
        myDateBin.setAge(age);
//        FileOutputStream fos = new FileOutputStream(new File("D:\\file.bin"));//利用文件输出流把信息输出到新建的二进制文件中
//        String value = "阳浩明";
//        byte[] by=value.getBytes();
//        fos.write(by);
        RandomAccessFile raf = new RandomAccessFile("D:\\info.bin", "rw");
/**
 * 存入
 */


        String value = "我叫："+myDateBin.getName()+"--性别："+myDateBin.getSex()+"--今年："+myDateBin.getAge()+"岁。";
        byte[] bytes = value.getBytes();
        System.out.println(bytes.length);
        raf.write(bytes);
        raf.close();
/**
 * 输出
 */
//        byte[] buf = new byte[1024];
//        raf.read(buf);
//        String str = new String(buf, "GBK");
//        System.out.println(str);


//        raf.write('c');
//        raf.write('b');
//        raf.skipBytes(4);
//        raf.write('a');

//        raf.seek(6);
//        System.out.println("-->" + raf.getFilePointer());
//        int read = raf.read();
//        System.out.println((char) read);

//        raf.seek(1);
//        System.out.println("-->" + raf.getFilePointer());
//        int read1 = raf.read();
//        System.out.println((char)read1);


//        byte[] buf = new byte[10];
//        buf[4] = ??


//        System.out.println(raf.length());


//         createFile();


    }


    static void createFile() throws IOException {

        FileOutputStream fos = new FileOutputStream("D:\\info.bin");
        try {
            fos.write(new byte[10]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fos.close();
    }
}
