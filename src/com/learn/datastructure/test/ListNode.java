package com.learn.datastructure.test;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 15:23 caibixiang Exp $
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append((cur.val + "->"));
            cur = cur.next;
        }
        return res.toString();
    }
}
