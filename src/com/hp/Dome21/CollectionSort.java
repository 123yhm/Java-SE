package com.hp.Dome21;

import java.util.*;

/**
 * 借助Comparable接口，使Item具备按照价格从高到低排序。
 * 初始化10个Item,并且用Collections.sort进行排序，查看排序结果
 */
public class CollectionSort implements  Comparable<CollectionSort>{
    private int item;


    public CollectionSort(int item) {
        this.item = item;
    }
    @Override
    public String toString() {                      //重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append(item);

        return sb.toString();
    }


    @Override
    public int compareTo(CollectionSort o) {

            if (item<o.item){//排序小于原来的数则返回
                return 1;
            }else if (item>o.item){//大于不排序
                return -1;
        }
        return 0;
    }
}
class CollectionSortMain{
    public static void main(String[] args) {
        List<CollectionSort> list=new ArrayList<CollectionSort>();
        int price=60;
        sortPrice(list,price);
    }
    public static void  sortPrice(List<CollectionSort> list,int price){
        for (int i = 0; i <10 ; i++) {
            list.add(new CollectionSort(price+=12));
        }
        System.out.println("排序前的结果为：");
        int p=0;
        for(CollectionSort w : list){
            System.out.print(w+"\t");
        }
        // Arrays.sort(collectionSorts);
        System.out.println("\n"+"排序后的结果为：");
        Collections.sort(list);//利用接口调用比较方法
        for(CollectionSort w : list){
            p++;
            if(p==1){
                System.out.println("价格由高到低为：");
            }
            System.out.print(w+"\t");
        }
    }
}
