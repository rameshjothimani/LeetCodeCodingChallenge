package com.leetcode.challenge.general.binarytree;

/*
 https://leetcode.com/problems/maximum-depth-of-binary-tree/
 104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
* */
public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        return recursive(root, 0);
    }

    public int recursive(TreeNode root, int depth) {
        if (root == null) return depth;

        if (root.left == null) {
            depth = 1 + recursive(root.right, depth);
        } else if (root.right == null) {
            depth = 1 + recursive(root.left, depth);
        } else {
            depth = 1 + Math.max(recursive(root.left, depth), recursive(root.right, depth));
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);

        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);

        MaximumDepth maximumDepth = new MaximumDepth();
        System.out.println("Maximum Depth : " + maximumDepth.maxDepth(rootNode));
    }
}
