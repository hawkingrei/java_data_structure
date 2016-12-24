package com.suphawking.datastructure.iterator;

/**
 * Created by loveknut on 2016/12/24.
 */
public interface Iterator {
  boolean hasNext();//检查迭代器中是否还有剩余的元素

  Object getNext();//返回迭代器中的下一元素
}
