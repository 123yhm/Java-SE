package com.hp.ExamTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.[p 3）编程统计101-200之间有多少个素数，并输出所有素数。
 *
 *
 */
public class PrimeTest {
    public static void main(String[] args) {
        for (int n = 2; n <= 100; n++) {
            boolean b = true;

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    b = false;
                    break;
                }

            }
            if (b) {
                System.out.println(n + "是质数");

            }

        }

}
}
