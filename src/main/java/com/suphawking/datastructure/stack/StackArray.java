package com.suphawking.datastructure.stack;

/**
 * Created by loveknut on 2016/12/18.
 */
public class StackArray implements Stack {

  public static final int CAPACITY = 1024;//数组的默认容量
  protected int capacity;//数组的实际容量
  protected Object[] ss;//对象数组
  protected int top = -1;//栈顶元素的位置
  //按默认容量创建栈对象

  public StackArray() {
    this(CAPACITY);
  }
  //按指定容量创建栈对象

  public StackArray(int cap) {
    capacity = cap;
    ss = new Object[capacity];
  }
  //获取栈当前的规模

  public int getSize() {
    return (top + 1);
  }
  //测试栈是否为空

  public boolean isEmpty() {
    return (top < 0);
  }
  //入栈

  public void push(Object obj) throws ExceptionStackFull {
    if (getSize() == capacity) {
      throw new ExceptionStackFull("意外：栈溢出");
    }
    ss[++top] = obj;
  }

  //取栈顶元素
  public Object top() throws ExceptionStackEmpty {
    if (isEmpty()) {
      throw new ExceptionStackEmpty("意外：栈空");
    }
    return ss[top];
  }

  public Object pop() throws ExceptionStackEmpty {
    Object elem;
    if (isEmpty()) {
      throw new ExceptionStackEmpty("意外：栈空");
    }
    elem = ss[top];
    ss[top--] = null;
    return elem;
  }
}
