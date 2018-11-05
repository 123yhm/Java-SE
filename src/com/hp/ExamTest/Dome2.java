package com.hp.ExamTest;

/**
 * 编写三个方法，分别得出一个数组的最大值，最小值，平均值
 */
public class Dome2 {


    public static void main(String[] args) {
        int [] ints={10,20,30};
        int max=ints[0];//最大值
        int min=ints[0];//最小值
        int sum=0;//总数
        int svg=0;//平均值
        for (int i=0;i<ints.length;i++){
                if (ints[i]>max){
                    max=ints[i];
                }
            if (ints[i]<min){
                min=ints[i];
            }
            sum+=ints[i];
            svg=sum/ints.length;

        }
        System.out.println("最大值："+max+"最小值："+min+"平均值："+svg);
    }
}
