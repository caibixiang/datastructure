package com.learn.datastructure.test.segmenttree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-19 22:09 caibixiang Exp $
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums={-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree=new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree);


    }


}
