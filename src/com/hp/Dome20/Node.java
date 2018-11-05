package com.hp.Dome20;

/**
 * 单向链表、双向链表、循环链表
 * 递归
 *
 * java中有三种移位运算符
 * <p>
 * <<      :     左移运算符，num << 1,相当于num乘以2
 *
 * >>      :     右移运算符，num >> 1,相当于num除以2
 *
 * >>>    :     无符号右移，忽略符号位，空位都以0补齐
 * 例如自然数列用通项公式表示为：  ；
 * 用递推公式表示为：  ，初始条件为a1=1；
 * 用递归公式表示为：  ，初始条件，a1=1，a2=2；
 */

/*
=========================================================单向链表
 */
public class Node {
    private String date;//节点中的数据
    private Node next;//下个节点的引用

    public Node(String date) {//构造方法初始化数据
        this.date = date;
    }

    public void setNext(Node next) {//设置下个节点
        this.next = next;
    }

    public Node getNext() {//返回下一个节点
        return this.next;
    }

    public String getDate() {//获取节点数据
        return date;
    }

    public void addNode(Node node) {
        if (this.next == null) {//判断当前节点是否为空
            this.next = node;
        } else {
            this.next.addNode(node);
        }
    }

    public void printNode() {//打印节点的方法
        System.out.println(this.date);
        if(this.next!=null){//判断当前节点是否为空
            this.next.printNode();
        }
    }
}

class NodeMain {
    public static void main(String[] args) {
        //设置数据
        Link link = new Link();
        link.add("火车头");
        link.add("车厢一");
        link.add("车厢二");
        link.add("车厢三");
        link.add("车厢四");
link.print();


    }
}
