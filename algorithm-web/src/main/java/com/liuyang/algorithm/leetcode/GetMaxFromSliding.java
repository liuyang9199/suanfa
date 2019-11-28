package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class GetMaxFromSliding {

    public static void main(String[] args) {
        GetMaxFromSliding main = new GetMaxFromSliding();
        main.doAction();
    }

    public void doAction() {
        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        List<Integer> list = getMaxFromSliding(nums, 3);
        for (Integer i :  list) {
            System.out.println(i);
        }
    }

    public List getMaxFromSliding(int[] nums, int size) {
        if (nums == null || nums.length ==0 || size <1) return null;
        int count = 0;
        List<Integer> results = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        for (int i =0; i< nums.length; i++) {
            if(i < size-1) {
                count = putElement(deque, nums[i], count);
                continue;
            }
            count = putElement(deque, nums[i], count);
            results.add(deque.getFirst());
            //if (count == size) {
                deque.removeFirst();
            //}
        }

        return results;

    }

    public int putElement(Deque<Integer> deque, int num, int count) {
        if (deque.size() == 0) {
            deque.add(num);
            return 1;
        }

        int removecount = 0;

        while(deque.size() > 0 && deque.getLast() < num) {
            deque.removeLast();
            removecount = removecount +1;
        }
        deque.addLast(num);

        for (int i = 0; i < removecount; i++) {
            deque.addLast(num);
        }

        return count+1;
    }


}
