package com.hp.tz;

import sun.awt.im.SimpleInputMethodWindow;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间测试
 */
public class DateTest {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Calendar calendar=Calendar.getInstance();
       Date date= calendar.getTime();
        String strdate=  simpleDateFormat.format(date);
        System.out.println(strdate);
        //单独得到
        System.out.println(calendar.get(Calendar.YEAR)+"年");
        System.out.println(calendar.get(Calendar.MONTH)+"月");
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)+"日");
    }
}
