package com.learn.datastructure.test.segmenttree;

import com.learn.io.datastructure.segemenTtree.Merge;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-19 21:51 caibixiang Exp $
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < data.length; i++)
            data[i] = arr[i];
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 在treeIndex的位置创建表区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }






    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index ");
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append('[');
        for(int i=0;i<tree.length;i++){
            if(tree[i]!=null)
                res.append(tree[i]);
            else
                res.append("null");
            if (i != tree.length - 1) {
                res.append("->");
            }
        }
        res.append(']');
        return res.toString();

    }
}
