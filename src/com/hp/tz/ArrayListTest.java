package com.hp.tz;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合练习
 *
 *  * 集合(Collection)：    java.util
 *  * 		集合可以看做是一个可变的容器
 *  * 			增：add() ,addAll() ,
 *  * 			删：clear() ,remove() ,removeAll() ,retainAll()
 *  * 			改：toArray()
 *  * 			查：	iterator() ,size()
 *  * 			判断：contains(),containsAll() ,isEmpty()
 *  *
 *  * 注意：
 *  * 			集合中所以的数据都是Object类型的
 *  *
 *  * @author Administrator
 *  *
 *
 */
public class ArrayListTest {


    public static void main(String[] args) {
//        //【1】创建对象
//        Collection c1 =new ArrayList();     //多态    父类new子类
//        Collection c2 = new ArrayList();
//
//        //【2】添加
//        c1.add("玉帝哥哥");  //add:添加单条数据
//        c1.add("phoebe");
//        c1.add("小菲比~");
//        c2.add("威廉~");
//        c2.add("老苹果");
//        c1.addAll(c2);    //把c2的数据添加到c1当中
//        c2.add("帅帅");
//        System.out.println(c1);
//        System.out.println(c2);
//
//        //【3】判断
//        System.out.println("集合是否为空:"+c1.isEmpty()+";长度："+c1.size());
//        System.out.println("一个集合当中是否包含指定元素："+c1.contains("半部春秋"));
//        System.out.println(c1.containsAll(c2));        //c1中包含c2中所有的元素则返回true
//
//        //【4】查询
//        System.out.println("[1]第一种遍历方式....");
//        for(Object obj:c1){
//            //String s = (String)obj;    //强制类型转换   向下转型
//            System.out.println(obj);
//        }
//        System.out.println("[2]第二种遍历方式....");
//        Iterator it = c1.iterator();   //调用方法，方法的结果是Iterator类型
//        while(it.hasNext()){       //判断下一个是否有元素
//            Object obj  =it.next();   //取出
//            System.out.println(obj);
//        }
//
//        //【5】修改
//        Object [] obj = c1.toArray();    //转为数组
//        for(int i = 0;i<obj.length;i++){
//            System.out.println(obj[i]);
//        }
//
//        //【6】删除
//        //c1.clear();	 //清空
//        //c1.remove("phoebe");  //根据对象删除   （Object）
//        //c1.removeAll(c2);          //从集合c1中删除与c2相同的元素
//        c1.retainAll(c2);				//从集合c1中删除与c2不同的元素
//        System.out.println(c1);
//        System.out.println(c2);

        Collection coll=new ArrayList();
        coll.add("我的歌啊");
        coll.add("你的天啊");
        coll.add("来归带");
        coll.add("今天好天气");
        Iterator iterator=coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);

        }
        Object[] objects = coll.toArray();
        for (int i = 0; i <objects.length ; i++) {
            System.out.println(objects[i]);

        }

    }

}
