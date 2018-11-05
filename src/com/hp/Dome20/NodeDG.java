package com.hp.Dome20;

public class NodeDG {
    public static void main(String[] args) {
        Integer integer = NodeDG.recursionSum(9);
        System.out.println(integer);
    }



    public static Integer recursionSum(Integer n){
        if(n>0){
            System.out.println("n的返回"+n);
            return n+recursionSum(n-1);
        }else{
            return 0;
        }
    }
}
