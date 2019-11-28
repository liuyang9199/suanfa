package com.liuyang.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/3 下午11:08
 */
public class MinK1 {

    public static void main(String[] args) {
        MinK1 quickSort1 = new MinK1();
        int[] nums = new int[]{8,2,7,6,9,1,33,4,3,4,5,4,5};

        quickSort1.quick(nums, 0, nums.length -1, 5);
        //System.out.println(x);
       /* for (int i : nums) {
            System.out.print(i);
            System.out.print(" ");

        }*/
    }


    public void quick(int[] nums, int left, int right, int k) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, comparator);
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
                continue;
            }

            if (pq.element() > nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            System.out.println(i);
        }

    }


}
