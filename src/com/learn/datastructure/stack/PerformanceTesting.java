package com.learn.datastructure.stack;

import java.util.Random;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 12:34 caibixiang Exp $
 */
public class PerformanceTesting {


    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("test ArrayStack spends "+time1+"s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2=testStack(linkedListStack,opCount);
        System.out.println("test LinkedListStack spends "+time2+"s");
        // 其实这个时间比较 很复杂，因为LinkedListStack 中包含更多的new操作

    }
}
