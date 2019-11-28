package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/21 上午8:29
 */
public class SolveNQueens {

    public static void main(String[] args) {
        int n = 4;
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> rList = solveNQueens.solveNQueens(n);
        int i = 1;
        for (List<String> list : rList) {
            System.out.println("方案" + i++);

            for (String s : list) {
                System.out.print(s);
                System.out.println();

            }
        }
    }

    List<List<String>> rlist = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {

        if (n <= 2) {
            return rlist;
        }

        solveCore(new String[n][n], 0, n) ;


        return rlist;
    }

    public void solveCore(String[][] solution, int currLine, int n) {


        if (currLine >= n) {
            rlist.add(getArrString(solution));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(solution, currLine, i)) {
                solution[currLine][i] = "Q";
                solveCore(solution, currLine + 1, n);
                solution[currLine][i] = ".";
            } else {
                solution[currLine][i] = ".";
            }
        }

    }

    public boolean check(String[][] solution, int currLine, int currRow) {
        int len = solution.length;
        for (int i = 0; i < len; i++) {
            if ("Q".equals(solution[currLine][i])) {
                return false;
            }

            if ("Q".equals(solution[i][currRow])) {
                return false;
            }

            for (int j =0; j < len; j++) {
                if ("Q".equals(solution[i][j]) && ((j + i) == (currRow + currLine))) {
                    return false;
                }
                if ("Q".equals(solution[i][j]) && ((j - i) == (currRow - currLine))) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<String> getArrString(String[][] solution) {

        List<String> record = new ArrayList<String>();
        for (int i = 0; i < solution.length; i++) {
            String str = "";
            for (int j = 0; j < solution.length; j++) {
                str = str + (solution[i][j] == null ? "." : solution[i][j]);
            }
            record.add(str);
        }

        return record;
    }






}
