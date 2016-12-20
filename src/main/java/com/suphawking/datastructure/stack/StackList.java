package com.suphawking.datastructure.stack;

import com.suphawking.datastructure.list.Node;

/**
 * Created by loveknut on 2016/12/20.
 */
public class StackList implements Stack {
  protected Node top;//指向栈顶元素
  protected int size;//栈中元素的数目

  //构造方法（空栈）
  public StackList() {
    top = null;
    size = 0;
  }
}
