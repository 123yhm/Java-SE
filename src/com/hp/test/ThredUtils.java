package com.hp.test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 單線程
 */
public class ThredUtils implements Runnable {
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSSS");
    @Override
    public void run() {
        Boolean b1 = true;
        while (b1) {
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            String format = simpleDateFormat.format(time);
            try {
                Thread.sleep(1000);
                System.out.println(format);
            } catch (Exception  e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ThredUtils thredUtils = new ThredUtils();
        thredUtils.run();
    }

}
