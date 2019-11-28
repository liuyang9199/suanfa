package com.liuyang.algorithm.leetcode;

import java.util.Stack;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class BalancedTree {

    public static void main(String[] args) {
        BalancedTree main = new BalancedTree();
        main.doAction();
    }

    public void doAction() {

        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        isBalanced(treeNode1);
        System.out.println("结果是" + bt);
    }

    public boolean isBalanced(TreeNode root) {
        isBalancedCore(root);
        return bt;
    }

    boolean bt = true;

    public int isBalancedCore(TreeNode node) {

        if (!bt) return 0;

        if (node == null) return 0;

        int left = isBalancedCore(node.left);
        int right = isBalancedCore(node.right);

        if (Math.abs(left - right) > 1) {
            bt = false;
        }

        return left > right ? left++ : right++;
    }


    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
