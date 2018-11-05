package com.hp.test2;

public class MyRunnable implements  Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println("当前偶数有 ："+i);
            }

        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable =new MyRunnable();
        Thread thread =new Thread(myRunnable);
        thread.start();
    }
}
