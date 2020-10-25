package com.learn.datastructure.segemenTtree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-10 00:00 caibixiang Exp $
 */
public class Merge {

    public static void main(String[] args) {
        Integer[] nums = {-2, -0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
         System.out.println(segmentTree);

    }
}
