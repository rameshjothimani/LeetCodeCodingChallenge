package com.leetcode.challenge.general.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
* 109. Convert Sorted List to Binary Search Tree
*
* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*
* */

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ArrayList<Integer> inputList = new ArrayList<>();
        while (head != null) {
            inputList.add(head.val);
            head = head.next;
        }
        return constructBSTRecursive(inputList, 0, inputList.size() - 1);

    }

    private TreeNode constructBSTRecursive(List nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) / 2;

        TreeNode rootNode = new TreeNode((Integer) nums.get(mid));
        rootNode.left = constructBSTRecursive(nums, left, mid - 1);
        rootNode.right = constructBSTRecursive(nums, mid + 1, right);

        return rootNode;
    }

}
