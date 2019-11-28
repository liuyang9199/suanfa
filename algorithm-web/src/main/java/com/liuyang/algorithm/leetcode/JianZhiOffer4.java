package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/29 上午7:27
 */
public class JianZhiOffer4 {

    public static void main(String[] args) {
        JianZhiOffer4 jianZhiOffer4 = new JianZhiOffer4();
        int[][] nums = new int[4][];
        nums[0] = new int[]{1, 2, 8, 9};
        nums[1] = new int[]{2,4,9,12};
        nums[2] = new int[]{4,7,10,13};
        nums[3] = new int[]{6,8,11,15};
        boolean b = jianZhiOffer4.isExist(nums,14);
        System.out.println(b);

        nums = null;
        jianZhiOffer4.doClear(nums);
        if (nums == null) {
            System.out.println("nullllllll");
        }


    }

    public void doClear(int[][] nums) {
        nums = new int[3][3];
    }

    public boolean isExist(int[][] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int rowtotal = nums.length - 1;
        int coltotal = nums[0].length -1;

        int row = rowtotal;
        int col = 0;
        while (row >=0 && col <= coltotal) {
            if (nums[row][col] > target) {
                row--;
            } else if (nums[row][col] < target){
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
