package com.hp.Dome28;

import com.hp.tz.EnumDemo.Person;

import java.lang.reflect.Constructor;

/**
 * 测试类的构造函数
 */
public class PersonTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> lca=Class.forName("com.hp.Dome28.Person");
        Constructor<?>[] con=lca.getConstructors();
        for (Constructor c:con){
            System.out.println("共有的构造方法有："+c);
        }

    }
}
