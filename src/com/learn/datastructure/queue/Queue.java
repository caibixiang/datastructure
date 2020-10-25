package com.learn.datastructure.queue;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-04 23:13 caibixiang Exp $
 */
public interface Queue<E> {
     int getSize();
     boolean isEmpty();
     void enqueue(E e); //进队列
     E dequeue(); //出队列
     E getFront(); //获取前面

}
