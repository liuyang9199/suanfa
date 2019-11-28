package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/27 下午9:36
 */
public class DuplicateNoOtherKongjian {

    public static void main(String[] args) {

        int[] nums = {4,3,1,5,2,6,6};

        DuplicateNoOtherKongjian duplicate = new DuplicateNoOtherKongjian();
        int r = duplicate.getDuplicate(nums);
        System.out.println(r);
    }

    public int getDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int len = nums.length;

        int start = 1;
        int end = len - 1;
        int count = 0;

        while (start < end) {
            int mid = start + (end - start) /2;
            count = 0;
            for (int i =0; i < len; i++) {
                if (nums[i] >= start && nums[i] <= mid) {
                    count++;
                }


            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (count > 0) {
            return start;
        }
        return -1;


    }
}
