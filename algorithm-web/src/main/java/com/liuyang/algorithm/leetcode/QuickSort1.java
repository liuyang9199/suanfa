package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/3 下午11:08
 */
public class QuickSort1 {

    public static void main(String[] args) {
        QuickSort1 quickSort1 = new QuickSort1();
        int[] nums = new int[]{1,2,1,2,3,1,2,1,3,2,1,2,3};

        quickSort1.quick(nums, 0, nums.length -1);
        //System.out.println(x);
        for (int i : nums) {
            System.out.print(i);
            System.out.print(" ");

        }
    }


    public void quick(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = partion(nums, left, right);

        if (mid > left) {
            quick(nums, left, mid -1);
        }

        if (mid < right) {
            quick(nums, mid + 1, right);
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
