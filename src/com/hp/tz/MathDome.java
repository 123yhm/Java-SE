package com.hp.tz;
import static   java.lang.Math.*;//导入包省去类名
public class MathDome {
    public static void main(String[] args) {
        //绝对值
        System.out.println(abs(-10.2));
        System.out.println(abs(10.2));
        //返回最小的
        System.out.println(ceil(10.0));
        System.out.println(ceil(-10.0));
        //floor地板 返回的是比这个数小的第一个数
        System.out.println(floor(-10.1));
        System.out.println(floor(10.1));
        System.out.println(round(19.53));//四舍五入
        System.out.println(random());//随机数
        System.out.println(pow(2,3));//2的3次方
        System.out.println(sqrt(9));//开跟方法
        System.out.println(max(3,1));//输入最大的
        System.out.println(min(6,5));//输入最小值
    }
}
