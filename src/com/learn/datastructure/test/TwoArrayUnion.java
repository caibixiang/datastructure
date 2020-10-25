package com.learn.datastructure.test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-08 09:14 caibixiang Exp $
 */
public class TwoArrayUnion {

    public int[] intersection(int[] num1, int[] num2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : num1)
            set.add(num);
        List<Integer> list = new ArrayList<>();
        for (int num : num2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

}
