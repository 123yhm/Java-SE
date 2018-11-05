package com.hp.IntegerDome;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.Arrays;

/**
 * 数组排序
 */
public class IntegerTest {
    public static void main(String[] args) {
        String str="20 96 -7 29 36";
        String[] split = str.split(" ");
        Integer[] in= new Integer[split.length];
        for (int i=0;i<split.length;i++){
           // Arrays.sort(split[i]);
            in[i]= new Integer(split[i]);
        }
        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
    }
}
