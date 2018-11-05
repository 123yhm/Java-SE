package com.hp.test;


public class Tickets implements Runnable{
    Object object=new Object();

    int i=100;
    @Override
    public void run() {

        while (i>0){

            synchronized (object) {
                if (i>0) {
                    try {
                        Thread.sleep(10);
                        System.out.println("還有"+i+"張票");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i--;
                }

            }

        }
    }

}
class  TicketsMain{
    public static void main(String[] args) {
        Tickets tickets=new Tickets();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }

}