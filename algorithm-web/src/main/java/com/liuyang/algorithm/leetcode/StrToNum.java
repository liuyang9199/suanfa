package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class StrToNum {

    public static void main(String[] args) {
        StrToNum main = new StrToNum();
        main.doAction();
    }

    public void doAction() {
        String str = "     -11009215950h";
        int x = myAtoi(str);
        System.out.println(x);
    }

    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!check(str)) return 0;
        boolean lessThanZero = false;
        int i = 0;
        if (String.valueOf(str.charAt(0)).equals("-") ) {
            lessThanZero = true;
            i = 1;
        } else if (String.valueOf(str.charAt(0)).equals("+") ) {
            lessThanZero = false;
            i = 1;
        }
        int result = 0;
        int len = str.length();
        for (; i< len; i++ ) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int temp = c - '0';
                if (lessThanZero) {
                    temp = 0 - temp;
                }
                if (tooMany(result, temp)) {
                    if (lessThanZero) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    result = result * 10 + temp;
                }
            } else {
                return result;
            }
        }
        return result;

    }

    public boolean check(String str) {
        int index = 0;
        if (String.valueOf(str.charAt(0)).equals("-") || String.valueOf(str.charAt(0)).equals("+") ) {
            if (str.length() < 2) return false;
            if (str.charAt(1) >= '0' && str.charAt(1) <= '9') return true;
        } else {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') return true;
        }
        return false;
    }

    public boolean tooMany(int curr, int temp) {
        if (curr > Integer.MAX_VALUE / 10 || (curr == Integer.MAX_VALUE / 10 && temp > 7)) {
            return true;
        }
        if (curr < Integer.MIN_VALUE / 10 || (curr == Integer.MIN_VALUE / 10 && temp < -8)) {
            return true;
        }

        return false;
    }
}
