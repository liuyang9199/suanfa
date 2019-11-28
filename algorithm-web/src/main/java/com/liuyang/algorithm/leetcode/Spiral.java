package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/2 下午2:06
 */
public class Spiral {

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int[][] nums = new int[4][];
        nums[0] = new int[]{1, 2, 3, 4};
        nums[1] = new int[]{5, 6, 7, 8};
        nums[2] = new int[]{9, 10, 11, 12};
        nums[3] = new int[]{13, 14, 15, 16};

        spiral.spiralOrder(nums);


    }

    public int maxrow;
    public int minrow;
    public int maxcolumn;
    public int mincolumn;
    public List<Integer> list = new ArrayList<Integer>();

    public List<Integer> spiralOrder(int[][] nums){

        if (nums == null || nums.length ==0) {
            return list;
        }

        maxrow = nums.length - 1;
        minrow = 0;
        maxcolumn = nums[0].length - 1;
        mincolumn = 0;
        int row = 0;
        int column = -1;
        int[][] dire = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;

        while (minrow <= maxrow || mincolumn <= maxcolumn) {
            int newrow = row + dire[d][0];
            int newcolumn = column + dire[d][1];
            if (!check(newrow, newcolumn)) {
                rejectCheck(d);
                d = (d+1)%4;
                continue;
            }

            row = newrow;
            column = newcolumn;
            list.add(nums[row][column]);
        }

        return list;
    }

    public boolean check(int row, int column) {
        if (row <= maxrow && row>= minrow && column <=maxcolumn && column >= mincolumn) {
            return true;
        }
        return false;
    }

    public void rejectCheck(int d) {
        if (d==0) minrow++;
        if (d==1) maxcolumn--;
        if (d==2) maxrow--;
        if (d==3) mincolumn++;
    }

}
