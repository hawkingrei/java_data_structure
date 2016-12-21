package com.suphawking.datastructure.vestor;

/**
 * Created by loveknut on 2016/12/21.
 */
public interface Vector {
  //返回向量中元素数目
  public int getSize();

  //判断向量是否为空
  public boolean isEmpty();

  //取秩为r的元素
  public Object getAtRank(int rr) throws ExceptionBoundaryViolation;

  //将秩为r的元素替换为obj
  public Object replaceAtRank(int rr, Object obj) throws ExceptionBoundaryViolation;

  //插入obj，作为秩为r的元素；返回该元素
  public Object insertAtRank(int rr, Object obj) throws ExceptionBoundaryViolation;

  //删除秩为r的元素
  public Object removeAtRank(int rr) throws ExceptionBoundaryViolation;
}
