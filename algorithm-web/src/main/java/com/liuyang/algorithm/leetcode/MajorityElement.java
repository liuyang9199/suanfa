package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/20 下午2:55
 */
public class MajorityElement {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,4,5,6,4,4,4,4};

        MajorityElement majorityElement= new MajorityElement();
        int r = majorityElement.majorityElement(nums);
        System.out.println(r);
    }
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int i : nums) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;

    }
}
