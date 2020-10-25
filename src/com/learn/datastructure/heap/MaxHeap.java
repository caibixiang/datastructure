package com.learn.datastructure.heap;

import com.learn.io.datastructure.array.Array;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-08 12:18 caibixiang Exp $
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中,一个索引表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中,一个索引表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中,一个索引表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素和 shift up
    public void add(E e) {
        data.addLast(e);
        //维护堆堆性质
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            int pIndex = parent(k);
            data.swap(k, pIndex);
            k = pIndex;
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }


    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                //data[j] 是leftChild和rightChild中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }
    //取出最大元素后，放入一个新元素
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //heapify 将任意数组整理成堆堆形状
    // 将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)
    // heapify的过程,算法复杂度为O(n)
   public MaxHeap(E[] arr){
        data=new Array<>(arr);
       for(int i=parent(arr.length-1);i>=0;i--){
           siftDown(i);
       }
   }


}
