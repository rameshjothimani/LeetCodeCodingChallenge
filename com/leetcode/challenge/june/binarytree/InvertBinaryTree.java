package com.leetcode.challenge.june.binarytree;

/*
 *
 * Day 1 - Invert Binary Tree
 *
 * Invert a binary tree.
 *
 * Example :
 *
 * Input :
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *
 *Output :
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * */


public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        System.out.println("Before Inverting (Pre-Order): ");
        invertBinaryTree.printPreorder(root);
        System.out.println("\nAfter Inverting (Pre-Order): ");
        invertBinaryTree.printPreorder(invertBinaryTree.invertTree(root));

    }

    void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
