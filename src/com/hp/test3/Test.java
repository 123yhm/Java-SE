package com.hp.test3;

/**
 * 测试类
 * 实现商品生产并由消费者拿走、其中必须让商品交替生产
 */
public class Test {

    public static void main(String[] args) {
        FontEntity fontEntity=new FontEntity();
        Consume consume=new Consume(fontEntity);
        Plant plant=new Plant(fontEntity);

        new Thread(consume).start();
        new Thread(plant).start();



    }
}
