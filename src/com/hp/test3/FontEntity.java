package com.hp.test3;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 实体类
 */
public class FontEntity {
    private String brand;//品牌
    private  String fondName;//食品名称
    private boolean flag;//商品交替生产开关



    public FontEntity() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFondName() {
        return fondName;
    }

    public void setFondName(String fondName) {
        this.fondName = fondName;
    }
    /**
     * 同步赋值的方法
     */
    public  synchronized void set(String brand,String fondName){
       if (flag){
           try {
               super.wait();//让生产线程等待
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        this.setFondName(fondName);
        this.setBrand(brand);
        flag=true;
        super.notify();//唤醒生产线程

    }
    public  synchronized void get(){
        if (!flag){
            try {
                super.wait();//让生产线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("该品牌为：---"+this.getBrand()+"\t"+"食品名称："+this.getFondName());
        flag=false;//改变状态
        super.notify();//唤醒消费线程
    }
}
