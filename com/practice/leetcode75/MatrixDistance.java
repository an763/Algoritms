package com.practice.leetcode75;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class MatrixDistance {
    /**
     * Finds the distance of the nearest 0 for each cell in a binary matrix.
     *
     * @param mat The input m x n binary matrix.
     * @return A matrix of the same dimensions where each cell contains the distance
     * to the nearest 0.
     */
    public int[][] updateMatrix(int[][] mat) {
        // Handle edge case of an empty or null matrix
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }


        int rows = mat.length;
        int cols = mat[0].length;

        // Queue for BFS, storing coordinates {row, col}
        Queue<int[]> queue = new LinkedList<>();

        // Result matrix to store distances
        int[][] distance = new int[rows][cols];

        // 1. Initialization:
        //    - Add all '0' cells to the queue as starting points for the BFS.
        //    - Mark '1' cells as unvisited by setting their distance to -1.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1; // Mark as unvisited
                }
            }
        }

        // Directions for moving to neighbors (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 2. BFS Processing:
        //    - Process cells layer by layer starting from all 0s.
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // Check if the neighbor is valid (within bounds) and unvisited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && distance[newRow][newCol] == -1) {
                    // Update distance and add neighbor to the queue for future processing
                    distance[newRow][newCol] = distance[r][c] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        String x = "abcdefg";
       int start = 0;
       int max_length = 0;

      // map(a,0) , map(b,1), .....map(b, 5),


        // 3. Return the completed distance matrix
        return distance;
    }
}
