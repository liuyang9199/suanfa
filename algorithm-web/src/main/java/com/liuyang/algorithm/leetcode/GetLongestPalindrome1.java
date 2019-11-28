package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/7 上午11:13
 */
public class GetLongestPalindrome1 {

    public static void main(String[] args) {
        String s = "ac";

        GetLongestPalindrome1 getLongestPalindrome = new GetLongestPalindrome1();
        String t = getLongestPalindrome.longestPalindrome(s);
        System.out.println(t);
        /*boolean isHuiwen = isHuiwen(t);
        System.out.println(isHuiwen);*/
        /*String max = getMaxHuiwen(t);
        System.out.println("最大回文是" + max);*/
    }

    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


}
