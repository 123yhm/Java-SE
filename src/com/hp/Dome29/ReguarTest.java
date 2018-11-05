package com.hp.Dome29;

/**
 * 正则测试
 */
public class ReguarTest {
    public static void main(String[] args) {
        String mach="[1][^012479][0-9]{9}";
        String phone="15074803249";
        String mach2="\\A[曾]彪\\z";
        String phone2="曾彪";
        String str="430902199712277511";
        String mach3="";
        System.out.println(phone.matches(mach));
        System.out.println(phone2.matches(mach2));
    }
}
