package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/21 下午6:44
 */
public class SudokuCheck {

    public static void main(String[] args) {

        int x = (int)'9';
        System.out.println(x);

        SudokuCheck m = new SudokuCheck();

        char[][] board = new char[9][9];

        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};

        boolean b = m.isValidSudoku(board);

        System.out.println(b);

    }

    public boolean isValidSudoku(char[][] board) {
        int[] rowCnt = new int[9];
        int[] colCnt = new int[9];
        int[] boxCnt = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int num = board[i][j] - 48;
                // 处理行
                if ((rowCnt[i] >> num) % 2 == 1) {
                    return false;
                } else {
                    rowCnt[i] += 1 << num;
                }
                // 处理列
                if ((colCnt[j] >> num) % 2 == 1) {
                    return false;
                } else {
                    colCnt[j] += 1 << num;
                }
                // 处理框
                int boxNum = i / 3 * 3 + j / 3;
                if ((boxCnt[boxNum] >> num) % 2 == 1) {
                    return false;
                } else {
                    boxCnt[boxNum] += 1 << num;
                }
            }

        }
        return true;
    }
}
