package com.learn.datastructure.segemenTtree;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-11 17:04 caibixiang Exp $
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);
        segTree.query(0, 2);
        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(0, 5));
    }

}
