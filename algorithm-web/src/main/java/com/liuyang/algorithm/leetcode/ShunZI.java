package com.liuyang.algorithm.leetcode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class ShunZI {

    public static void main(String[] args) {
        ShunZI main = new ShunZI();
        main.doAction();
    }

    public void doAction() {
        String[] parArr = new String[] {"W", "W", "7", "9", "5"};
        boolean b = isShunzi(parArr);
        System.out.println(b);
    }

    public boolean isShunzi(String[] paiArr) {

        int[] nums = new int[5];
        int numSize = 0;
        int wSize = 0;

        for (int i = 0; i < paiArr.length; i++) {
            int n = convertToNumber(paiArr[i]);
            if (isWang(n)) {
                wSize++;
            } else {
                nums[numSize] = n;
                numSize++;
            }
        }

        Arrays.sort(nums);

        int gapSize = 0;

        for (int i = 3; i >= 0; i--) {
            if (nums[i+1] == 0 || nums[i] == 0) {
                continue;
            }
            gapSize += nums[i+1] - nums[i]- 1;
        }

        if (gapSize > wSize) {
            return false;
        }


        return true;
    }

    private boolean isWang(int s) {
        if (s == 0) {
            return true;
        }
        return false;
    }

    private int convertToNumber(String s) {
        if (s.equals("J")) {
            return 11;
        } else if (s.equals("Q")) {
            return 12;
        } else if (s.equals("K")) {
            return 13;
        } else if (s.equals("W")) {
            return 0;
        }

        return Integer.parseInt(s);
    }

}
