package com.leetcode.challenge.general.binarytree;

/*
* https://leetcode.com/problems/minimum-depth-of-binary-tree/
* 111. Minimum Depth of Binary Tree
*
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
* */
public class MinimumDepth {

    public int minDepth(TreeNode root) {
        return recursive(root, 0);
    }

    public int recursive(TreeNode root, int depth) {
        if (root == null) return depth;

        if (root.left == null) {
            depth = 1 + recursive(root.right, depth);
        } else if (root.right == null) {
            depth = 1 + recursive(root.left, depth);
        } else {
            depth = 1 + Math.min(recursive(root.left, depth), recursive(root.right, depth));
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);

        MinimumDepth minimumDepth = new MinimumDepth();
        System.out.println("Minimum Depth : " + minimumDepth.minDepth(rootNode));
    }
}
