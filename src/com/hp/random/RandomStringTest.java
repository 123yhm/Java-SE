package com.hp.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 创建一个长度是100的字符串数组
 * 使用长度是2 的随机字符填充该字符串数组
 * 统计这个字符串数组里重复的字符串有多少种
 * ascall:
 * a-z:97-122
 * A-Z:65-90
 */
public class RandomStringTest {
    public static void main(String[] args) {
        String str="0123456789qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP";
        arraysString(str);
    }



    //获取随机长度为2的字符串
    public static void  arraysString(String str){
        Random random=new Random();
        String[] string=new String[100];
        int StrSeed=0;
        List listarr=new ArrayList();//随机字符容器
        List listarrTow=new ArrayList();//相同的字符串容器

        for (int i=0;i<string.length;i++){
            char c = str.charAt(random.nextInt(str.length()));
            char charAt = str.charAt(random.nextInt(str.length()));
            String chars= c+""+charAt;
            listarr.add(chars);

        }

        //判断相等后计数开始
        for (int i = 0; i <string.length ; i++) {
            for (int j =i+1; j <string.length; j++) {
                    if (listarr.get(i).equals(listarr.get(j))){
                        StrSeed++;
                        listarrTow.add(listarr.get(i));
                    }
            }
        }
        System.out.println("一下的是随机的2位字符串：");
        for (Object arrlist0:listarr) {
            System.out.println(arrlist0);
        }
        System.out.println("================================================");
        System.out.println("重复的字符串有"+StrSeed+"多少种");
        System.out.println("重复的字符串为：");
        for (Object arrlist:listarrTow) {
            System.out.println(arrlist);
        }
    }
}
