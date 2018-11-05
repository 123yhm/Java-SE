package com.hp.CollectionDome;


import java.util.ArrayList;
import java.util.Collection;

/**
 * 根类练习
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("eee");
        Collection collection2=new ArrayList();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("eee");
        collection2.addAll(collection);
        System.out.println("第一个集合："+collection);
        System.out.println("两者集合："+collection2);
       // collection.clear();
       // System.out.println("清除所有："+collection);
        boolean collBol = collection.contains("aaa");
        System.out.println(collBol);

    }
}
