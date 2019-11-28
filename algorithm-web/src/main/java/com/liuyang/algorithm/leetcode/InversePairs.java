package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class InversePairs {

    public static void main(String[] args) {
        InversePairs main = new InversePairs();
        main.doAction();
    }

    public void doAction() {
        int[] nums = new int[]{7,7,5,5};
        int x = inversePairs(nums);
        System.out.println(x);
    }

    public int inversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return inversePairsCore(nums, 0, nums.length - 1);
    }

    public int inversePairsCore(int[] nums, int left, int right) {

        if (left == right) return 0;

        int mid = left + ((right - left) >> 1);

        int leftCount = inversePairsCore(nums, left, mid);
        int rightCount = inversePairsCore(nums, mid+1, right);
        int count = 0;

        int p1 = mid;
        int p2 = right;
        int[] temp = new int[right - left + 1];
        int ti = temp.length -1;

        while (p1 >= left && p2 >= mid+1) {
            if (nums[p1] > nums[p2]) {
                count += p2 - mid;
                temp[ti--] = nums[p1--];

            } else {
                temp[ti--] = nums[p2--];
            }
        }

        while (p1 >= left) {
            temp[ti--] = nums[p1--];
        }

        while (p2 >= mid+1) {
            temp[ti--] = nums[p2--];
        }

        int x = left;
        for (int j = 0; j < temp.length; j++) {
            nums[x++] = temp[j];
        }
        return leftCount + rightCount + count;


    }

}
