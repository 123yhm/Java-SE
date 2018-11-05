package com.hp.tz;

import org.junit.Test;

import java.util.Scanner;

/**
 * StringBuffer测试：线程安全性高、效率低
 * StringBuild:线程安全性低下、效率高
 */
public class StringBufferTest {

    public static void main(String[] args) {
//        StringBuffer str=new StringBuffer();
//        StringBuffer str1=new StringBuffer("你好");
//        //追加
//        str.append("浩明");
//        System.out.println(str);
//        str1.append(str);
//        System.out.println(str1);
//    //StringBuffer容器的增删查改
//        //增加
//        str.append("静静");
//        System.out.println("添加："+str.insert(0,"你好"));
//        //删除
//        System.out.println("删除："+str.delete(0,2));
//        //修改
//        str.setCharAt(0,'Y');
//        System.out.println("修改："+str);
//        str.replace(0,1,"早上好：");
//        System.out.println("替换包含开始不包含结尾："+str);
//        System.out.println("返回下标的内容："+str.charAt(1));
//        System.out.println("返回明的下标："+str.indexOf("明"));
//    //    System.out.println("反转："+str.reverse());
//        System.out.println("截取："+str.substring(4));
//        System.out.println("截取一段字符："+str.substring(0,3));
        System.out.println("请输入一段数字：");
        Scanner sca=new Scanner(System.in);
        int figure=sca.nextInt();
        StringBuilder strBul=new StringBuilder(String.valueOf(figure));
        int j=0;
        for (int i=strBul.length()-1;i>0;i--){
            j++;
            if(j%3==0){
                strBul.insert(i,",");
            }
        }
        System.out.println(strBul);


    }
    @Test
    public void TestStringBuffer(){

    }
}
