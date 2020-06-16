package com.leetcode.challenge.general.binarytree;

/*
* https://leetcode.com/problems/balanced-binary-tree/
* 110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*
* */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursive(root) != -1;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println("The Binary tree is Balanced: " + balancedBinaryTree.isBalanced(rootNode));

    }
}
