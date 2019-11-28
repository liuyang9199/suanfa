package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/31 上午8:07
 */
public class Fib {


    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(7));
    }

    public int fib(int x) {
        if (x <= 0) return 0;
        if (x <= 2) return 1;
        int first = 1;
        int second = 1;
        int result = 2;
        int i = 3;
        while (i <= x) {
            result = first + second;
            first = second;
            second = result;
            i++;
        }
        return result;
    }

}
