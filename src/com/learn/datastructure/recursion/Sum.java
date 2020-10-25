package com.learn.datastructure.recursion;

/**
 * Description
 *
 * 递归调用是有代价的：函数调用+系统栈空间
 * @author caibixiang
 * @version v0.1 2020-10-06 16:41 caibixiang Exp $
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n) 这个区间内所有数字队和
    private static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }


}
