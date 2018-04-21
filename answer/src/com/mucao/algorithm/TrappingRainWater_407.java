package com.mucao.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目407，题目内容地址：https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * 这个是参考的dicussion上的答案
 * 基本思想就是，先围一堵墙，然后找到墙最低的地方，如果漏水一定是从最低的地方漏水的。然后墙不停的往里面缩小范围，就可以找到可以
 * 储水的地方了。
 *
 * 启发：构思算法的时候，最开始不要想的太细致了，不要去想程序的实现，就想现实情况下，这个问题会怎么解决。最多结合一下算法思想，
 * 动态规划，分治等的策略。
 *
 */
public class TrappingRainWater_407 {

    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
        // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  //上下左右四个方向
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }

        return res;
    }

}
