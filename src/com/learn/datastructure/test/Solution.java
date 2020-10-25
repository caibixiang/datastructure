package com.learn.datastructure.test;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 15:24 caibixiang Exp $
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev=prev.next;

        }
        return head;
    }


}
