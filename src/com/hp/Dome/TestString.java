package com.hp.Dome;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * --@Name:浩明
 * String 字符串练习
 */
public class TestString {
    public static void main(String[] args) {

    }

    /**
     * (1) 统计该字符串中字母s出现的次数
     */
    @Test
    public void StringTest() {
        // 定义一个字符串
        String s = "A smile is a curve that sets everything straight";

        // 出现次数
        int num = 0;
        // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
        for (int i = 0; i < s.length(); i++) {
            // 获取每个字符，判断是否是字符a
            if (s.charAt(i) == 's') {
                // 累加统计次数
                num++;
            }
        }
        System.out.println("字符s出现的次数：" + num);
    }

    /**
     * (2) 取出子字符串”test”
     */
    @Test
    public void TestTonString() {
        String s = "A smile is a curve that sets everything straight";
        String a = s.substring(19, 20);
        String b = s.substring(29, 30);
        String c = s.substring(40, 41);
        String d = s.substring(47, 48);
        String string = a + b + c + d;

        System.out.println("取出字符串" + string);
    }

    /**
     * (3) 将本字符串复制到一个字符数组Char[] str中.
     */
    @Test
    public void TestArrayString() {
        String s = "A smile is a curve that sets everything straight";
        String[] c = s.split(" ");
        char[] str = s.toCharArray();

        System.out.print("数组为:");
        System.out.println(str);
    }

    /**
     * (4) 将字符串中每个单词的第一个字母变成大写， 输出到控制台。
     */
    @Test
    public void TestUpperString() {
        String s = "A smile is a curve that sets everything straight";
        String[] c = s.split(" ");
        for (int i = 0; i < c.length; i++) {
            String s2 = c[i].substring(0, 1).toUpperCase() + c[i].substring(1);
            System.out.print(s2 + " ");
        }
    }

    /**
     * 5) 用两种方式实现该字符串的倒叙输出。(用StringBuffer和for循环方式分别实现)
     */
    @Test
    public void TestFlashbackString(){
        String s = "A smile is a curve that sets everything straight";
        StringBuffer stringBuffer=new StringBuffer(s);
        System.out.println(stringBuffer.reverse());//倒转方法
        //for
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
    }
    /**
     * (6) 将本字符串转换成一个字符串数组，要求每个数组元素都是一个有意义的额英文单词,并输出到控制台
     */
    @Test
    public void TestArraysString(){
        String s = "A smile is a curve that sets everything straight";
        String[] strs3=s.split(" ");
        System.out.println(Arrays.toString(strs3));
    }
}
