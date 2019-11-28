package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class GetSumForArr {

    public static void main(String[] args) {
        GetSumForArr main = new GetSumForArr();
        main.doAction();
    }

    public void doAction() {
        List<int[]> list = getSumForArr(15);
        for (int[] nums : list) {
            System.out.println(nums[0] + "~" + nums[1]);
        }

    }


    public List getSumForArr(int target) {
        List<int[]> list = new ArrayList<>();
        if (target < 3) return list;
        int left = 1;
        int right = 2;
        int total = 3;
        while (left < right && left + right <= target) {
            if (total == target) {
                list.add(new int[]{left, right});
                right++;
                total = total + right - left;
                left++;
            } else if (total > target) {
                total = total - left;
                left++;
            } else {
                right++;
                total = total + right;
            }
        }
        return list;
    }
}
