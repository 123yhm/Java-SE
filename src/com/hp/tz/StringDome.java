package com.hp.tz;

import java.util.Scanner;

/**
 * String包装类测试
 */
public class StringDome {
    public static void main(String[] args) {
        String a = "feima";
        a = "KMD";
        //String 类型对象的创建
        String s1 = "abc";     //相当与一个char类型的数组
        String s2 = new String ("ABC");   //有参构造创建对象
        String s3 = new String ();     //String s3="";
        char [] c = new char[]{'a','b','c'};

        //方法
        //[1]length():长度
        System.out.println(s1.length());
        //[2]equals:  比较
        System.out.println(s1.equals(s2));
        //[3]equalsIgnoreCase:忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        //[4]toUpperCase：转大写
        System.out.println(s1.toUpperCase());
        //[5]toLowerCase:z转小写
        System.out.println(s2.toLowerCase());
        //[6]indexOf: 字符串查找
        String str1 = "yudigege";
        System.out.println(str1.indexOf("g"));     //第一次出现的位置
        System.out.println(str1.indexOf("w"));		//找到就返回索引，找不到返回-1
        System.out.println(str1.lastIndexOf("e"));// 最后一次出现的位置
        //[7]字符串截取
        System.out.println(str1.substring(5));    //从5开始，一直到字符的结束
        System.out.println(str1.substring(2, 5));  //包含开始，但不包含结束
        //[8]trim() :去掉字符串的前后空格  中间空格无作用
        String str2 = " man cun ";
        System.out.println(str2.length());
        str2=str2.trim();
        System.out.println(str2.length());
        //[9]split:字符中的分割
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一段歌词，以空格分隔：");
        String music = input.nextLine();   //输出整行，包括空格
        System.out.println();
        String [] m = music.split(" ");
        System.out.println("普通for：");
        for (int i = 0; i < m.length; i++) {     //这里的是length属性
            System.out.println(m[i]);
        }
        System.out.println("加强for");
        for(String ss:m){
            System.out.println(ss);
        }
        //[10]字符串的判断和替换
        String str3 = "kmd";
        System.out.println(str3.startsWith("k"));  //str3这个字符串是h开头的吗？
        System.out.println(str3.replace("k","z"));  //把str3中的k改成z
        System.out.println("StringDemo.java".endsWith(".java"));
        System.out.println(str3.contains("d"));  //str3中没有包含d的。
        //[11]format: 格式化字符串
        int numA = 20;
        int numB = 30;
        System.out.println(String.format("%d+%d=%d", numA,numB,numA+numB));  //整型
        System.out.println(String.format("%f+%f=%f", 23.1,22.1,23.1+22.1));					//浮点
        System.out.println(String.format("%s+%s=%s", "hello","world","helloworld"));	//字符串


        //String 类型的转换
        //基本数据转为String       ---》valueOf
        System.out.println(String.valueOf(122));
        System.out.println(String.valueOf(12.2));
        //String 转基本数据类型
        System.out.println(Integer.parseInt("123"));
        System.out.println(Double.parseDouble("12.3"));
        System.out.println(Float.parseFloat("12.34"));

        //compareTO
        System.out.println("Apple".compareTo("aple"));
        //第一个字符小，得负数。两个相等得0，第一个字符比第二个字符大得正数
    }

}
