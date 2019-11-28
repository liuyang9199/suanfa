package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class MaxKTree {

    public static void main(String[] args) {
        MaxKTree main = new MaxKTree();
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
        int maxk = findMaxk(treeNode1, 2);
        System.out.println("结果是" + maxk);
    }


    int findMaxk(TreeNode treeNode, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        int count = 0;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.right;
            }
            treeNode = stack.pop();
            System.out.println(treeNode.val);
            count++;
            if (k == (count)) {
                return treeNode.val;
            }
            treeNode = treeNode.left;
        }
        return -1;

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
