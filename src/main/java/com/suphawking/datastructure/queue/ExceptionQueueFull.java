package com.suphawking.datastructure.queue;

/**
 * Created by loveknut on 2016/12/18.
 */
public class ExceptionQueueFull extends RuntimeException {
  public ExceptionQueueFull(String err) {
    super(err);
  }
}
