package com.hp.test2;

public class MyThred extends  Thread{
    public  void run(){

        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println("当前偶数有 ："+i);
            }

        }

    }
    public static void main(String[] args) {
        MyThred myThred=new MyThred();
        Thread thread=new Thread(myThred);
        thread.start();

    }
}


