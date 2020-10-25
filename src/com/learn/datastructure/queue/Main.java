package com.learn.datastructure.queue;

import java.util.Random;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-05 11:46 caibixiang Exp $
 */
public class Main {
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time :" + time1);
        LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue,time :" + time2);
        Queue<Integer> linkedLIstQueue = new LinkedLIstQueue<>();
        double time3 = testQueue(linkedLIstQueue, opCount);
        System.out.println("linkedLIstQueue,time :" + time3);
    }


}
