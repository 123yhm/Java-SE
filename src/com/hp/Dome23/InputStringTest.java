package com.hp.Dome23;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 键盘录入字母，最后打印其录入的字母及输入的次数
 * System
 */
public class InputStringTest {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String next = sca.next();
        //  InputStream inputStream=System.in;
        int i = 0;
        int x = 0;
        StringBuffer sb = new StringBuffer(next);
        for (int j = 0; j < sb.length(); j++) {
            x++;
            i++;
            int y = sb.length() - x;
            if (y != 0) {
                char charAt = sb.charAt(i - 1);
                System.out.println(charAt);
            } else {
                System.out.println("输出完毕");
                break;
            }
        }
        System.out.println(i + "次");

    }
}
