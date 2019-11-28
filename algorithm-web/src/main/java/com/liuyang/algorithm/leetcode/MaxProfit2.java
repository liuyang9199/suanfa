package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/26 下午3:13
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int k = 1000000000;
        int max = maxProfit2.maxProfit(k, prices);
        System.out.println(max);

    }



    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;    // 最大收益
        int len = prices.length;
        int times = k > len /2 ? len /2 : k;

        int[][][] dp = new int[len][times][2];

        for (int i = 0; i < times; i++) {
            dp[0][i][0] = 0 - prices[0];
            dp[0][i][1] = 0;
        }

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = Math.max(0 - prices[i], dp[i-1][0][0]);
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] + prices[i]);
            max = Math.max(max, dp[i][0][1]);

            for (int j = 1; j < times; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] - prices[i]);

                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] + prices[i]);
                max = Math.max(max,dp[i][j][1]);
            }
        }
        return max;



    }
}
