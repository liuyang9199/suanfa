package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/4 上午11:27
 */
public class CreateIndex {

    public static void main(String[] args) {
        String x = "create unique index uniq_idx_waybill_id_version on passenger_trail_bill";
        String y = "(waybill_id,version);";
        for (int i = 0; i <= 99 ; i++) {
            String z = x + "_" + i + y;
            System.out.println(z);
        }
    }

}
