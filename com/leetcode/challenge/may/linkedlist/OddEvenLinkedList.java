package com.leetcode.challenge.may.linkedlist;

/*
*
* Day 16 - Odd Even Linked List
*
* Given a singly linked list, group all odd nodes together followed by the even nodes.
* Please note here we are talking about the node number and not the value in the nodes.
* You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
*
* Example :
* Input: 1->2->3->4->5->NULL
* Output: 1->3->5->2->4->NULL
*
* Input: 2->1->3->5->6->4->7->NULL
* Output: 2->3->6->7->1->5->4->NULL
*
* Note:
* The relative order inside both the even and odd groups should remain as it was in the input.
* The first node is considered odd, the second node even and so on ...
*
* */


public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode oddElement = head;
        ListNode evenElement = head.next;
        ListNode evenHead = head.next;

        while (evenElement != null && evenElement.next != null) {
            //Collect Odd elements
            oddElement.next = oddElement.next.next;

            //Collect even elements
            evenElement.next = evenElement.next.next;

            oddElement = oddElement.next;
            evenElement = evenElement.next;
        }
        //Merge the Odd & even list
        oddElement.next = evenHead;

        return head;
    }

    public static void main(String args[]) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode nextNode = new ListNode(1);
        nextNode.next = new ListNode(2);
        nextNode.next.next = new ListNode(3);
        nextNode.next.next.next = new ListNode(4);
        nextNode.next.next.next.next = new ListNode(5);
        nextNode.next.next.next.next.next = new ListNode(6);

        ListNode arrangedList = oddEvenLinkedList.oddEvenList(nextNode);

        while (arrangedList != null && arrangedList.val != 0) {
            System.out.println(arrangedList.val);
            arrangedList = arrangedList.next;

        }

    }
}


