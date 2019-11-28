package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/13 下午3:25
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();

        int[] nums = new int[] {10,9,2,5,3,7,101,18};

        int max = lengthOfLIS.lengthOfLIS(nums);

        System.out.println(max);

    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            int temp = 0;

            for (int j = i-1 ; j >= 0 ; j--) {
               if (nums[i] > nums[j]) {
                   temp = Math.max(temp, lis[j]);
               }
            }
            temp = temp + 1;
            lis[i] = temp;
            max = Math.max(max, temp);
        }

        return max;
    }

    /**

     int max = 1;
     lis[i] 存储 当 计算到arr[i] 时上升子序列的最大长度

     dp(i) =
     for (j = i ; j > 0 ; j--) {

     }





     */


}
