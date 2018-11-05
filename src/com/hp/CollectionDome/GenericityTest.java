package com.hp.CollectionDome;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 */
public class GenericityTest {


    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("str1");
        list.add("str1");
        list.add("str1");
        System.out.println(list);

        GenericityTest gen=new GenericityTest();
        peron per=new peron();
        per.pon("你好");
    }



}
class  peron<String>{

    public void pon(String args) {
        System.out.println("泛型类"+args);
    }

}
interface  perinterface<Integer>{
    public void getAdd(Integer in);
    public  void delete();
}
