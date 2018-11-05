package com.hp.test;

public class TrimTest {
    public static void main(String[] args) {
        String string = "     asdfsaddfasd    asdfasdfas       ";
        String eat = TrimTest.eat(string);
        System.out.println(eat);
        short a = 128;
        byte b = (byte)a;
        System.out.println(a+""+b);
        short a1 = 1;
        short b2 = 2;
        System.out.println(a1+"  "+b2);
    }

    public static String eat(String str) {
        String str1 = str.trim();
        int c1 = 0;
        char  strings;
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c == ' ') {
                c1 = i;
            }else {
                //strings==i;
            }
        }

        return str1.substring(c1);
    }
}
