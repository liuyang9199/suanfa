package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/29 上午9:03
 */
public class ListNodeOpe {

    public ListNodeOpe head;

    public ListNodeOpe tail;

    public ListNodeOpe next;

    public int val;

    public static void main(String[] args) {



        ListNodeOpe listNodeOpe = new ListNodeOpe(1);

        ListNodeOpe listNodeOpe2 = new ListNodeOpe(2);
        ListNodeOpe listNodeOpe3 = new ListNodeOpe(3);
        ListNodeOpe listNodeOpe4 = new ListNodeOpe(4);

        listNodeOpe.next =listNodeOpe2;
        listNodeOpe2.next = listNodeOpe3;
        listNodeOpe3.next = listNodeOpe4;

        ListNodeOpe all = new ListNodeOpe(0);
        all.head = listNodeOpe;

        ListNodeOpe node = all.head;

        while (node != null ) {
            System.out.println(node.val);
            node = node.next;
        }
        all.removeNode(7);

         node = all.head;

        while (node != null ) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNodeOpe(int val) {
        this.val = val;
    }

    public void removeNode(int value) {
        if (head == null) {
            return;
        }
        if (head.val == value) {
            head = head.next;
            return;
        }

        ListNodeOpe node = head.next;
        ListNodeOpe pre = head;

        while (node != null) {
            if (node.val == value) {
                pre.next = node.next;
                return;
            } else {
                node = node.next;
                pre = pre.next;
            }

        }
    }


}
