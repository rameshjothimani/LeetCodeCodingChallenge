package com.leetcode.challenge.may.binarytree;

/*
 *
 * Day 24 - Construct Binary Search Tree from Preorder Traversal
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example :
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Constraints:
 *  1 <= preorder.length <= 100
 *  1 <= preorder[i] <= 10^8
 *  The values of preorder are distinct.
 *
 * */
public class BSTFromPreOrder {

    int index;

    public TreeNode bstFromPreorder(int[] preorder) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return constructBST(preorder, minValue, maxValue);
    }

    TreeNode constructBST(int[] preOrder, int minValue, int maxValue) {
        if (index >= preOrder.length) {
            return null;
        }

        int key = preOrder[index];
        TreeNode node = null;
        if (key > minValue && key < maxValue) {
            node = new TreeNode(preOrder[index]);
            index++;

            node.left = constructBST(preOrder, minValue, key);
            node.right = constructBST(preOrder, key, maxValue);
        }

        return node;
    }


    public static void main(String args[]) {
        BSTFromPreOrder bstObj = new BSTFromPreOrder();
        int[] input = {8, 5, 1, 7, 10, 12};
        TreeNode resultTree = bstObj.bstFromPreorder(input);
        bstObj.printLevelOrder(resultTree);

    }

    private void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print("  " + treeNode.val);
        printTree(treeNode.left);
        printTree(treeNode.right);
    }

    void printLevelOrder(TreeNode root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }


    void printGivenLevel(TreeNode root, int level) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        if (level == 1) {
            System.out.print(root.val + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
