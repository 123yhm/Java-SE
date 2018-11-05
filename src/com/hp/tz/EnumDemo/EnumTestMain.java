package com.hp.tz.EnumDemo;

public class EnumTestMain {




    public static void main(String[] args) {
        EnumTestMain.enume(enumeTest.u1);
    }
    public static   EnumeTest enumeTest;
    public static void enume(EnumeTest enumeTest){
        switch (enumeTest){
            case  u1:
                System.out.println("JAVA初级班");
                break;
            case u2:
                System.out.println("JAVA中级班");
                break;
            case u3:
                System.out.println("JAVA高级班");
                break;
            default:
                System.out.println("没有你想要的内容");
        }
    }
}
