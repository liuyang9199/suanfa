package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/6 上午8:02
 */
public class MaxValue {


    public static void main(String[] args) {
        int[][] nums = new int[4][];
        nums[0] = new int[]{1, 10, 3, 8};
        nums[1] = new int[]{12, 2, 9, 6};
        nums[2] = new int[]{5, 7, 4, 11};
        nums[3] = new int[]{3, 7, 16, 5};

        MaxValue maxValue = new MaxValue();
        int i = maxValue.getMaxValue(nums);
        System.out.println(i);

    }

    public int getMaxValue(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int[] values = new int[n];

        for (int i = 0; i < m ;i++) {
            for (int j = 0; j < n; j ++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = values[j];
                }

                if (j > 0) {
                    left = values[j-1];
                }

                    values[j] = Math.max(left,up)+ nums[i][j];


            }
        }
        return values[n-1];
    }

}
