package com.suphawking.datastructure.list;

/**
 * Created by loveknut on 2016/12/20.
 */
public class Node implements Position {
  private Object element;//数据对象
  private Node next;//指向后继节点

  /**************************** 构造函数 ****************************/

  public Node() {
    this(null, null);
  }

  //指向数据对象、后继节点的引用都置空
  public Node(Object ele, Node ne) {
    element = ele;
    next = ne;
  }
  //指定数据对象及后继节点

  /**************************** Position接口方法 ****************************/
  //返回存放于该位置的元素
  public Object getElem() {
    return element;
  }

  //将给定元素存放至该位置，返回此前存放的元素
  public Object setElem(Object ele) {
    Object oldElem = element;
    element = ele;
    return oldElem;
  }

  /**************************** 单链表节点方法 ****************************/
//取当前节点的后继节点
  public Node getNext() {
    return next;
  }

  //修改当前节点的后继节点
  public void setNext(Node newNext) {
    next = newNext;
  }
}
