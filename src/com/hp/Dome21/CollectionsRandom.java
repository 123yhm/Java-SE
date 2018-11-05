package com.hp.Dome21;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 初始化一个List,长度是7，值是ABCDEFG。
 * 然后不断的shuffle，直到前3位出现 A B C
 * shuffle 100000 次，统计出现的概率
 */
public class CollectionsRandom {
    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public CollectionsRandom(List<Integer> list) {//初始化list
        super();
        this.list = list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();//定义一个长度为7的集合装入容器中
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        List<String> list2 = new ArrayList<String>();//定义一个长度为7的集合装入容器中
        list2.add("A");
        list2.add("B");
        list2.add("C");
        System.out.println(list2);

        int sum = 100000;
        int index = 0;
        for (int i = 0; i < sum; i++) {//利用for循环截取比较内容
            Collections.shuffle(list);
           // System.out.println(list.subList(0, 5));
            if (list.subList(0, 3).equals(list2)) {
                index++;//计数
            }
        }
       // System.out.println(index);
        if(index==0){
            System.out.println("计数为零，无法计算值");
        }else{
            System.out.println("概率为"+sum/index);
        }


    }
}