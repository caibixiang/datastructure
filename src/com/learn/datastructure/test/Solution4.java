package com.learn.datastructure.test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-08 22:12 caibixiang Exp $
 */
public class Solution4 {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq > o.freq)
                return 1;
            else if (this.freq < o.freq)
                return -1;
            else
                return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.poll();
                pq.offer(new Freq(key, map.get(key)));
            }

        }
        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll().e;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,3,3,4,4,4,4};
        for (int e : new Solution4().topKFrequent(nums, 3))
            System.out.println(e);
    }


}
