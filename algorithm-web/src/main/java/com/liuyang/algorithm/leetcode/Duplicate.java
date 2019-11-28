package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/27 下午9:36
 */
public class Duplicate {

    public static void main(String[] args) {

        int[] nums = {4,3,1,5,2,5,3};

        Duplicate duplicate = new Duplicate();
        int r = duplicate.getDuplicate(nums);
        System.out.println(r);
    }

    public int getDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int val = nums[i];

            while (val != i) {
                int temp = nums[val];


                if (nums[temp] == temp) {
                    return temp;
                }

                nums[val] = val;
                val = temp;
            }
            nums[i] = val;
        }
        return -1;
    }
}
