package com.hp.Dome28;


import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 *  * 反射：
 *  * 			反射机制在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法
 *  * 			对于任意一个对象，都能够调用它的任意一个方法和属性
 *  * 			这种动态获取的信息以及动态调用对象方法的功能成为java语言的反射机制
 *  *
 *  * java反射机制功能：
 *  * 			1、在运行时判断任意一个对象所属的类
 *  * 			2、在运行时构造任意一个类的对象
 *  * 			3、在运行时判断任意一个类所具有的成员变量和方法
 *  * 			4、在运行时调用任意一个对象的方法
 *  * 			5、生成动态代理（不讲）
 *  *
 *  * 实现java反射的类：
 *  * 			Class：                        代表一个类        （java.lang）
 *  * 			Field：							代表类的成员变量（类的属性）     java.lang.reflect
 *  * 			method：					代表类的方法
 *  * 			Constructor：             代表类的构造方法
 */
public class ClassTest {
    public static void main(String[] args) {
        Person ps1=new Person("浩明",20);
        Person ps2=new Person("浩明2",22);
        System.out.println(ps1.getClass());//com.hp.Dome28.Person
        System.out.println(ps1.getClass()==ps2.getClass());
/**
 * 测试数组
 */
        int [] arrayA=new int[5];
        int [] arrayB={11,22,33};
        int [] [] arrayC=new int[2][3];
        int [] [] arrayD={{22},{33},{44}};
        System.out.println(arrayA.getClass());
        System.out.println(arrayB.getClass());
        //因为他们都是一个一维数组的东西
        System.out.println(arrayA.getClass()==arrayB.getClass());
        System.out.println(arrayD.getClass()==arrayC.getClass());
        /**
         * 其他类型
         */
        System.out.println("int的类型："+int.class);
        System.out.println("void的类型："+void.class);
    }

    /**
     *获取Class类和信息
     */
    @Test
    public  void testClass() throws ClassNotFoundException {
        Class<?> cl1=new Person().getClass();
        Class<?> cl2=Person.class;
        Class<?> cl3=Class.forName("com.hp.Dome28.Person");
        System.out.println("类地址"+cl1);//com.hp.Dome28.Person
        System.out.println("类地址"+cl2);
        System.out.println("类地址"+cl3);
        //获取当前类的父类
        Class<?> cl4=cl3.getSuperclass();
        System.out.println(cl4);//class java.lang.Object
        //基本数据类型的包装类
        Class<?> cl5=Long.TYPE;
        Class<?> cl6=Long.class;//得到完整的类名加报名
        System.out.println(cl5);//long
        System.out.println(cl6);//java.lang.Long
        System.out.println("类信息=========================================");
        Class<?> cla=Person.class;
        System.out.println("类的全名称："+cla.getName());
        System.out.println("类的名称："+cla.getSimpleName());
        System.out.println("类的权限："+Modifier.toString(cla.getModifiers()));

        System.out.println("父类信息================================");
        Class<?> classs=cla.getSuperclass();
        System.out.println("父类的类型："+classs.getSuperclass());
        System.out.println("父类的全类名："+classs.getName());
        System.out.println("父类的名称："+classs.getSimpleName());
    }
}
