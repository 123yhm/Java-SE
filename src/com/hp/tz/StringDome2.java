package com.hp.tz;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class StringDome2 {
    public static void main(String[] args) {
        String [] arrayA ={"演冰","宁静","满村","玉帝","奋斗"};
        Arrays.sort(arrayA);
        System.out.println(Arrays.toString(arrayA));

        Arrays.sort(arrayA, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2) {
                Collator c =Collator.getInstance(Locale.CHINA);  //用于创建一个Collator对象
                CollationKey s1 = c.getCollationKey(o1);
                CollationKey s2 = c.getCollationKey(o2);
                return s1.compareTo(s2);  //升序
                //return s2.compareTo(s1);		//降序
            }
        } );
        System.out.println(Arrays.toString(arrayA));
    }


}
