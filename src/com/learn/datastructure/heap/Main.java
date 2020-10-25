package com.learn.datastructure.heap;

import java.util.Random;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-08 13:22 caibixiang Exp $
 */
public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }
        int[] arr = new int[testData.length];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }
        System.out.println("test completed");
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = new Integer[n];

        Random random = new Random();
        for (int i = 0; i < n; i++)
            arr[i]= random.nextInt(Integer.MAX_VALUE);
        double time1=testHeap(arr,false);
        System.out.println("without heapify:"+time1);
        double time2=testHeap(arr,true);
        System.out.println("heapify:"+time2);


    }
}
