package com.liuyang.algorithm.leetcode;

import java.util.Stack;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class ErChaShuAfterorderStack {

    public static void main(String[] args) {
        ErChaShuAfterorderStack main = new ErChaShuAfterorderStack();
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
        preOrder(treeNode1);
    }

    public void preOrder(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> afterstack = new Stack<>();


        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            afterstack.push(root);

            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);

            }
        }

        while (!afterstack.isEmpty()) {
            root = afterstack.pop();
            System.out.println(root.val);
        }

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
