package com.learn.datastructure.stack;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-09-28 21:33 caibixiang Exp $
 */
public class Main {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack=new LinkedListStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
