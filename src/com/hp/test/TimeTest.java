package com.hp.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest implements  Runnable {
    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSSS");//时间格式
    @Override
    public void run() {

       while (true){
           Calendar calendar=Calendar.getInstance();//创建对象
           Date date=calendar.getTime();//得到时间
           String string= simpleDateFormat.format(date);//利用simpleDateFormat把系统时间格式化
           try {
               Thread.sleep(100);//睡眠

               System.out.println(string);//输出时间
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
    }

    public static void main(String[] args) {
        TimeTest timeTest=new TimeTest();
        Thread thread=new Thread(timeTest);
        thread.start();
    }
}
