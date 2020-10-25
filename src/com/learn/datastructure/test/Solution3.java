package com.learn.datastructure.test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-08 09:50 caibixiang Exp $
 */
public class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1)
            if (map1.get(num) == null)
                map1.put(num, 1);
            else
                map1.put(num, map1.get(num) + 1);


        List<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (map1.containsKey(num)) {
                list.add(num);
                map1.put(num, map1.get(num) - 1);
                if (map1.get(num) == 0)
                    map1.remove(num);
            }

        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] res = new Solution3().intersect(num1, num2);
        for (int num : res)
            System.out.println(num);
    }

}
