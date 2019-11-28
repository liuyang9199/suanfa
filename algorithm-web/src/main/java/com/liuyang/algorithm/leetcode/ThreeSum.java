package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/19 下午1:00
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List list = threeSum.threeSum(new int[]{0,0,0,0});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return resultList;
        }

        // init cache map
        int len = nums.length;
        Map<Integer,List<Integer>> cacheMap = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> tl = cacheMap.get(n);
            if (tl == null) {
                tl = new ArrayList<Integer>();
            }
            tl.add(i);
            cacheMap.put(n, tl);
        }

        // loop find
        for (int i = 0; i < len - 2; i++) {
            int first = nums[i];
            for (int k = i + 1; k < len - 1; k++) {
                int second = nums[k];
                int targetVal = -first-second;
                List<Integer> targetList = cacheMap.get(targetVal);
                if (targetList == null || targetList.size() == 0) {
                    continue;
                }
                for (Integer j : targetList) {
                    if (j < i) {
                        break;
                    }
                    if (j > k) {
                        List<Integer> record = new ArrayList<Integer>();
                        record.add(nums[i]);
                        record.add(nums[k]);
                        record.add(nums[j]);
                        resultList.add(record);
                        break;
                    }
                }
            }
        }

        return resultList;
    }
}
