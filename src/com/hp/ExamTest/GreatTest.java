package com.hp.ExamTest;

/**
 * 3.4）有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
 */
public class GreatTest {
    public static void main(String[] args) {
        int k=1;
        int l=2;
        float j=0;
        int r=0;
        for (int i=1;i<=20;i++){
            System.out.println(l+"/"+k);
            r=l;
            j+=(float) l/k;
            l=k+l;
            k=r;
        }
        System.out.println("前20项分数之和为："+j);
    }

}
