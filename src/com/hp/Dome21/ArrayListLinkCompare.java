package com.hp.Dome21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 在List的中间位置，插入数据，比较ArrayList快，还是LinkedList快，并解释为什么？
 * LinkedList快
 * 原因：
 * 1.add 操作以分摊的固定时间 运行，也就是说，添加 n 个元素需要 O(n) 时间。其他所有操作都以线性时间运行（大体上讲）。与用于 LinkedList 实现的常数因子相比，此实现的常数因子较低。
 * 2.ArrayList是一个动态的数组，linkedLlist是一个链表形式的数组
 * 3.对于查找和修改ArrayList（LinkedList）的速度明显要快(慢),因为它可以根据条件直接查找（需要一个个的排查）
 * 而增加和删除ArrayList，需要在有数据的基础上把数据往后移或（往前移动）才能插入（删除）完成
 * <p>
 * currentTimeMillis:时间戳
 */
public class ArrayListLinkCompare {
    public static void main(String[] args) {
//ArrayList
        List<String> list1;
        list1 = new ArrayList<>();
        list1.add("熊猫1");
        list1.add("熊猫2");
        list1.add("熊猫3");
        list1.add("熊猫4");
        list1.add("熊猫5");
        list1.add("熊猫6");
        list1.add("熊猫7");
        list1.add("熊猫8");
        insertArrayListFirst(list1, "ArrayList");//传入集合和代表
//linkedList
        List<String> list2;
        list2 = new LinkedList<>();
        list2.add("熊猫a");
        list2.add("熊猫b");
        list2.add("熊猫c");
        list2.add("熊猫d");
        list2.add("熊猫e");
        list2.add("熊猫f");
        list2.add("熊猫g");
        list2.add("熊猫h");
        insertLinkedFirst(list2, "LinkedList");


    }
    //传入对象与代表
    private static void insertArrayListFirst(List<String> list1, String type) {//ArrayList测试
        int total = 100000;
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < total; i++) {
            list1.add(5, "熊猫二");
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("在" + type + "中插入" + total + "条数据，花费时间" + (end - start) + "毫秒");
    }


    private static void insertLinkedFirst(List<String> list2, String type) {//LinkedList测试
        int total = 100000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            list2.add(5, "熊猫二");
        }
        long end = System.currentTimeMillis();
        System.out.println("在" + type + "中插入" + total + "条数据，花费时间" + (end - start) + "毫秒");
    }


}
