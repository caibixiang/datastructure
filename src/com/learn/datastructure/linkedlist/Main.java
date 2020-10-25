package com.learn.datastructure.linkedlist;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 11:54 caibixiang Exp $
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeElement(3);
        System.out.println(linkedList);


    }
}
