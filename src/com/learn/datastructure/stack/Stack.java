package com.learn.datastructure.stack;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-09-28 21:06 caibixiang Exp $
 */
public interface Stack<T> {
    int getSize();
    boolean isEmpty();
    T pop();
    T peek();
    void push(T e);
}
