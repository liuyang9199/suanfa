package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/5 上午8:03
 */
public class NumToStr {

    public static void main(String[] args) {
        NumToStr numToStr = new NumToStr();
        numToStr.numDecodings("12");
    }

    Map<String,String> map = new HashMap<String,String>();
    int count = 0;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 1; i < 27; i++) {
            map.put(i+"", i+"");
        }

        numDecodingsCore(s, 1, 0);
        numDecodingsCore(s, 2, 0);

        return count;

    }

    public int numDecodingsCore(String s, int size, int path) {
        if (path + size > s.length()) return 0;

        if (map.get(s.substring(path, path + size)) != null) return 0;

        if (path + size == s.length() ) {
            count++;
            return 0;
        }

        numDecodingsCore(s, 1, path + size);
        numDecodingsCore(s, 2, path + size);
        return 0;
    }
}
