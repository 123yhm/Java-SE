package com.hp.test;

/**
 * 多線程枷鎖機制
 */
public class TicketsTwo implements Runnable {
    Object object = new Object();
    public Boolean flag = true;
    static int i = 100;

    @Override
    public void run() {
        if (flag) {
            while (i > 0) {

                synchronized (this) {
                    if (i > 0) {
                        try {
                            Thread.sleep(10);
                            System.out.println("還有" + i + "張票"+"线程一");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        i--;
                    }

                }

            }

        } else {
            while (i > 0) {
                sale();
            }
        }
        System.out.println("票已卖完");
    }
    synchronized static void sale () {
        if (i > 0) {
            try {
                Thread.sleep(10);
                System.out.println("還有" + i + "張票"+"线程二");
            } catch (Exception e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}
