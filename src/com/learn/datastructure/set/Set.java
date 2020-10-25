package com.learn.datastructure.set;

/**
 * 有序集合中的元素具有顺序性  <- 基于搜索树的实现
 * 无序集合中的元素没有顺序性 <- 基于哈希表的实现
 *
 *
 * 多重集合
 * @author caibixiang
 * @version v0.1 2020-10-07 17:53 caibixiang Exp $
 */
public interface Set<E> {
   void add(E e);
   void remove(E e);
   boolean contains(E e);
   int getSize();
   boolean isEmpty();


}
