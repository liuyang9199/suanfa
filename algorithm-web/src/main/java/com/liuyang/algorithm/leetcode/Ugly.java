package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class Ugly {

    public static void main(String[] args) {
        Ugly main = new Ugly();
        main.doAction();
    }

    public void doAction() {
        int x = nthUglyNumber(10);
        System.out.println(x);
    }

    public int nthUglyNumber(int n) {
        if (n < 1) return 0;

        int[] uglys = new int[n];
        uglys[0] = 1;
        int curr2 = 0;
        int curr3 = 0;
        int curr5 = 0;
        int number = 1;
        int count = 0;

        while (count < n-1) {
            while (uglys[curr2] * 2 <= number) {
                curr2++;
            }
            while (uglys[curr3] * 3 <= number) {
                curr3++;
            }
            while (uglys[curr5] * 5 <= number) {
                curr5++;
            }

            number = min(uglys[curr2] * 2, uglys[curr3] * 3, uglys[curr5] * 5);


            count++;
            uglys[count] = number;
        }
        return uglys[n-1];
    }

    public int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

}
