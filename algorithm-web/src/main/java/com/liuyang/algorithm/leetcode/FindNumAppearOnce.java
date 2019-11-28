package com.liuyang.algorithm.leetcode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/19 上午7:06
 */
public class FindNumAppearOnce {

    public static void main(String[] args) {
        FindNumAppearOnce main = new FindNumAppearOnce();
        main.doAction();
    }

    public void doAction() {
        int[] nums = new int[]{2,4,7,2,4,7,6,9,8,9};

        int[] r = findNumAppearOnce(nums);

        //Arrays.asList(r).stream().forEach(x -> System.out.println(x) );

        for (int i : r) {
            System.out.println(i);
        }

    }

    public int[] findNumAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) return null;
        int x = 0;
        for (int i : nums) {
            x = x ^ i;
        }

        int min1Index = findMin1Index(x);
        int y = 0;
        int z = 0;

        for (int i : nums) {
            if (isNubmerOne(i, min1Index)) {
                y = y ^ i;
            } else {
                z = z ^ i;
            }
        }
        int[] r = new int[]{y, z};
        return r;
    }

    public int findMin1Index(int x) {
        int i = x & (-x);

        int index = 0;
        while (i != 0) {
            index++;
            i = i >>1;
        }
        return index-1;
    }

    public boolean isNubmerOne(int x, int index) {
        x = x >> index;
        int y = x & 1;
        return y == 1;
    }


}
