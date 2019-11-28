package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class MaxNotRepeatStr {

    public static void main(String[] args) {
        MaxNotRepeatStr main = new MaxNotRepeatStr();
        String s = "aabac";
        int i = main.doAction(s);
        System.out.println(i);
    }

    public int doAction(String str) {
        if (str == null || str.length() ==0) return 0;
        int max = 1;
        String curr = "";

        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            int index = curr.indexOf(s);
            if (index == -1) {
                curr += s;
                max = Math.max(max, curr.length());
            } else if (index == curr.length() - 1) {
                curr = s;
            } else {
                curr = curr.substring(index + 1) + s;
            }
        }
        return max;
    }

}
