package com.suphawking.datastructure.vestor;

/**
 * Created by loveknut on 2016/12/21.
 */
public class VectorArray implements Vector {

  private final int capacity = 1024;//数组的容量
  private int size = 0;//向量的实际规模
  private Object[] objecta;//对象数组

  //构造函数
  public VectorArray() {
    objecta = new Object[capacity];
    size = 0;
  }

  //返回向量中元素数目
  public int getSize() {
    return size;
  }

  //判断向量是否为空
  public boolean isEmpty() {
    return (0 == size) ? true : false;
  }

  //取秩为r的元素
  public Object getAtRank(int rr) throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    return objecta[rr];
  }

  public Object replaceAtRank(int rr, Object obj)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    Object bak = objecta[rr];
    objecta[rr] = obj;
    return bak;
  }

  //删除秩为r的元素
  public Object removeAtRank(int rr) throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    Object bak = objecta[rr];
    for (int i = rr; i < size; i++) {
      objecta[i] = objecta[i + 1];//后续元素顺次前移
    }
    size--;//更新当前规模
    return bak;
  }

  //插入obj，作为秩为r的元素；返回该元素
  public Object insertAtRank(int rr, Object obj)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr > size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    if (size >= capacity) {
      throw new ExceptionBoundaryViolation("意外：数组溢出");
    }
    for (int i = size; i > rr; i--) {
      objecta[i] = objecta[i - 1];//后续元素顺次后移
    }
    objecta[rr] = obj;//插入
    size++;//更新当前规模
    return obj;
  }
}
