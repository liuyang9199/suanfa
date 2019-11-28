package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/27 下午5:34
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);



       /* ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        l21.next = l22;
        l22.next = l23;*/

        System.out.println(l11);
        l11 = l12;

        ListNode r = l11;
        System.out.println(l11);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode r = new ListNode(0);
        ListNode r1 = new ListNode(0);
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        r.next = r1;
        h1.next = l1;
        h2.next = l2;

        while (h1.next != null && h2.next != null) {
            r1.next = new ListNode(h1.next.val);
            r1 = r1.next;
            h1 = h1.next;
            r1.next = new ListNode(h2.next.val);
            r1 = r1.next;
            h2 = h2.next;
        }

        if (h1.next == null && h2.next != null) {
            r1.next = h2.next;
        } else {
            r1.next = h1.next;
        }

        return r.next.next;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
