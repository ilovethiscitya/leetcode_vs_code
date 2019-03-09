/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (46.49%)
 * Total Accepted:    227.6K
 * Total Submissions: 485.1K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * 
 * Given input matrix = 
 * [
 * ⁠ [1,2,3],
 * ⁠ [4,5,6],
 * ⁠ [7,8,9]
 * ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [7,4,1],
 * ⁠ [8,5,2],
 * ⁠ [9,6,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Given input matrix =
 * [
 * ⁠ [ 5, 1, 9,11],
 * ⁠ [ 2, 4, 8,10],
 * ⁠ [13, 3, 6, 7],
 * ⁠ [15,14,12,16]
 * ], 
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [15,13, 2, 5],
 * ⁠ [14, 3, 4, 1],
 * ⁠ [12, 6, 8, 9],
 * ⁠ [16, 7,10,11]
 * ]
 * 5 2 13 15
 * 1 4 3  14
 * 9 8 6  12
 * 11 10 7 16
 * 
 */
class Solution {
    public void rotate(int[][] matrix) {
        // if(matrix == null || matrix.length <= 1) return;
        // int n = matrix.length;
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         int temp = matrix[j][i];
        //         matrix[j][i] = matrix[i][j];
        //         matrix[i][j] = temp;
        //     }
        // }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n / 2; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][n - j - 1];
        //         matrix[i][n - j - 1] = temp;
        //     }
        // }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows / 2; i++) {
            for(int j = i; j < matrix.length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows - 1 - j][i];
                matrix[rows - 1 - j][i] = matrix[rows - 1 - i][rows - 1 - j];
                matrix[rows - 1 - i][rows - 1 - j] = matrix[j][rows - 1 - i];
                matrix[j][rows - 1 - i] = temp;
            }
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows / 2; i++) {
            for(int j = i; j < matrix.length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows - 1 - j][i];
                matrix[rows - 1 - j][i] = matrix[rows - 1 - i][rows - 1 - j];
                matrix[rows - 1 - i][rows - 1 - j] = matrix[j][rows - 1 - i];
                matrix[j][rows - 1 - i] = temp;
            }
        }
    }
}

