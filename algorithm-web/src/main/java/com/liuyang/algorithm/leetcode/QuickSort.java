package com.liuyang.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/18 上午8:55
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 2};

        QuickSort quickSort = new QuickSort();
/*
        for (int i = 0 ; i< nums.length ; i++) {
            System.out.println(nums[i]);
        }*/

        quickSort.kthLargest(3, nums);
        int x = quickSort.add(3);
        System.out.println(x);

        x = quickSort.add(5);
        System.out.println(x);

        x = quickSort.add(10);
        System.out.println(x);

        x = quickSort.add(9);
        System.out.println(x);

        x = quickSort.add(4);
        System.out.println(x);
    }

    private int topk = 0;
    private Queue<Integer> queue = null;

    public void kthLargest(int k, int[] nums) {
        this.topk = k;
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        queue = new PriorityQueue<Integer>(k, com);
        for (Integer i : nums) {
            add(i);
        }

    }

    public int add(int val) {

        if (queue.size() < topk) {
            queue.add(val);
            return 0;
        } else {
            if (queue.peek() >= val) {
                return queue.peek();
            } else {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        }

    }


}
