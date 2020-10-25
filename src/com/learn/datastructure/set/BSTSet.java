package com.learn.datastructure.set;

import com.learn.io.datastructure.tree.BST;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-07 17:54 caibixiang Exp $
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
