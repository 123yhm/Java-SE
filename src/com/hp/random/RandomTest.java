package com.hp.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生成50个 0-9999之间的随机数，要求不能有重复的
 *
 *              * contains(Object o)
 *              * 如果此列表中包含指定的元素，则返回 true。
 *
 */
public class RandomTest {
    public static void main(String[] args) {
        int number=9999;
        RandomTest(number);
    }
    public static void RandomTest(int number){
        Random random=new Random();
        List listarr=new ArrayList();
        for (int i = 0; i <50 ; i++) {
            Integer random1 = random.nextInt(number);
            while (listarr.contains(random1)){//容器中的值与随机出阿里的值进行比较：为true时，再次随机
                random1 = random.nextInt(number);
            }
            listarr.add(random1);//添加到容器
        }
        System.out.println("随机个数为"+listarr.size()+"个");
        for (Object obj: listarr) {//随机的结果
            System.out.println(obj);
        }
    }
}
