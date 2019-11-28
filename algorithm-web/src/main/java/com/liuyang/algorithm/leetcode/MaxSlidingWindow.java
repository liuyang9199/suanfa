package com.liuyang.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/18 下午11:10
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] r = maxSlidingWindow.maxSlidingWindow(new int[]{7,2,4}, 2);
        for (int i = 0 ; i < r.length ; i++) {
            System.out.println(r[i]);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0 || null == nums) {
            return new int[0];
        }

        if (nums.length == 1) return nums;

        Deque<Integer> deque = new ArrayDeque<Integer>();

        int[] r = new int[nums.length - k + 1];

        for (int i = 0 ; i < k; i++) {
            dequeCleanForInit(deque, nums, i, k);
            r[0] = nums[deque.getFirst()];
        }

        int fill = 1;
        for (int i = k; i < nums.length; i++) {
            dequeClean(deque, nums, i, k);
            if (deque.size() > 0) {
                r[fill++] = nums[deque.peekFirst()];
            }

        }
        return r;


    }

    public void dequeCleanForInit(Deque<Integer> deque, int[] nums, int comIndex, int k) {
        while (deque.size() > 0 && nums[comIndex] >= nums[deque.peekLast()]) {
            deque.removeLast();
        }
        deque.addLast(comIndex);
    }

    public void dequeClean(Deque<Integer> deque, int[] nums, int comIndex, int k) {
        if (deque.size() == 0) {
            deque.addLast(comIndex);
            return;
        }
        if (deque.peekFirst() <= (comIndex - k)  ) {
            deque.removeFirst();
        }
        while (deque.size() > 0 && nums[comIndex] >= nums[deque.peekLast()]) {
            deque.removeLast();
        }
        deque.addLast(comIndex);
    }


}
