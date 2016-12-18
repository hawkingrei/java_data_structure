package com.suphawking.datastructure.queue;

/**
 * Created by loveknut on 2016/12/18.
 */
public class QueueArray implements Queue {
  public static final int CAPACITY = 1000;//数组的默认容量
  protected int capacity;//数组的实际容量
  protected Object[] qq;//对象数组
  protected int first = 0;//队首元素的位置
  protected int last = 0;//队尾元素的位置

  //构造方法（空队列）
  public QueueArray() {
    this(CAPACITY);
  }

  //按指定容量创建对象
  public QueueArray(int cap) {
    capacity = cap;
    qq = new Object[capacity];
  }

  //查询当前队列的规模
  public int getSize() {
    return (capacity - first + last) % capacity;
  }

  //判断队列是否为空
  public boolean isEmpty() {
    return (first == last);
  }

  //入队
  public void enqueue(Object obj) throws ExceptionQueueFull {
    if (getSize() == capacity - 1) {
      throw new ExceptionQueueFull("Queue overflow.");
    }
    qq[last] = obj;
    last = (last + 1) % capacity;
  }

  //出队
  public Object dequeue() {
    Object elem;
    if (isEmpty()) {
      throw new ExceptionQueueEmpty("意外：队列空");
    }
    elem = qq[first];
    qq[first] = null;
    first = (first + 1) % capacity;
    return elem;
  }

  //取（并不删除）队首元素
  public Object front() throws ExceptionQueueEmpty {
    if (isEmpty()) {
      throw new ExceptionQueueEmpty("意外：队列空");
    }
    return qq[first];
  }

  //遍历（不属于ADT）
  public void traversal() {
    for (int i = first; i < last; i++) {
      System.out.print(qq[i] + " ");
    }
    System.out.println();
  }
}
