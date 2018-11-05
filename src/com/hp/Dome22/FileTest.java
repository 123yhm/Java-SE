package com.hp.Dome22;

import java.io.*;
import java.util.Scanner;

/**
 * 创建文件并且写入文件

 * /:认为是"/"的作用等同于"\\"
 * 最好用“/”，因为java是跨平台的
 */
class CreateFileTest {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Boolean flag=false;
        File file=new File("E:/Java1823班.txt");
        try {
            if (!file.exists()) {//测试此抽象路径名表示的文件或目录是否存在。
                file.createNewFile();
                flag=true;
                System.out.println("文件创建成功"+file.getAbsoluteFile());
                //写入内容
                writerContent(file,input);
            }else{//如果存在此文件就直接写入内容
                writerContent(file,input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void writerContent(File file, Scanner input){//写入内容的方法


        try {
            //FileWriter用来写入字符文件的便捷类。
            /**
             * FileWriter(String fileName, boolean append)
             *           根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
             */
            FileWriter fileWriter=new FileWriter(file,true);//为true时在原文上追加内容，false是替换内容
            //将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            System.out.println("请输入内容开始写入文本：");
            String string= input.next();
            bufferedWriter.write(string);//写入文本
            bufferedWriter.flush();//  刷新该流的缓冲。
            System.out.println("内容写入完毕");
            copeFileContent(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  void copeFileContent(File file) throws FileNotFoundException {//复制文本内容到另外一个文件中去
        File file1=new File("F:/hm.txt");//复制进来内容的文件
        FileInputStream fileInputStream=new FileInputStream(file);//需要读取的文件
        FileOutputStream fileOutputStream=new FileOutputStream(file1);//需要输出的文件
        int ch;//该变量用来判断读取的状态
        try {
          if (file.length()!=0) {//判断：被复制文本内容为空时弹出提示
              if (!file1.exists()) {//测试此抽象路径名表示的文件或目录是否存在。
                  file1.createNewFile();
                  System.out.println("备份文件创建成功" + file.getAbsoluteFile());
                  while ((ch = fileInputStream.read()) != -1) {
                      fileOutputStream.write(ch);
                  }
                  fileOutputStream.flush();
              } else {//如果存在此文件就直接写入内容
                  while ((ch = fileInputStream.read()) != -1) {
                      fileOutputStream.write(ch);
                  }
              }
              System.out.println("复制内容完毕");
              fileOutputStream.flush();

          }else{
              System.out.println("内容为空，复制失败----请检查"+file.getAbsoluteFile());
          }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        if(fileInputStream!=null){
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream!=null){
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    }
}
