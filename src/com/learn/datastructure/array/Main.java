package com.learn.datastructure.array;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-09-23 21:45 caibixiang Exp $
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 100; i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(9);
        System.out.println(arr);

    }


}
