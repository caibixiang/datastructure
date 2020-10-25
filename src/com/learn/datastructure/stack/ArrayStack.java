package com.learn.datastructure.stack;

import com.learn.io.datastructure.array.Array;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-09-28 21:08 caibixiang Exp $
 */
public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    public ArrayStack(){
        array=new Array<>();
    }

    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T pop() {
        return  array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public void push(T e) {
       array.addLast(e);
    }

    public int getCapacity(){
       return array.getCapacity();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }





}
