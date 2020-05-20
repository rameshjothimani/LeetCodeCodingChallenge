package com.leetcode.challenge.may.binarytree;

/*
*
* Day 20 - Kth Smallest Element in a BST
*
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
*
* Note:
*  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
*
* Examples:
*  Input: root = [3,1,4,null,2], k = 1
*   3
*  / \
* 1   4
*  \
*   2
*
* Output: 1
*
*
* Input: root = [5,3,6,2,4,null,null,1], k = 3
*       5
*      / \
*     3   6
*    / \
*   2   4
*  /
* 1
*
* Output: 3
*
* Follow up:
* What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*
* */
public class KthSmallestBST {

    int count = 0;
    int smallestElement = 0;

    public int kthSmallest(TreeNode root, int k) {
        //Use Inorder traversal of BST
        inOrderTraversal(root, k);
        return smallestElement;
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, k);
        count++;

        //Kth Smallest element
        if (count == k) {
            smallestElement = root.val;
            return;
        }

        inOrderTraversal(root.right, k);
    }

    public static void main(String args[]) {
        KthSmallestBST kthSmallestBST = new KthSmallestBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        int k = 3;
        int result = kthSmallestBST.kthSmallest(root, k);

        System.out.println("Kth smallest element for value " + k + ":   " + result);
    }
}
