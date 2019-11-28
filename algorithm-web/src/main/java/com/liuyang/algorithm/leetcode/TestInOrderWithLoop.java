package com.liuyang.algorithm.leetcode;

import java.util.Stack;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/19 下午3:21
 */
public class TestInOrderWithLoop {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.left = listNode2;
        listNode1.right = listNode3;
        listNode2.left = listNode4;
        listNode2.right = listNode5;
        listNode3.left = listNode6;
        listNode3.right = listNode7;
        listNode4.right = listNode8;

        TestInOrderWithLoop testInOrderWithLoop = new TestInOrderWithLoop();
        testInOrderWithLoop.inorder(listNode1);
    }
    public void inorder(ListNode root) {

        Stack<ListNode> stack = new Stack<ListNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }

    }




    public static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        public ListNode(int v) {
            this.val = v;
        }
    }

}
