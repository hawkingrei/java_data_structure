package com.suphawking.datastructure.vestor;

/**
 * Created by loveknut on 2016/12/21.
 */
public class VectorExtArray implements Vector {
  private int capacity = 8;//数组的容量，可不断增加
  private int size;//向量的实际规模
  private Object[] obj;//对象数组

  public VectorExtArray() {
    obj = new Object[capacity];
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
  public Object getAtRank(int rr)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    return obj[rr];
  }

  //将秩为r的元素替换为obj
  public Object replaceAtRank(int rr, Object obj)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    Object bak = this.obj[rr];
    this.obj[rr] = obj;
    return bak;
  }


  //插入obj，作为秩为r的元素；并返回该元素
  public Object insertAtRank(int rr, Object obj)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr > size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    if (capacity <= size) {
      //空间溢出的处理
      capacity *= 2;
      Object[] bb = new Object[capacity];//开辟一个容量加倍的数组
      for (int i = 0; i < size; i++) {
        bb[i] = this.obj[i];//A[]中内容复制至B[]
      }
      this.obj = bb;//用B替换A（原A[]将被自动回收）
    }
    for (int i = size; i > rr; i--) {
      this.obj[i] = this.obj[i - 1];//后续元素顺次后移
    }
    this.obj[rr] = obj;//插入
    size++;//更新当前规模
    return obj;
  }

  public Object removeAtRank(int rr)
      throws ExceptionBoundaryViolation {
    if (0 > rr || rr >= size) {
      throw new ExceptionBoundaryViolation("意外：秩越界");
    }
    Object bak = obj[rr];
    for (int i = rr; i < size - 1; i++) {
      obj[i] = obj[i + 1];//后续元素顺次前移
    }
    size--;//更新当前规模
    return bak;
  }


}
