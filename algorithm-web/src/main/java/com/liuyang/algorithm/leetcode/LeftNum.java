package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class LeftNum {

    public static void main(String[] args) {
        LeftNum main = new LeftNum();
        main.doAction();
    }

    public void doAction() {
        int n = leftNum(5, 3);
        System.out.println(n);
    }

    public int leftNum(int size, int step) {
        if (size <= 0 || step <= 0) {
            throw new RuntimeException("");
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        for ( int i = 1; i < size; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;

        ListNode before = node;
        ListNode curr = head;
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < step-1; j++) {
                before = before.next;
                curr = curr.next;
            }
            before.next = curr.next;
            curr = curr.next;
        }

        return curr.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
