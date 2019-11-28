package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/27 下午1:28
 */
public class NumIslands {

    public class UnionFind{
        private int count;
        private int[] rank;
        private int[] parent;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            count = 0;
            rank = new int[m*n];
            parent = new int[m*n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        rank[i * n + j] = 0;
                        parent[i * n + j] = i * n + j;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x != y) {
               if (rank[x] == rank[y]) {
                   parent[x] = y;
                   rank[y] += 1;
               } else if (rank[x] > rank[y]) {
                   parent[y] = x;
               } else {
                   parent[x] = y;
               }
                --count;
            }
        }

        public int getCount() {
            return count;
        }

    }

    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    int m;
    int n;


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(grid);
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {

                    for (int d = 0; d < 4; d++) {
                        int newi = i + direction[d][0];
                        int newj = j + direction[d][1];
                        if (checkArea(newi,newj) && grid[newi][newj] == '1') {
                            unionFind.union(i * n + j, newi * n + newj);
                        }
                    }

                }
            }
        }
        return unionFind.getCount();
    }

    public boolean checkArea(int i, int j) {
        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] grid = new char[4][];

        char[] row0 = {'1','1','1','1','0'};
        char[] row1 = {'1','1','0','1','0'};
        char[] row2 = {'1','1','0','0','0'};
        char[] row3 = {'0','0','0','0','1'};

        grid[0] = row0;
        grid[1] = row1;
        grid[2] = row2;
        grid[3] = row3;


        NumIslands numIslands = new NumIslands();
        int c = numIslands.numIslands(grid);
        System.out.println(c);

    }

}
