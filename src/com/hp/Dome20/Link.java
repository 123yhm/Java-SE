package com.hp.Dome20;

public class Link {
    private Node root;//根节点

    public void add(String date) {//添加数据
        Node node = new Node(date);//数据赋给当前创建的对象
        if (this.root == null) {
            this.root = node;//开始赋值
        } else {
            this.root.addNode(node);
        }
    }

    public void print() {
        if (this.root != null) {//不为空打印开始
            this.root.printNode();//调用打印方法
        }
    }

}
