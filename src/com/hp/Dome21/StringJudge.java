package com.hp.Dome21;

import java.util.*;

/**
 * "asdffdsfggbzvcvasdfwerewfb"
 * 获取该字符串中，每一个字母出现的次数。
 * 要求打印结果是：a(1)b(2)f(5)...，使用map来实现
 */
public class StringJudge {
    public static void main(String[] args) {
        String str="asdffdsfggbzvcvasdfwerewfb";
        Map<Character,Integer> map=new TreeMap<Character,Integer>();//创建一个ThreeMap集合
        String string = StringJudge(str, map);
        System.out.println(string);
    }
    public  static String StringJudge(String str, Map<Character,Integer> map){
        char[] string = str.toCharArray();//把字符串变成字符数组
        for (Character cr:string) {//集合循环
            Integer value = map.get(cr);//判断字符的次数
            if(value==null){//如果字符自有一次
                map.put(cr,1);//次数就是1
            }else{//如果字符次数有几次相同的在原有基础上加入集合次数依次加一
                value++;
                map.put(cr,value);//装入集合
            }
        }
        Set<Character> characters = map.keySet();//得到健
        StringBuffer sb=new StringBuffer();
        for (Character value:characters) {//遍历字符、加入stringBuffer
            Integer key = map.get(value);
            sb.append(value).append("("+key+")");
        }
       return  sb.toString();//字符串输出
    }
}
