package com.suphawking.datastructure.iterator;

import com.suphawking.datastructure.list.List;
import com.suphawking.datastructure.list.Position;
import com.suphawking.datastructure.queue.QueueList;
import com.suphawking.datastructure.tree.TreeLinkedList;

/**
 * Created by loveknut on 2016/12/25.
 */
public class IteratorTree implements Iterator {
  private List list;//列表
  private Position nextPosition;//当前（下一个）元素的位置

  //默认构造方法
  public IteratorTree() {
    list = null;
  }

  //前序遍历
  public void elementsPreorderIterator(TreeLinkedList T) {
    if (null == T) return;//递归基
    list.insertLast(T);//首先输出当前节点
    TreeLinkedList subtree = T.getFirstChild();//从当前节点的长子开始
    while (null != subtree) {
      //依次对当前节点的各个孩子
      this.elementsPreorderIterator(subtree);//做前序遍历
      subtree = subtree.getNextSibling();
    }
  }

  //后序遍历
  public void elementsPostorderIterator(TreeLinkedList T) {
    if (null == T) return;//递归基
    TreeLinkedList subtree = T.getFirstChild();//从当前节点的长子开始
    while (null != subtree) {
      //依次对当前节点的各个孩子
      this.elementsPostorderIterator(subtree);//做后序遍历
      subtree = subtree.getNextSibling();
    }
    list.insertLast(T);//当所有后代都访问过后，最后才访问当前节点
  }

  //层次遍历
  public void levelTraversalIterator(TreeLinkedList T) {
    if (null == T) return;
    QueueList Q = new QueueList();//空队
    Q.enqueue(T);//根节点入队
    while (!Q.isEmpty()) {
      //在队列重新变空之前
      TreeLinkedList tree = (TreeLinkedList) (Q.dequeue());//取出队列首节点
      list.insertLast(tree);//将新出队的节点接入迭代器中
      TreeLinkedList subtree = tree.getFirstChild();//从tree的第一个孩子起
      while (null != subtree) {
        //依次找出所有孩子，并
        Q.enqueue(subtree);//将其加至队列中
        subtree = subtree.getNextSibling();
      }
    }
  }

}
