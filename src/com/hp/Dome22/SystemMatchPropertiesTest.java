package com.hp.Dome22;

import java.util.Arrays;

/**
 * 老七杂八的测试
 *
 * System/Math/Runtiom/properties
 */
public class SystemMatchPropertiesTest {

    public static void main(String[] args) {
    //System
        int [] arr= {1,2,3,4};
        System.out.println(Arrays.toString(arr));
        int [] arr2=new int[2];
        System.arraycopy(arr,0,arr2,0,2);
        System.out.println(Arrays.toString(arr2));//复制数组
        System.out.println(System.getProperties());//确定当前的系统属性。
    //Math


    }
}
