package com.suphawking.datastructure.iterator;

import com.suphawking.datastructure.list.List;
import com.suphawking.datastructure.list.Position;
import com.suphawking.datastructure.iterator.Iterator;
/**
 * Created by loveknut on 2016/12/24.
 */
public class IteratorPosition implements Iterator {
  private List list;//列表
  private Position nextPosition;//当前（下一个）位置

  //默认构造方法
  public IteratorPosition() {
    list = null;
  }

  public IteratorPosition(List ll) {
    list = ll;
    if (list.isEmpty())//若列表为空，则
      nextPosition = null;//当前位置置空
    else {
      nextPosition = list.first();//从第一个位置开始//否则
    }

  }

  //检查迭代器中是否还有剩余的位置
  public boolean hasNext() {
    return (nextPosition != null);
  }

  //返回迭代器中的下一位置
  public Object getNext() throws ExceptionNoSuchElement {
    if (!hasNext()) {
      throw new ExceptionNoSuchElement("意外：没有下一位置");
    }
    Position currentPosition = nextPosition;
    if (currentPosition == list.last())//若已到达尾位置，则
      nextPosition = null;//不再有下一个位置
    else {
      nextPosition = list.getNext(currentPosition);//转向下一位置
    }
    return currentPosition;
  }
}
