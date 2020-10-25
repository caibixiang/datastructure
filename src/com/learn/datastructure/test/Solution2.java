package com.learn.datastructure.test;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 16:11 caibixiang Exp $
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }

        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);

    }


}
