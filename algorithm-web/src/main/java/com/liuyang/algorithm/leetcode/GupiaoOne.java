package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class GupiaoOne {

    public static void main(String[] args) {
        GupiaoOne main = new GupiaoOne();
        main.doAction();
    }

    public void doAction() {
        int[] nums = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        int maxProfit = getMaxProfitOneBuy2(nums);
        System.out.println(maxProfit);
    }

    public int getMaxProfitOneBuy(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[][][] fn = new int[nums.length][2][2];//天数、是否持有（0-非持有1-持有）、交易次数(0/1)

        fn[0][0][0] = 0;
        fn[0][1][0] = 0 - nums[0];
        fn[0][0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            fn[i][0][0] = fn[i-1][0][0];
            fn[i][0][1] = Math.max(
                    fn[i-1][0][1],
                    fn[i-1][1][0] + nums[i]
            );
            fn[i][1][0] = Math.max(
                    fn[i-1][1][0],
                    fn[i-1][0][0] - nums[i]
            );
        }

        return Math.max(
                fn[nums.length-1][0][0],
                fn[nums.length-1][0][1]
        );
    }


    //使用非动态规划解决
    public int getMaxProfitOneBuy2(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0;
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            max = Math.max(max, curr - start);
            if (curr < start) {
                start = curr;
            }
        }

        return max;

    }

}
