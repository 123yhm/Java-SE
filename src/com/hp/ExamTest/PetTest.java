package com.hp.ExamTest;

/**
 * 3.2）创建宠物类（属性：名字，体重；方法：奔跑，捕食）在DEMO类实例化宠物，设置名字，调用奔跑，捕食方法
 */
public class PetTest {
    PetTestEnyity petTestEnyity=new PetTestEnyity();
    public  void run(){
        petTestEnyity.setPetName("小羊");
        System.out.println(petTestEnyity.getPetName()+"在奔跑");
    }
    public  void eat(){
        petTestEnyity.setPetName("小狗");
        System.out.println(petTestEnyity.getPetName()+"在吃骨头");
    }

    public static void main(String[] args) {

        PetTest petTest=new PetTest();
        petTest.run();
        petTest.eat();

    }
}
