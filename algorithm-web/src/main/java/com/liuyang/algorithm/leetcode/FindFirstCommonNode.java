package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 *
 [0,9,1,2,4]
 *
 [3,2,4]

 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        FindFirstCommonNode main = new FindFirstCommonNode();
        main.doAction();
    }

    public void doAction() {

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode x = new ListNode(3);
        x.next = d;

        ListNode result = getIntersectionNode(a, x);
        if (result == null) {
            System.out.println("不存在公共节点");
        } else {
            System.out.println(result.val);
        }


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode a1 = headA;
        ListNode x1 = headB;
        while (a1 != null || x1 != null) {
            if (a1 != null) {
                if (map.get(a1) != null) {
                    if (map.get(a1).equals(1)) {
                        a1 = null;
                    } else {
                        return a1;
                    }
                }
                map.put(a1, 1);
                a1 = a1.next;
            }

            if (x1 != null) {
                if (map.get(x1) != null) {
                    if (map.get(x1).equals(2)) {
                        x1 = null;
                    } else {
                        return x1;
                    }
                }
                map.put(x1, 2);
                x1 = x1.next;
            }
        }
        return null;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
