package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort main = new MergeSort();
        main.doAction();
    }

    public void doAction() {
        int[] nums = new int[]{2,4,7,2,5,9,1,3,6,4};
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);

    }

    public void sort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >>2 );
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int ti = 0;
        while (p1 <= mid && p2 <= right) {
            temp[ti++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid) {
            temp[ti++] = nums[p1++];
        }

        while (p2 <= right) {
            temp[ti++] = nums[p2++];
        }

        int x = left;
        for (int j = 0; j < temp.length; j++) {
            nums[left++] = temp[j];
        }


    }

}
