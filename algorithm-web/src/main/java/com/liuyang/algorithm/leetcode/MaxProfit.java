package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/20 下午3:33
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int maxProfitMoney = maxProfit.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(maxProfitMoney);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] profit = new int[len][2];
        int[] firstDay = new int[]{-7, 0};
        profit[0] = firstDay;
        for (int i = 1; i < len; i++) {
            int[] yesterday = profit[i-1];
            int[] day = new int[2];
            day[0] = Math.max(yesterday[0], yesterday[1] - prices[i]);
            day[1] = Math.max(yesterday[1], yesterday[0] + prices[i]);
            profit[i] = day;
        }
        return profit[len-1][1];
    }

}
