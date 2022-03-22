package com.leetcode.challenge.march22;

import com.leetcode.challenge.march22.linkedlist.ListNode;

/*
 * Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * */
public class LinkedlistCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null || head.next == null) {
            return false;
        }

        while (fast != null  && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedlistCycle linkedlistCycle = new LinkedlistCycle();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(linkedlistCycle.hasCycle(listNode));
    }
}
