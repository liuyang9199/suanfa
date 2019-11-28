package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/22 下午6:58
 */
public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int s = mySqrt.mySqrt(2147483647);
        System.out.println(s);
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1;
        int end = x;
        int mid = 1;

        while(start <= end) {
            mid = start + (end - start)/2;
            int result = x / mid;
            if ( result == mid) {
                return mid;
            } else if (result < mid) {
                end = (end == mid ? end -1 : mid);
            } else {
                start = (start == mid ? start + 1 : mid);

            }


        }
        return x / mid < mid ? (mid - 1) : mid;
    }
}
