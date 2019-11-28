package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class ReverseNumber {

    public static void main(String[] args) {
        ReverseNumber main = new ReverseNumber();
        main.doAction();
    }

    public void doAction() {
        reverse(-2147483648);
    }

    public int reverse(int x) {
        int y = x;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop;
        }

        return rev;

    }

}
