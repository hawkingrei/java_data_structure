package com.suphawking.datastructure.tree;

import com.suphawking.datastructure.iterator.Iterator;

/**
 * Created by loveknut on 2016/12/26.
 */
public class BinTreeLinkedList implements BinTree {
  protected BinTreePosition root;//根节点

  /**************************** 构造函数 ****************************/
  public BinTreeLinkedList() {
    this(null);
  }

  public BinTreeLinkedList(BinTreePosition r) {
    root = r;
  }

  /**************************** BinaryTree接口方法 ****************************/
//返回树根
  public BinTreePosition getRoot() {
    return root;
  }

  //判断是否树空
  public boolean isEmpty() {
    return null == root;
  }

  //返回树的规模（即树根的后代数目）
  public int getSize() {
    return isEmpty() ? 0 : root.getSize();
  }

  //返回树（根）的高度
  public int getHeight() {
    return isEmpty() ? -1 : root.getHeight();
  }

  //前序遍历
  public Iterator elementsPreorder() {
    return root.elementsPreorder();
  }

  //中序遍历
  public Iterator elementsInorder() {
    return root.elementsInorder();
  }

  //后序遍历
  public Iterator elementsPostorder() {
    return root.elementsPostorder();
  }

  //层次遍历
  public Iterator elementsLevelorder() {
    return root.elementsLevelorder();
  }
}
