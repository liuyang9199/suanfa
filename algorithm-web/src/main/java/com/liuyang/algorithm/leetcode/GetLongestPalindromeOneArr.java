package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/7 上午11:13
 */
public class GetLongestPalindromeOneArr {

    public static void main(String[] args) {
        String s = "cb";

        GetLongestPalindromeOneArr getLongestPalindrome = new GetLongestPalindromeOneArr();
        String t = getLongestPalindrome.longestPalindrome(s);
        System.out.println(t);
        /*boolean isHuiwen = isHuiwen(t);
        System.out.println(isHuiwen);*/
        /*String max = getMaxHuiwen(t);
        System.out.println("最大回文是" + max);*/
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        /*if (s.length() <= 2) {
            return s;
        }*/
        int maxCnt = 1;
        String maxStr = s.substring(0, 1);
        String rev = new StringBuffer(s).reverse().toString();
        int length = rev.length();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            Character ci = s.charAt(i);
            for (int j = length - 1; j >= 0; j--) {
                int cnt = 0;
                Character cj = rev.charAt(j);
                if (ci.equals(cj)) {
                    if (i == 0 || j == 0) {
                        cnt = 1;
                    } else {
                        cnt = arr[j-1] + 1;
                    }
                }
                arr[j] = cnt;
                if (cnt > maxCnt) {
                    int beforeRevIndex = length - j - 1;
                    if (beforeRevIndex + cnt -1 == i ) {
                        maxCnt = cnt;
                        maxStr = s.substring(i - cnt + 1, i + 1);
                    }
                }
            }
        }
        return maxStr;
    }

    public static boolean isHuiwen(String target) {
        if (target == null) {
            return false;
        }
        for (int i = 0 ; i < target.length() / 2; i++) {
            Character before = target.charAt(i);
            if (!before.equals(target.charAt(target.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }

}
