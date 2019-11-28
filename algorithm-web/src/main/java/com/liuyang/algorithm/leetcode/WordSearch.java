package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/23 上午8:27
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();


        char[][] out = new char[3][4];
        out[0] = new char[]{'A', 'B', 'C', 'E'};
        out[1] = new char[]{'S', 'F', 'C', 'S'};
        out[2] = new char[]{'A', 'D', 'E', 'E'};

        boolean b = wordSearch.exist(out, "SEE");
        System.out.println(b);
    }


    Map<String, Boolean> map = new HashMap<String, Boolean>();
    int[] rowmove = new int[]{-1, 1, 0, 0};
    int[] columnmove = new int[]{0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        if (null == board) return false;
        if (null == word || word.length() == 0) return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    if (solution(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solution(char[][] board, String word, int step, int nextrow, int nextcolumn) {

        if (nextrow >= board.length || nextrow < 0) {
            return false;
        }
        if (nextcolumn >= board[nextrow].length || nextcolumn < 0 ) {
            return false;
        }



        if (map.get(nextrow + "-" + nextcolumn) != null && map.get(nextrow + "-" + nextcolumn) == true) {
            return false;
        }

        if (board[nextrow][nextcolumn] != word.charAt(step)) {
            return false;
        }

        map.put(nextrow + "-" + nextcolumn, true);

        if (step +1 >= word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextrow1 = nextrow + rowmove[i];
            int nextcolumn1 = nextcolumn + columnmove[i];
            if (solution(board, word, step + 1, nextrow1, nextcolumn1)) {
                return true;
            }
        }
        map.put(nextrow + "-" + nextcolumn, false);
        return false;
    }
}
