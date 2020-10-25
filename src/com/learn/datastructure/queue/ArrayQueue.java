package com.learn.datastructure.queue;

import com.learn.io.datastructure.array.Array;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-04 23:16 caibixiang Exp $
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
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
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>(10);
        for(int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue.toString());
            if(i%3==2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue.toString());
            }

        }
    }
}
