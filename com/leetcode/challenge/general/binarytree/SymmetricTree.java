package com.leetcode.challenge.general.binarytree;

/*
* https://leetcode.com/problems/symmetric-tree/
 101. Symmetric Tree
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Follow up: Solve it both recursively and iteratively.
*
* */
public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.left.left = new TreeNode(3);
        rootNode.left.right = new TreeNode(4);

        rootNode.right = new TreeNode(2);
        rootNode.right.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(3);

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(rootNode));

    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
