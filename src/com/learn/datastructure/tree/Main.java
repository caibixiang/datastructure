package com.learn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 23:18 caibixiang Exp $
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
       /* int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);
        bst.levelOrder();
        System.out.println();*/
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));
        List<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMin test completed");

    }

}
