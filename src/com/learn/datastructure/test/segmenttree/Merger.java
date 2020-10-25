package com.learn.datastructure.test.segmenttree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-19 22:04 caibixiang Exp $
 */
public interface Merger<E> {
    E merge(E e, E o);

}
