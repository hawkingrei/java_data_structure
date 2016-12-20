package com.suphawking.datastructure.list;

/**
 * Created by loveknut on 2016/12/20.
 */
public class DLNode implements Position {
  private Object element;//数据对象
  private DLNode prev;//指向前驱节点
  private DLNode next;//指向后继节点

  /**************************** 构造函数 ****************************/
  public DLNode() {
    this(null, null, null);
  }

  public DLNode(Object ee, DLNode pp, DLNode nn) {
    element = ee;
    prev = pp;
    next = nn;
  }

  //注意三个参数的次序：数据对象、前驱节点、后继节点
  public Object getElem() {
    return element;
  }

  //将给定元素存放至该位置，返回此前存放的元素
  public Object setElem(Object ee) {
    Object oldElem = element;
    element = ee;
    return oldElem;
  }

  //找到后继位置
  public DLNode getNext() {
    return next;
  }

  //修改后继位置
  public void setNext(DLNode newNext) {
    next = newNext;
  }

  //找到前驱位置
  public DLNode getPrev() {
    return prev;
  }

  //修改前驱位置
  public void setPrev(DLNode newPrev) {
    prev = newPrev;
  }
}
