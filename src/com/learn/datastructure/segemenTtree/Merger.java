package com.learn.datastructure.segemenTtree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-09 23:54 caibixiang Exp $
 */
public interface Merger<E> {
    E merge(E a, E b);
}
