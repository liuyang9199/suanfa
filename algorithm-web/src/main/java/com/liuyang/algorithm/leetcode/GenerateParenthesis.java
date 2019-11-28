package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/20 下午11:07
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> rlist = generateParenthesis.generateParenthesis(3);

        for (String s : rlist) {
            System.out.println(s);
        }

    }


    public List<String> generateParenthesis(int n) {
        List<String > rlist = new ArrayList<String>();
        if (n <= 0) return rlist;
        generateParenthesisCore(rlist, n, "");
        return rlist;

    }

    public void generateParenthesisCore(List<String> rlist, int n, String str) {
        if (str.length() == 2*n) {
            if (validate(n, str)) {
                rlist.add(str);
                return;
            }
            return;
        }
        generateParenthesisCore(rlist, n, str + "(");
        generateParenthesisCore(rlist, n, str + ")");

    }

    public boolean validate(int n, String str) {
        if (str.length() != 2*n) {
            return false;
        }
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i)) {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
