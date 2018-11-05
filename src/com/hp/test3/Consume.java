package com.hp.test3;

/**
 * 消费类
 */
public class Consume implements Runnable{
    private  FontEntity fontEntity;

    public Consume(FontEntity fontEntity) {
        super();
        this.fontEntity=fontEntity;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           fontEntity.get();
        }

    }
}
