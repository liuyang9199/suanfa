package com.liuyang.algorithm.leetcode;

import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/24 上午7:45
 */
public class LinkNodeQuickSort {

    public static void main(String[] args) {
        LinkNodeQuickSort linkNodeQuickSort = new LinkNodeQuickSort();

        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode sorted = linkNodeQuickSort.sortList(head);

        ListNode temp = sorted;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        sortListCore(pre, size);
        return pre.next;
    }


    private void sortListCore(ListNode pre, int size) {

        if (size <= 1) {
            return;
        }

        int newSize = 0;
        ListNode com = pre.next;// 第一个节点 用于比较
        ListNode set = pre;
        ListNode curr = com.next;
        ListNode before = com;

        for (int i = 0; i < size -1; i ++) {
            if (curr.val <= com.val) {
                ListNode next = curr.next;
                set.next = curr;
                curr.next = com;
                set = set.next;
                before.next = next;
                curr = next;
                newSize++;
            } else {
                before = before.next;
                curr = curr.next;
            }
        }
        sortListCore(pre, newSize);
        sortListCore(com, size - newSize - 1);
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
