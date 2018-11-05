package com.hp.test;

public class TicketsMain3 {
    public static void main(String[] args) {
        TicketsTwo ticketsTwo = new TicketsTwo();
        new Thread(ticketsTwo).start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ticketsTwo.flag = false;
        new Thread(ticketsTwo).start();
    }
}
