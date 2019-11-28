package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/2 下午10:34
 */
public class TreeToDListNode {

    public static void main(String[] args) {
        TreeToDListNode treeToDListNode= new TreeToDListNode();
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode head = treeToDListNode.convert(treeNode1);
        System.out.println(head);

    }


    public TreeNode convert(TreeNode root) {
        if (root == null || (root .left == null && root.right == null)) return root;

        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);


        TreeNode head = list.get(0);
        TreeNode node = head;

        for (int i = 0 ; i < list.size() -1 ; i++) {
            TreeNode next = list.get(i+1);
            node.right = next;
            next.left = node;
            node = next;
        }
        return head;

    }

    public void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        preOrder(node.left, list);
        list.add(node);
        preOrder(node.right, list);
    }


    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
