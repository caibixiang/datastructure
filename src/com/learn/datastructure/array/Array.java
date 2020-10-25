package com.learn.datastructure.array;

/**
 * Description
 * resize 的复杂度分析
 * addLast(e) o(1)
 * 均摊时间复杂度和防止复杂度震荡
 *
 * @author caibixiang
 * @version v0.1 2020-09-23 21:08 caibixiang Exp $
 */
public class Array<T> {
    private T[] data;
    private int size;


    /**
     * 构造函数 传入数组的容量capacity 构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        this.data = (T[]) new Object[capacity];//new T[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数 默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    public Array(T[] arr) {
      data=(T[])new Object[arr.length];
      for(int i=0;i<arr.length;i++)
          data[i]=arr[i];
    }


    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 数组是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(T e) {
       /* if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full");

        data[size] = e;
        size++;*/
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    //向指定位置添加元素
    public void add(int index, T e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index not exist array or array is full");
        if (size == data.length)
            resize(2 * data.length);
        for (int length = size - 1; length >= index; length--)
            data[length + 1] = data[length];
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity= %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    //获取index索引位置元素
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Get is fail,index is illegal");
        return data[index];
    }

    public void set(int index, T e) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Set is fail,index is illegal");
        data[index] = e;
    }

    /**
     * 查找元素在数组中index,不存在返回 -1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }


    //判断元素是否在元素中
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    //删除最后一个元素
    public T removeLast() {
        return remove(size - 1);
    }


    //删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("del is fail,index is illegal");
        T ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return ret;
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }


    public void swap(int i, int j) {
        if (i >= size || i < 0 || j < 0 || j >= size)
            throw new IllegalArgumentException("index is illegal");
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
