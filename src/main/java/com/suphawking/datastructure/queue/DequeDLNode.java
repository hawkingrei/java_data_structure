package com.suphawking.datastructure.queue;

import com.suphawking.datastructure.list.DLNode;

/**
 * Created by loveknut on 2016/12/20.
 */
public class DequeDLNode implements Deque {
  protected DLNode header;//指向头节点（哨兵）
  protected DLNode trailer;//指向尾节点（哨兵）
  protected int size;//队列中元素的数目

  public DequeDLNode() {
    header = new DLNode();
    trailer = new DLNode();
    header.setNext(trailer);
    trailer.setPrev(header);
    size = 0;
  }

  //返回队列中元素数目
  public int getSize() {
    return size;
  }


  //判断队列是否为空
  public boolean isEmpty() {
    return (0 == size) ? true : false;
  }

  //取首元素（但不删除）
  public Object first() throws ExceptionQueueEmpty {
    if (isEmpty()) {
      throw new ExceptionQueueEmpty("意外：双端队列为空");
    }

    return header.getNext().getElem();
  }

  //取末元素（但不删除）
  public Object last() throws ExceptionQueueEmpty {
    if (isEmpty()) {
      throw new ExceptionQueueEmpty("意外：双端队列为空");
    }
    return trailer.getPrev().getElem();
  }

  public void insertFirst(Object obj) {
    DLNode second = header.getNext();
    DLNode first = new DLNode(obj, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }

  public void insertLast(Object obj) {
    DLNode second = trailer.getPrev();
    DLNode first = new DLNode(obj, second, trailer);
    second.setNext(first);
    trailer.setPrev(first);
    size++;
  }

  //删除首节点
  public Object removeFirst() throws ExceptionQueueEmpty {
    if (isEmpty()) {
      throw new ExceptionQueueEmpty("意外：双端队列为空");
    }
    DLNode first = header.getNext();
    DLNode second = first.getNext();
    Object obj = first.getElem();
    header.setNext(second);
    second.setPrev(header);
    size--;
    return (obj);
  }


}
