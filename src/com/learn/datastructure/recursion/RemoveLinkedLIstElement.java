package com.learn.datastructure.recursion;

import com.learn.io.datastructure.test.ListNode;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 17:08 caibixiang Exp $
 */
public class RemoveLinkedLIstElement {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements(head.next, val);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new RemoveLinkedLIstElement()).removeElements(head, 6);
        System.out.println(res);
    }

}
