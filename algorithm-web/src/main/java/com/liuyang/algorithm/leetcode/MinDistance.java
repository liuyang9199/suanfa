package com.liuyang.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/13 下午7:01
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        String word1 = "horse";
        String word2 = "ros";
        int min = minDistance.minDistance(word1, word2);

        /*Map resultMap = new HashMap();
        resultMap.put("str", "abcd");
        resultMap.put("times", 1);
        Map m = minDistance.useAfter(resultMap, "a", 2);
        System.out.println(m);*/

    }

    public int minDistance(String word1, String word2) {


        return 0;
    }

    private Map prefix(Map targetMap, String c, int index) {
        Map resultMap = new HashMap();
        resultMap.put("times", (Integer)targetMap.get("times") + 1);
        String before = (String)targetMap.get("str");
        String str = before.substring(0, index) + c + before.substring(index);
        resultMap.put("str", str);
        return resultMap;
    }

    private Map firstReplace(Map targetMap, String c, int index) {
        Map resultMap = new HashMap();
        resultMap.put("times", (Integer)targetMap.get("times"));
        String before = (String)targetMap.get("str");
        if (before == null || before.length() == 0) {
            resultMap.put("str", c);
        } else {
            if (String.valueOf(before.charAt(index)).equals(c)) {
                return targetMap;
            }
            if (index == 0) {
                String str = c + before.substring(index + 1);
                resultMap.put("str", str);
                resultMap.put("times", (Integer)targetMap.get("times") + 1);

            } else {
                String str = before.substring(0, index -1) + c + before.substring(index);
                resultMap.put("str", str);
                resultMap.put("times", (Integer)targetMap.get("times") + 1);

            }
        }
        return resultMap;
    }

    private Map useAfter(Map targetMap, String c, int index) {
        Map resultMap = new HashMap();
        String before = (String)targetMap.get("str");
        if (before == null || before.length() == 0) {
            resultMap.put("str", c);
            resultMap.put("times", (Integer)targetMap.get("times") + 1);
        } else {
            int find = before.indexOf(c, index);
            if (find == -1) {
                resultMap.put("times", (Integer)targetMap.get("times") + before.length() - index + 1);
                resultMap.put("str", before.substring(0, index) + c);
            } else {
                resultMap.put("times", (Integer)targetMap.get("times") + find - index);
                resultMap.put("str", before.substring(0, index) + before.substring(find));
            }
        }
        return resultMap;
    }

    /*
    i 目前字符串
    c 操作类型
    dp[i][c] -- map(次数,结果)
    dp[i][c1] = c1 + min(dp[i-1][c0],dp[i-1][c1],dp[i-1][c2])
    c1 : 次数+1 结果前面加i
    dp[i][c2] = c1 + min(dp[i-1][c0],dp[i-1][c1],dp[i-1][c2])
    c2 : 次数+1 结果位置为0的字符替换
    dp[i][c3] = c1 + min(dp[i-1][c0],dp[i-1][c1],dp[i-1][c2])
    c3 : 次数 = 次数 + 距离， 结果前面进行操作
     */
}
