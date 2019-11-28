package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/3 下午11:08
 */
public class MinK {

    public static void main(String[] args) {
        MinK quickSort1 = new MinK();
        int[] nums = new int[]{8,2,7,6,9,1,33,4,3,4,5,4,5};

        quickSort1.quick(nums, 0, nums.length -1, 2);
        //System.out.println(x);
        for (int i : nums) {
            System.out.print(i);
            System.out.print(" ");

        }
    }


    public void quick(int[] nums, int left, int right, int k) {

        if (left >=  right) {
            return;
        }

        int mid = partion(nums, left, right);
        if (mid == k) {
            return;
        }
        if (mid >k) {
            quick(nums, left, mid -1, k);
        } else {
            quick(nums, mid + 1, right, k);
        }


    }

    public int partion(int[] nums, int left, int right) {
        int tar = nums[left];
        int partion = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= tar) {
                partion++;
                swap(nums, partion, i);
            }
        }

        swap(nums, partion, left);
        return partion;
    }

    public void swap(int[] nums, int tar, int sou) {
        int temp = nums[tar];
        nums[tar] = nums[sou];
        nums[sou] = temp;
     }


}
