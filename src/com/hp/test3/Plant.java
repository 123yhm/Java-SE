package com.hp.test3;

/**
 * 工厂类
 * Java中boolean和它的包装类的区别在哪里
 * 区别如下：
 *
 * 1.boolean是基础数据类型，而Boolean是一个类
 *
 * 2.boolean一般存在于桟空间中，而Boolean对象存在堆空间中
 *
 * 3.boolean有true和false俩种值，Boolean除了true和false外，还有null
 *
 * 4.Java5.0之前啊，不能把Boolean用于条件语句，需要转换为boolean以后才能使用
 */
public class Plant implements  Runnable{
    private  FontEntity fontEntity;
    private boolean flag=true;
    public Plant(FontEntity fontEntity) {
        super();
        this.fontEntity=fontEntity;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            if (flag){
                try {
                    fontEntity.set("卫龙","辣条" );
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=false;
            }else {
                try {
                    fontEntity.set("浩明","哇哈哈");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=true;
            }
        }
    }
}
