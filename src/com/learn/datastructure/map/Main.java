package com.learn.datastructure.map;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-07 23:19 caibixiang Exp $
 */
public class Main {

    public static void main(String[] args) {
        Map<String,Integer> linkedListMap=new LinkedListMap<>();
        linkedListMap.add("1",12);
        linkedListMap.add("2",13);
        linkedListMap.add("3",14);
        linkedListMap.add("4",15);
        linkedListMap.add("1",12);
        linkedListMap.add("2",1999);
        linkedListMap.add("3",14);
        linkedListMap.add("4",15);
        linkedListMap.remove("1");
        System.out.println(linkedListMap.getSize());
        System.out.println(linkedListMap.get("2"));


        Map<String,Integer> avlMap=new AVLMap<>();
        avlMap.add("1",12);
        avlMap.add("2",13);
        avlMap.add("3",14);
        avlMap.add("4",15);
        avlMap.add("1",12);
        avlMap.add("2",1999);
        avlMap.add("3",14);
        avlMap.add("4",15);
        avlMap.remove("1");
        System.out.println(avlMap.getSize());
        System.out.println(avlMap.get("2"));

    }
}
