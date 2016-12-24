package com.suphawking.datastructure.iterator;

import com.suphawking.datastructure.list.List;
import com.suphawking.datastructure.list.Position;

/**
 * Created by loveknut on 2016/12/24.
 */
public class IteratorElement implements Iterator {
  private List list;//列表
  private Position nextPosition;//当前（下一个）元素的位置

  //默认构造方法
  public IteratorElement() {
    list = null;
  }

  //构造方法
  public IteratorElement(List ll) {
    list = ll;
    if (list.isEmpty()) {
      //若列表为空，则
      nextPosition = null;//当前元素置空
    } else {
      nextPosition = list.first();//从第一个元素开始
    }
  }

  public boolean hasNext() { return (nextPosition != null); }

  //返回迭代器中的下一位置
  public Object getNext() throws ExceptionNoSuchElement {
    if (!hasNext()) throw new ExceptionNoSuchElement("意外：没有下一位置");
    Position currentPosition = nextPosition;
    if (currentPosition == list.last())//若已到达尾位置，则
      nextPosition = null;//不再有下一个位置
    else {
      //否则
      nextPosition = list.getNext(currentPosition);//转向下一位置
    }
    return currentPosition;
  }
}
