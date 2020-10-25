package com.learn.datastructure.set;

import com.learn.io.datastructure.avltree.AvlTree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-25 16:16 caibixiang Exp $
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AvlTree<E, Object> avl;


    private AVLSet() {
        avl = new AvlTree<>();
    }


    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
