package com.hp.Dome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * --@Name:浩明
 * 切割字符串练习
 */
public class TestIncise {
    /**
     * 1、分割出每个人的信息，输出控制台
     */
    @Test
    public void InciseStringTest() {
        String string = "01#张三#20*02#李四#18*03#王五#22*04#赵六#20*05#田七#21";
        String[] splic = string.split("\\*");
        for (String str : splic) {
            System.out.println(str);
        }

    }

    /**
     * 2、创建Student类，属性：学号 姓名 年龄
     * 将拆分的字符串数据赋值到Student类
     * 3、如果存在名字叫张三的，将名字改为张兵
     */
    @Test
    public void AssignmentTest() {
        //List<Student> list = new ArrayList<>();
        Student stu = new Student();
        String string = "01#张三#20*02#李四#18*03#王五#22*04#赵六#20*05#田七#21";
        String[] splic = string.split("\\#|\\*");
        Student[] arr=new Student[splic.length/3];
        int count=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=new Student(Integer.parseInt(splic[count]),splic[count+1],Integer.parseInt(splic[count+2]));
            count+=3;
            System.out.println("编号：" +arr[i].getStuId()+"姓名：" +arr[i].getStuName()+"年龄："+arr[i].getStuAge());
        }
//        System.out.println("请输入学生姓名：");
//        Scanner sca=new Scanner(System.in);
//        String name=sca.next();
        System.out.println("一下是修改学生的最新信息：");
        for(int i=0;i<arr.length;i++){
            if("张三".equals(arr[i].getStuName())){
                arr[i].setStuName("张兵");
                System.out.print("编号：" +arr[i].getStuId()+"姓名：" +arr[i].getStuName()+"年龄："+arr[i].getStuAge());
            }
        }


    }

}
