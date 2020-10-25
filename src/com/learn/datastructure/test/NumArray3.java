package com.learn.datastructure.test;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-15 23:17 caibixiang Exp $
 */
public class NumArray3 {
    private int[] sum;
    private int[] data;

    public NumArray3(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < data.length; i++)
            data[i] = nums[i];

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + data[i];

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


}
